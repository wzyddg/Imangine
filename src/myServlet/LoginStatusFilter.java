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
import javax.servlet.http.HttpSession;

@WebFilter(
filterName = "/LoginStatusFilter"
,urlPatterns = {
	"/album-fav.jsp",
	"/album-my.jsp",
	"/blog.jsp",
	"/favPic.jsp",
	"/personal-modify.jsp",
	"/personal.jsp",
	"/picUpload.jsp",
	"/group-fav.jsp",
	"/group-my.jsp",
	"/PictureUpload",
	"/Carousel.jsp"
	}
)

public class LoginStatusFilter implements Filter {

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
		
		if (session.getAttribute("userLoginStatus") != null) {
//			System.out.println("ffffffuuuuuuu1");
			chain.doFilter(request, response);
		}
		else{
//			System.out.println("ffffffuuuuuuu2");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

}