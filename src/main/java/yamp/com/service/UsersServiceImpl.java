package yamp.com.service;




import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import yamp.com.mapper.SysUserMapper;
import yamp.com.model.SysUser;
import yamp.com.model.SysUserExample;
import yamp.com.model.SysUserExample.Criteria;




@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	SysUserMapper sysUserMapper; 
	public SysUser login(String loginId, String password) {
		
			if (StringUtils.isNotBlank(loginId) && StringUtils.isNotBlank(password)) {
				password = DigestUtils.md5DigestAsHex(password.getBytes());		
					SysUserExample example = new SysUserExample();
					Criteria criteria = example.createCriteria();
					criteria.andLoginPasswordEqualTo(password).andLoginIdEqualTo(loginId).andStatusEqualTo(1);
					List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
			  if(sysUsers.size()>0&&sysUsers!=null) {
				  return sysUsers.get(0);
			  }
			
			}	
		return null;
	}

	
}
