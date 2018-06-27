package yamp.com.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import yamp.com.common.ResponseJsonPageListBean;
import yamp.com.mapper.BraAgnTypMapper;
import yamp.com.model.BraAgnTyp;
import yamp.com.model.BraAgnTypExample;
import yamp.com.model.SysUser;
import yamp.com.util.DateUtil;
import yamp.com.util.JsonPrintUtil;


@Controller
@RequestMapping("braagntyp")
public class BraAgnTypController {

 @Autowired
 private BraAgnTypMapper braAgnTypMapper;
 
 // Ʒ��||����||��Ӧ��||�б��ҳ��ѯ
	@RequestMapping("list")
	@ResponseBody
	public void getList(HttpServletRequest request, HttpServletResponse response, String keywords, Integer roleStatus,int limit,
			int page) {
		if(roleStatus==null) {
			JsonPrintUtil.printObjDataWithoutKey(response, null);	
		}
		// limit ÿҳ��ʾ����
		// page ��ǰҳ��
		BraAgnTypExample example = new BraAgnTypExample();
		// ���÷�ҳ��ѯ����
		example.setStartRow((page - 1) * limit);
		example.setPageSize(limit);
		example.setOrderByClause("create_time desc,update_time desc");
		BraAgnTypExample.Criteria criteria = example.createCriteria();
		if (keywords!=null&&keywords!="") {
			keywords = keywords.trim();
			keywords = "%" + keywords + "%";
			// and or���ϲ�ѯ
			example.or().andNameLike(keywords).andStatusEqualTo(roleStatus);
		} else {
			criteria.andStatusEqualTo(roleStatus);// ����״̬
		}
		// ��ҳ��ѯ
		List<BraAgnTyp> sysUsers = braAgnTypMapper.selectByExample(example);
		int count = (int) braAgnTypMapper.countByExample(example);

		ResponseJsonPageListBean listBean = new ResponseJsonPageListBean();
		listBean.setCode(0);
		listBean.setCount(count);
		listBean.setMsg("Ʒ��||����||��Ӧ��||�б�");
		listBean.setData(sysUsers);

		// ��־��¼�����ǰ̨Json
		if (null != sysUsers && sysUsers.size() > 0) {
			JsonPrintUtil.printObjDataWithoutKey(response, listBean);
		} else {
			JsonPrintUtil.printObjDataWithoutKey(response, null);
		}
	}
	
// Ʒ��||����||��Ӧ��||���� �༭
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public void save( Integer id,BraAgnTyp braAgnTyp, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		int count = 0;
		SysUser currentLoginUser = (SysUser) session.getAttribute("CurrentLoginUserInfo");
		// �༭Ʒ��||����||��Ӧ��||
		if (null != braAgnTyp.getId()&& braAgnTyp.getId() > 0) {
			braAgnTyp.setId(id);
			braAgnTyp.setUpdater(currentLoginUser.getName() + "");
			braAgnTyp.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
			count = braAgnTypMapper.updateByPrimaryKeySelective(braAgnTyp);

			
		} else {
			// ����Ʒ��||����||��Ӧ��||
			braAgnTyp.setCreater(currentLoginUser.getName()+ "");
			braAgnTyp.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
			count = braAgnTypMapper.insert(braAgnTyp);
			//���ǰ̨Json
			
		} 		
			JsonPrintUtil.printObjDataWithKey(response, count, "data");		
	}

	// Ʒ��||����||��Ӧ��||����ɾ��
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
				BraAgnTyp braAgnTyp = braAgnTypMapper.selectByPrimaryKey(id);
				braAgnTyp.setStatus(0);//  0��ɾ��
				braAgnTyp.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
				braAgnTyp.setUpdater(currentLoginUser.getName() + "");
				braAgnTypMapper.updateByPrimaryKeySelective(braAgnTyp);
			}
			// ���ǰ̨Json
			JsonPrintUtil.printObjDataWithKey(response, 1, "data");
		} else {
			JsonPrintUtil.printObjDataWithKey(response, 0, "data");
		}
	}

	// Ʒ��||����||��Ӧ��||�鿴
	@RequestMapping(value = "show", method = RequestMethod.POST)
	@ResponseBody
	public void showWH(int id, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		BraAgnTyp braAgnTyp= braAgnTypMapper.selectByPrimaryKey(id);
		if (null != braAgnTyp) {		
			JsonPrintUtil.printObjDataWithKey(response, braAgnTyp, "data");
		} else {
			JsonPrintUtil.printObjDataWithKey(response, null, "data");
		}
	}	
 
}
