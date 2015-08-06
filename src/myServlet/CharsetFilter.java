package myServlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

@WebFilter(
filterName = "/CharsetFilter",
urlPatterns = {"/*"} ,
initParams = {@WebInitParam(name="encoding",value="UTF-8")}
)

public class CharsetFilter implements Filter {
	String encoding=null;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		encoding=null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if(encoding!=null){
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset="+encoding);
		}
//		System.out.println("in charset filter");
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		encoding=config.getInitParameter("encoding");
	}

}
