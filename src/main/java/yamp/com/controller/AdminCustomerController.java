package yamp.com.controller;


import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
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
@RequestMapping("/adminCustomer")
public class AdminCustomerController {
	@Autowired
	private  CustomerMapper customerMapper;
	

	  // �ͻ��б��ҳ��ѯ
	 	@RequestMapping("list")
	 	@ResponseBody
	 	public void equipmentList(HttpServletRequest request, HttpServletResponse response, String keywords, int limit,
	 			int page) {
	 		// limit ÿҳ��ʾ����
	 		// page ��ǰҳ��
	 		CustomerExample example = new CustomerExample();
	 		// ���÷�ҳ��ѯ����
	 		example.setStartRow((page - 1) * limit);
	 		example.setPageSize(limit);
	 		example.setOrderByClause("create_time desc,update_time desc");
	 		CustomerExample.Criteria criteria = example.createCriteria();
	 		if (keywords!=null&&keywords!="") {
	 			keywords = keywords.trim();
	 			keywords = "%" + keywords + "%";
	 			// and or���ϲ�ѯ
	 			example.or().andNameLike(keywords).andStatusNotEqualTo(0);
	 			example.or().andLoginIdLike(keywords).andStatusNotEqualTo(0);
	 		} else {
	 			criteria.andStatusNotEqualTo(0);// ����״̬
	 		}
	 		// ��ҳ��ѯ
	 		List<Customer> customers = customerMapper.selectByExample(example);
	 		int count = (int) customerMapper.countByExample(example);

	 		ResponseJsonPageListBean listBean = new ResponseJsonPageListBean();
	 		listBean.setCode(0);
	 		listBean.setCount(count);
	 		listBean.setMsg("�ͻ��б�");
	 		listBean.setData(customers);

	 		// ��־��¼�����ǰ̨Json
	 		if (null != customers && customers.size() > 0) {
	 			JsonPrintUtil.printObjDataWithoutKey(response, listBean);
	 		} else {
	 			JsonPrintUtil.printObjDataWithoutKey(response, null);
	 		}
	 	}
	 	
	 // �ͻ����� �༭
	 	@RequestMapping(value = "save", method = RequestMethod.POST)
	 	@ResponseBody
	 	public void save(Customer customer, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	 		int count = 0;
	 		SysUser currentLoginUser = (SysUser) session.getAttribute("CurrentLoginUserInfo");
	 		// �༭�ͻ�
	 		if (null != customer.getId()&& customer.getId() > 0) {
	 			Customer customerOld = customerMapper.selectByPrimaryKey(customer.getId());
	 			customer.setUpdater(currentLoginUser.getLoginId() + "");
	 			customer.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
	 			if (!customerOld.getLoginPassword().equals(customer.getLoginPassword())) {
	 				customer.setLoginPassword(DigestUtils.md5DigestAsHex(customer.getLoginPassword().getBytes()));
	 			}
	 			count = customerMapper.updateByPrimaryKeySelective(customer);

	 			
	 		} else {
	 			// �����ͻ�
	 			customer.setCreater(currentLoginUser.getLoginId());
	 			customer.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
	 			customer.setLoginPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
	 			count = customerMapper.insert(customer);
	 			//���ǰ̨Json
	 			
	 		} 		
 				JsonPrintUtil.printObjDataWithKey(response, count, "data");		
	 	}

	 	// �ͻ�����ɾ��
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
	 				Customer customer= customerMapper.selectByPrimaryKey(id);
	 				customer.setStatus(0);// 1���� 0��ɾ��
	 				customer.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
	 				customer.setUpdater(currentLoginUser.getLoginId() + "");
	 				customerMapper.updateByPrimaryKeySelective(customer);
	 			}
	 			// ���ǰ̨Json
	 			JsonPrintUtil.printObjDataWithKey(response, 1, "data");
	 		} else {
	 			JsonPrintUtil.printObjDataWithKey(response, 0, "data");
	 		}
	 	}

	 	// �ͻ��鿴
	 	@RequestMapping(value = "show", method = RequestMethod.POST)
	 	@ResponseBody
	 	public void showWH(int id, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	 		Customer customer = customerMapper.selectByPrimaryKey(id);
	 		if (null != customer) {		
	 			JsonPrintUtil.printObjDataWithKey(response, customer, "data");
	 		} else {
	 			JsonPrintUtil.printObjDataWithKey(response, null, "data");
	 		}
	 	}	
		// ��¼��У��
	 	@RequestMapping(value = "loginIdCheck", method = RequestMethod.POST)
	 	@ResponseBody
	 	public boolean loginIdCheck(String loginId, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	 		CustomerExample example=  new CustomerExample();
	 		CustomerExample.Criteria criteria = example.createCriteria();
	 		criteria.andLoginIdEqualTo(loginId);
	 		List<Customer> list =customerMapper.selectByExample(example);
	 		if(list.size()>0&&list!=null) {
	 			return false;
	 		}
	 		return true;
	 	}
}
