package imangine.servlet;

import imangine.database.entity.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imangine.database.dao.DataAccessObject;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String passWord=request.getParameter("password");
		
		System.out.println(name+" k "+passWord);
		
//		System.out.println(request);
//		System.out.println(name+passWord);
		User result=DataAccessObject.login(name, passWord);
		if(result==null){
			request.setAttribute("LoginSuccess", new Boolean(false));
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
			request.setAttribute("LoginSuccess", new Boolean(true));
			request.getSession().setAttribute("userLoginStatus", result);
			response.sendRedirect("index.jsp");
		}
	}

}
