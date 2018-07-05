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

	  // 商品列表分页查询
	 	@RequestMapping("list")
	 	@ResponseBody
	 	public void getList(HttpServletRequest request, HttpServletResponse response) {
	 		// limit 每页显示数量
	 		// page 当前页码
	 		GoodsExample example = new GoodsExample();
	 		// 设置分页查询参数
	 		
	 		example.setOrderByClause("create_time desc,update_time desc");
	 		GoodsExample.Criteria criteria = example.createCriteria();
	 			criteria.andStatusEqualTo(1);// 正常状态
	 		// 分页查询
	 		List<Goods> goodsList = goodsMapper.selectByExample(example);
	 		int count = (int) goodsMapper.countByExample(example);

	 		ResponseJsonPageListBean listBean = new ResponseJsonPageListBean();
	 		listBean.setCode(0);
	 		listBean.setCount(count);
	 		listBean.setMsg("商品列表");
	 		listBean.setData(goodsList);

	 		// 日志记录及输出前台Json
	 		if (null != goodsList && goodsList.size() > 0) {
	 			JsonPrintUtil.printObjDataWithoutKey(response, listBean);
	 		} else {
	 			JsonPrintUtil.printObjDataWithoutKey(response, null);
	 		}
	 	}
	 	// 商品查看
	 	@RequestMapping("show")
	 	@ResponseBody
	 	public Goods showWH(int id, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	 		
	 		System.out.println(id+"请求数据中");
	 		return goodsMapper.selectByPrimaryKey(id);
	 		
	 	}	

}
