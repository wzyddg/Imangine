package myServlet;

import imangine.Users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dbMatter.DBQuerrier;

/**
 * Servlet implementation class SendPicComment
 */
@WebServlet("/SendPicComment")
public class SendPicComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendPicComment() {
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
//		System.out.println(request.getParameter("comCon")+request.getParameter("picId"));
		Integer picId=0;
		try {
			picId=Integer.parseInt(request.getParameter("picId"));
		} catch (Exception e) {
			request.getSession().setAttribute("PicComStatus", new Boolean(false));
			request.getRequestDispatcher("single.jsp?id="+picId).forward(request, response);
			// TODO: handle exception
		}
		Users users=(Users) request.getSession().getAttribute("userLoginStatus");
		String comCon=request.getParameter("comCon");
		if(users==null||comCon==null||comCon.equals("")){
			request.getSession().setAttribute("PicComStatus", new Integer(-1));
//			request.getRequestDispatcher("single.jsp?id="+picId).forward(request, response);\
			response.sendRedirect("single.jsp?id="+picId);
		}
		else {
			request.getSession().setAttribute("PicComStatus", new Integer(1));
			DBQuerrier.setPicCommentWithPicIdNUserIdNContent(picId,users.getUserId(),comCon);
//			request.getRequestDispatcher("single.jsp?id="+picId).forward(request, response);
			response.sendRedirect("single.jsp?id="+picId);
		}
	}

}
