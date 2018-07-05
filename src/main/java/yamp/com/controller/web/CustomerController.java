package yamp.com.controller.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.ReuseExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import yamp.com.common.ResponseJsonPageListBean;
import yamp.com.mapper.CustomerMapper;
import yamp.com.model.Customer;
import yamp.com.model.CustomerExample;
import yamp.com.model.SysUser;

import yamp.com.util.DateUtil;
import yamp.com.util.JsonPrintUtil;

@Controller
@RequestMapping("customer")
public class CustomerController {
 
	@Autowired
	private CustomerMapper customerMapper;
	// 用户登录
	   @RequestMapping("login")
		@ResponseBody
		public Integer login(String loginId, String password, HttpServletResponse response,
				HttpServletRequest request, HttpSession session) {
		   int result=0;
		    CustomerExample example = new CustomerExample();
			CustomerExample.Criteria criteria = example.createCriteria();
			if (StringUtils.isNotBlank(loginId)) {
					criteria.andLoginIdEqualTo(loginId).andStatusNotEqualTo(0);
					List<Customer> customers = customerMapper.selectByExample(example);
					result+=customers.size();
					if(customers.size()>0) {
						if (StringUtils.isNotBlank(password)) {
							password = DigestUtils.md5DigestAsHex(password.getBytes());		
								criteria.andLoginPasswordEqualTo(password).andStatusNotEqualTo(0);
								List<Customer> customers2 = customerMapper.selectByExample(example);
								result+=customers2.size();
						}
					}
			}
			
			return result;
	}
 
		 // 用户新增 编辑
		 	@RequestMapping(value = "save", method = RequestMethod.POST)
		 	@ResponseBody
		 	public Integer save(Customer customer) {
		 		int count = 0;
		 		// 编辑用户
		 		if (null != customer.getId()&& customer.getId() > 0) {
		 			Customer customerOld = customerMapper.selectByPrimaryKey(customer.getId());
		 			customer.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
		 			if (!customerOld.getLoginPassword().equals(customer.getLoginPassword())) {
		 				customer.setLoginPassword(DigestUtils.md5DigestAsHex(customer.getLoginPassword().getBytes()));
		 			}
		 			count = customerMapper.updateByPrimaryKeySelective(customer);

		 			
		 		} else {
		 			// 新增用户
		 			customer.setStatus(1);
		 			customer.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
		 			customer.setLoginPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
		 			count = customerMapper.insert(customer);
		 			
		 		} 
		 		
		 		return count;
		 	}

		 	// 用户批量删除
		 	@RequestMapping(value = "deleteBatch", method = RequestMethod.POST)
		 	@ResponseBody
		 	public Integer deleteBatch(String idStr) {
		 		int count=0;
		 		if (StringUtils.isNotBlank(idStr)) {
		 			String[] idArr = idStr.split(",");
		 			for (int i = 0; i < idArr.length; i++) {
		 				// 更新所选设备分类为删除状态
		 				int id = Integer.parseInt(idArr[i]);
		 				Customer customer = customerMapper.selectByPrimaryKey(id);
		 				customer.setStatus(0);// 1正常 0已删除
		 				customer.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
		 				count=customerMapper.updateByPrimaryKeySelective(customer);
		 			}			
		 		} 
		 		return count;
		 	}

		 	// 用户查看
		 	@RequestMapping( "show")
		 	@ResponseBody
		 	public Customer showWH(String loginId) {
		 		CustomerExample example = new CustomerExample();
				CustomerExample.Criteria criteria = example.createCriteria();
				criteria.andLoginIdEqualTo(loginId).andStatusNotEqualTo(0);
				List<Customer> customers= customerMapper.selectByExample(example);
				if(customers.size()>0) {
		 			return customers.get(0);
		 		}
				return  null;	
		 	}	
			// 登录名校验
		 	
		 	private  boolean loginIdCheck(String loginId) {
		 		CustomerExample example=  new CustomerExample();
		 		CustomerExample.Criteria criteria = example.createCriteria();
		 		criteria.andLoginIdEqualTo(loginId);
		 		List<Customer> list =customerMapper.selectByExample(example);
		 		if(list.size()>0&&list!=null) {
		 			return false;
		 		}
		 		return true;
		 	}
		 	
		 	 // 用户新增 编辑
		 	@RequestMapping("register")
		 	@ResponseBody
		 	public Integer register(Customer customer) {
		 		int count = 0;
		 		customer.setLoginPassword(DigestUtils.md5DigestAsHex(customer.getLoginPassword().getBytes()));
		 		if(loginIdCheck(customer.getLoginId())) {
		 			count=customerMapper.insert(customer);
		 		}	
		 		return count;
		 	}
 	
}
