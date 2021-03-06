package yamp.com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yamp.com.mapper.SysUserMapper;
import yamp.com.model.SysUser;
import yamp.com.service.UsersService;
import yamp.com.util.Const;
import yamp.com.util.JsonPrintUtil;


@Controller
public class LoginController {

	@Autowired
	private UsersService usersService;
	
     //用户登录
	@RequestMapping("login")
	@ResponseBody
	public void login(String loginId, String password,Integer roleStatus, HttpServletResponse response,
			HttpServletRequest request, HttpSession session) {	
		SysUser sysUser= usersService.login(loginId, password,roleStatus);	
	  if(null!=sysUser) {
		// 登陆成功
		  JsonPrintUtil.printObjDataWithKey(response, 1, "data");
		  session.setAttribute(Const.SESSION_USER, sysUser);
		  session.setAttribute(Const.SESSION_USER_STATUS, roleStatus);
	  }else{
		  session.setAttribute(Const.SESSION_USER, null);
		  JsonPrintUtil.printObjDataWithKey(response, 0, "data");
	  }	  
}

	// 退出
	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().invalidate();
		return "login";
	}	
	 
}
