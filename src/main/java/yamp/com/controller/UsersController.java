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
import yamp.com.mapper.SysUserMapper;
import yamp.com.model.SysUser;
import yamp.com.model.SysUserExample;
import yamp.com.model.SysUserExample.Criteria;
import yamp.com.service.UsersService;
import yamp.com.util.Const;
import yamp.com.util.DateUtil;
import yamp.com.util.JsonPrintUtil;


@Controller
@RequestMapping("/user")
public class UsersController {
	@Autowired
	private  SysUserMapper sysUserMapper;
	

	  // 用户列表分页查询
	 	@RequestMapping("list")
	 	@ResponseBody
	 	public void equipmentList(HttpServletRequest request, HttpServletResponse response, String keywords, int limit,
	 			int page) {
	 		// limit 每页显示数量
	 		// page 当前页码
	 		SysUserExample example = new SysUserExample();
	 		// 设置分页查询参数
	 		example.setStartRow((page - 1) * limit);
	 		example.setPageSize(limit);
	 		example.setOrderByClause("create_time desc,update_time desc");
	 		Criteria criteria = example.createCriteria();
	 		if (keywords!=null&&keywords!="") {
	 			keywords = keywords.trim();
	 			keywords = "%" + keywords + "%";
	 			// and or联合查询
	 			example.or().andNameLike(keywords).andStatusEqualTo(1);
	 			example.or().andLoginIdLike(keywords).andStatusEqualTo(1);
	 		} else {
	 			criteria.andStatusEqualTo(1);// 正常状态
	 		}
	 		// 分页查询
	 		List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
	 		int count = (int) sysUserMapper.countByExample(example);

	 		ResponseJsonPageListBean listBean = new ResponseJsonPageListBean();
	 		listBean.setCode(0);
	 		listBean.setCount(count);
	 		listBean.setMsg("用户列表");
	 		listBean.setData(sysUsers);

	 		// 日志记录及输出前台Json
	 		if (null != sysUsers && sysUsers.size() > 0) {
	 			JsonPrintUtil.printObjDataWithoutKey(response, listBean);
	 		} else {
	 			JsonPrintUtil.printObjDataWithoutKey(response, null);
	 		}
	 	}
	 	
	 // 用户新增 编辑
	 	@RequestMapping(value = "save", method = RequestMethod.POST)
	 	@ResponseBody
	 	public void save(SysUser sysUser, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	 		int count = 0;
	 		SysUser currentLoginUser = (SysUser) session.getAttribute("CurrentLoginUserInfo");
	 		// 编辑用户
	 		if (null != sysUser.getId()&& sysUser.getId() > 0) {
	 			SysUser userOld = sysUserMapper.selectByPrimaryKey(sysUser.getId());
	 			sysUser.setUpdater(currentLoginUser.getName() + "");
	 			sysUser.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
	 			if (!userOld.getLoginPassword().equals(sysUser.getLoginPassword())) {
	 				sysUser.setLoginPassword(DigestUtils.md5DigestAsHex(sysUser.getLoginPassword().getBytes()));
	 			}
	 			count = sysUserMapper.updateByPrimaryKeySelective(sysUser);

	 			
	 		} else {
	 			// 新增用户
	 			sysUser.setStatus(1);
	 			sysUser.setCreater(currentLoginUser.getId() + "");
	 			sysUser.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
	 			sysUser.setLoginPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
	 			count = sysUserMapper.insert(sysUser);
	 			//输出前台Json
	 			
	 		} 		
 				JsonPrintUtil.printObjDataWithKey(response, count, "data");		
	 	}

	 	// 用户批量删除
	 	@RequestMapping(value = "deleteBatch", method = RequestMethod.POST)
	 	@ResponseBody
	 	public void deleteBatch(String idStr, HttpServletRequest request, HttpServletResponse response,
	 			HttpSession session) {
	 		SysUser currentLoginUser = (SysUser) session.getAttribute("CurrentLoginUserInfo");
	 		if (StringUtils.isNotBlank(idStr)) {
	 			String[] idArr = idStr.split(",");
	 			for (int i = 0; i < idArr.length; i++) {
	 				// 更新所选设备分类为删除状态
	 				int id = Integer.parseInt(idArr[i]);
	 				SysUser user = sysUserMapper.selectByPrimaryKey(id);
	 				user.setStatus(0);// 1正常 0已删除
	 				user.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
	 				user.setUpdater(currentLoginUser.getName() + "");
	 				sysUserMapper.updateByPrimaryKeySelective(user);
	 			}
	 			// 输出前台Json
	 			JsonPrintUtil.printObjDataWithKey(response, 1, "data");
	 		} else {
	 			JsonPrintUtil.printObjDataWithKey(response, 0, "data");
	 		}
	 	}

	 	// 用户查看
	 	@RequestMapping(value = "show", method = RequestMethod.POST)
	 	@ResponseBody
	 	public void showWH(int id, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	 		SysUser user = sysUserMapper.selectByPrimaryKey(id);
	 		if (null != user) {		
	 			JsonPrintUtil.printObjDataWithKey(response, user, "data");
	 		} else {
	 			JsonPrintUtil.printObjDataWithKey(response, null, "data");
	 		}
	 	}	
}
