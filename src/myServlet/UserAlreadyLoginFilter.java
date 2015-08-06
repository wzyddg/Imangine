package myServlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(
filterName = "UserLoginFilter"
,urlPatterns = {
	"/register.jsp",
	"/login.jsp",
}
//,initParams = {@WebInitParam(name="encoding",value="UTF-8")}
)

public class UserAlreadyLoginFilter implements Filter {
	HttpSession session;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		session=null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		session=((HttpServletRequest) request).getSession();
//		System.out.println("already filter");
		if (session.getAttribute("userLoginStatus") != null) {
			System.out.println("already login");
			((HttpServletResponse)response).sendRedirect("index.jsp");
		}
		else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

}