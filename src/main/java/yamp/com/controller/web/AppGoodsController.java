package yamp.com.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;


import yamp.com.common.ResponseJsonPageListBean;
import yamp.com.mapper.GoodsMapper;
import yamp.com.model.Goods;
import yamp.com.model.GoodsExample;

import yamp.com.util.JsonPrintUtil;

@Controller
@RequestMapping("appGoods")
public class AppGoodsController {
 
	 @Autowired
	  private GoodsMapper goodsMapper;

	  // ��Ʒ�б��ҳ��ѯ
	 	@RequestMapping("list")
	 	@ResponseBody
	 	public void getList(HttpServletRequest request, HttpServletResponse response) {
	 		// limit ÿҳ��ʾ����
	 		// page ��ǰҳ��
	 		GoodsExample example = new GoodsExample();
	 		// ���÷�ҳ��ѯ����
	 		
	 		example.setOrderByClause("create_time desc,update_time desc");
	 		GoodsExample.Criteria criteria = example.createCriteria();
	 			criteria.andStatusEqualTo(1);// ����״̬
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
	 	// ��Ʒ�鿴
	 	@RequestMapping("show")
	 	@ResponseBody
	 	public Goods showWH(int id, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	 		
	 		System.out.println(id+"����������");
	 		return goodsMapper.selectByPrimaryKey(id);
	 		
	 	}	

}
