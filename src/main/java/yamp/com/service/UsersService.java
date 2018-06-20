package yamp.com.service;



import yamp.com.model.SysUser;


public interface UsersService {
	 public SysUser login(String loginId , String password);	
}
