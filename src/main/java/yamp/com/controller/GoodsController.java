package yamp.com.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import yamp.com.common.ResponseJsonPageListBean;
import yamp.com.mapper.GoodsMapper;
import yamp.com.model.Goods;
import yamp.com.model.GoodsExample;
import yamp.com.model.SysUser;
import yamp.com.util.DateUtil;
import yamp.com.util.JsonPrintUtil;



@Controller
@RequestMapping("goods")
public class GoodsController extends UploadController {
  @Autowired
  private GoodsMapper goodsMapper;

  // ��Ʒ�б��ҳ��ѯ
 	@RequestMapping("list")
 	@ResponseBody
 	public void getList(HttpServletRequest request, HttpServletResponse response, String keywords,int limit,
 			int page) {
 		// limit ÿҳ��ʾ����
 		// page ��ǰҳ��
 		GoodsExample example = new GoodsExample();
 		// ���÷�ҳ��ѯ����
 		example.setStartRow((page - 1) * limit);
 		example.setPageSize(limit);
 		example.setOrderByClause("create_time desc,update_time desc");
 		GoodsExample.Criteria criteria = example.createCriteria();
 		if (keywords!=null&&keywords!="") {
 			keywords = keywords.trim();
 			keywords = "%" + keywords + "%";
 			// and or���ϲ�ѯ
 			example.or().andNameLike(keywords).andStatusEqualTo(1);
 			example.or().andGoodsCodeLike(keywords).andStatusEqualTo(1);
 		} else {
 			criteria.andStatusEqualTo(1);// ����״̬
 		}
 		// ��ҳ��ѯ
 		List<Goods> goodsList = goodsMapper.selectByExample(example);
 		int count = (int) goodsMapper.countByExample(example);

 		ResponseJsonPageListBean listBean = new ResponseJsonPageListBean();
 		listBean.setCode(0);
 		listBean.setCount(count);
 		listBean.setMsg("��Ʒ�б�");
 		listBean.setData(goodsList);

 		// ��־��¼�����ǰ̨Json
 		if (null != goodsList && goodsList.size() > 0) {
 			JsonPrintUtil.printObjDataWithoutKey(response, listBean);
 		} else {
 			JsonPrintUtil.printObjDataWithoutKey(response, null);
 		}
 	}
 	
 // ��Ʒ���� �༭
 	@RequestMapping(value = "save", method = RequestMethod.POST)
 	@ResponseBody
 	public void save(Goods goods, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
 		
 		int count = 0;
 		SysUser currentLoginUser = (SysUser) session.getAttribute("CurrentLoginUserInfo");
 		// �༭��Ʒ
 		if (null != goods.getId()&& goods.getId() > 0) {		
 			goods.setUpdater(currentLoginUser.getName() + "");
 			goods.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
 			count = goodsMapper.updateByPrimaryKeySelective(goods);

 			
 		} else {
 			// ������Ʒ
 			goods.setStatus(1);
 			goods.setCreater(currentLoginUser.getName()+ "");
 			goods.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
 			count = goodsMapper.insertSelective(goods);
 			//���ǰ̨Json
 			
 		} 		
 			JsonPrintUtil.printObjDataWithKey(response, count, "data");		
 	}

 	// ��Ʒ����ɾ��
 	@RequestMapping(value = "deleteBatch", method = RequestMethod.POST)
 	@ResponseBody
 	public void deleteBatch(String idStr, HttpServletRequest request, HttpServletResponse response,
 			HttpSession session) {
 		SysUser currentLoginUser = (SysUser) session.getAttribute("CurrentLoginUserInfo");
 		if (StringUtils.isNotBlank(idStr)) {
 			String[] idArr = idStr.split(",");
 			for (int i = 0; i < idArr.length; i++) {
 				// ������ѡ�豸����Ϊɾ��״̬
 				int id = Integer.parseInt(idArr[i]);
 				Goods goods = goodsMapper.selectByPrimaryKey(id);
 				goods.setStatus(0);//  0��ɾ��
 				goods.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
 				goods.setUpdater(currentLoginUser.getName() + "");
 				goodsMapper.updateByPrimaryKeySelective(goods);
 			}
 			// ���ǰ̨Json
 			JsonPrintUtil.printObjDataWithKey(response, 1, "data");
 		} else {
 			JsonPrintUtil.printObjDataWithKey(response, 0, "data");
 		}
 	}

 	// ��Ʒ�鿴
 	@RequestMapping(value = "show", method = RequestMethod.POST)
 	@ResponseBody
 	public void showWH(int id, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
 		Goods goods= goodsMapper.selectByPrimaryKey(id);
 		if (null != goods) {		
 			JsonPrintUtil.printObjDataWithKey(response, goods, "data");
 		} else {
 			JsonPrintUtil.printObjDataWithKey(response, null, "data");
 		}
 	}	
  

    @RequestMapping("uploadPhoto")
    @ResponseBody
    public void uploadPhoto( HttpServletRequest request, HttpServletResponse response,MultipartFile file) {
            // ��Ƭ����Ŀ¼
            String photoUrl = "";  	
        	photoUrl = super.uploadToFileUrl("goods_photo", file, request);
        	JsonPrintUtil.printObjDataWithKey(response, photoUrl, "data");
    } 
}
