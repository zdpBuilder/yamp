package yamp.com.intecepter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yamp.com.model.SysUser;
import yamp.com.util.Const;

public class loginFilter implements Filter{
	private String filterPattern;
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// ��������ִ��
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		String requestURI = request.getRequestURI();
		String page = requestURI.substring(request.getContextPath().length());
		HttpSession session = request.getSession();
		SysUser users = (SysUser)session.getAttribute(Const.SESSION_USER);
          if(page.matches(filterPattern)){
			if(users == null && !page.equals("/login.jsp")){
				//redirect��login.jsp
				response.sendRedirect(request.getContextPath()+"/login.jsp");
				return;
			}
		}
		//��������ִ��
          arg2.doFilter(arg0, arg1);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		// ��ʼ��������
	    filterPattern = arg0.getInitParameter("filterPattern");
	}

	

}
