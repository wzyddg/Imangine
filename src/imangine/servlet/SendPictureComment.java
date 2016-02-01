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
 * Servlet implementation class SendPicComment
 */
@WebServlet("/SendPictureComment")
public class SendPictureComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendPictureComment() {
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
			request.getRequestDispatcher("picture_detail.jsp?id="+picId).forward(request, response);
			// TODO: handle exception
		}
		User user=(User) request.getSession().getAttribute("userLoginStatus");
		String comCon=request.getParameter("comCon");
		if(user==null||comCon==null||comCon.equals("")){
			request.getSession().setAttribute("PicComStatus", new Integer(-1));
//			request.getRequestDispatcher("single.jsp?id="+picId).forward(request, response);\
			response.sendRedirect("picture_detail.jsp?id="+picId);
		}
		else {
			request.getSession().setAttribute("PicComStatus", new Integer(1));
			DataAccessObject.setPictureCommentWithPictureIdNUserIdNContent(picId,user.getUserId(),comCon);
//			request.getRequestDispatcher("single.jsp?id="+picId).forward(request, response);
			response.sendRedirect("picture_detail.jsp?id="+picId);
		}
	}

}
