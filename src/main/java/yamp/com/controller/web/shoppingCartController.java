package yamp.com.controller.web;


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

import yamp.com.common.ResponseJsonPageListBean;
import yamp.com.mapper.ShoppingCarMapper;
import yamp.com.model.ShoppingCar;
import yamp.com.model.ShoppingCarExample;
import yamp.com.util.JsonPrintUtil;



@Controller
@RequestMapping("cart")
public class shoppingCartController {
  @Autowired
  private ShoppingCarMapper shoppingCarMapper;

  // 购物车列表分页查询
 	@RequestMapping("list")
 	@ResponseBody
 	public List<ShoppingCar> getList(String customerId) {
 		
 		ShoppingCarExample example = new ShoppingCarExample();
 		ShoppingCarExample.Criteria criteria =example.createCriteria();
 			criteria.andStatusEqualTo(1).andCustomerIdEqualTo(customerId);// 正常状态
 		List<ShoppingCar> goodsList = shoppingCarMapper.selectByExample(example);
 	     return goodsList;
 		
 	}
 	
 // 购物车新增 编辑
 	@RequestMapping(value = "save", method = RequestMethod.POST)
 	@ResponseBody
 	public Integer save( ShoppingCar shoppingCar, HttpServletRequest request, HttpServletResponse response, HttpSession session) {	
 		int count = 0;
 		// 编辑购物车
 		if (null != shoppingCar.getId()&& shoppingCar.getId() > 0) {		
 			count = shoppingCarMapper.updateByPrimaryKeySelective(shoppingCar);			
 		} else {
 			// 新增购物车
 			shoppingCar.setStatus(1);
 			count = shoppingCarMapper.insertSelective(shoppingCar);		
 		} 	
 		System.out.println(count+"正在提交。。。。");
 			return count;
 	}

 	// 购物车批量删除
 	@RequestMapping(value = "deleteBatch", method = RequestMethod.POST)
 	@ResponseBody
 	public Integer deleteBatch(String idStr, HttpServletRequest request, HttpServletResponse response,
 			HttpSession session) {
        Integer res=0;
 		if (StringUtils.isNotBlank(idStr)) {
 			String[] idArr = idStr.split(",");
 			for (int i = 0; i < idArr.length; i++) {
 				// 更新所选设备分类为删除状态
 				int id = Integer.parseInt(idArr[i]);
 				ShoppingCar shoppingCar = shoppingCarMapper.selectByPrimaryKey(id);
 				shoppingCar.setStatus(0);//  0已删除
 				res=shoppingCarMapper.updateByPrimaryKeySelective(shoppingCar);
 			}
 		}
 		return res;
 	}

 	// 购物车查看
 	@RequestMapping("show")
 	@ResponseBody
 	public ShoppingCar showWH(int id, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
 		return shoppingCarMapper.selectByPrimaryKey(id);		
 	}	
}
