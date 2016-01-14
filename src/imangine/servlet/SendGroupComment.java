package imangine.servlet;

import imangine.database.entity.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imangine.database.dao.DataAccessObject;

@WebServlet("/SendGroupComment")
public class SendGroupComment extends HttpServlet {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SendGroupComment() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doPost(request, response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
//			System.out.println(request.getParameter("comCon")+request.getParameter("picId"));
			Integer groupId=0;
			try {
				groupId=Integer.parseInt(request.getParameter("groupId"));
			} catch (Exception e) {
				request.getSession().setAttribute("GroupComStatus", new Boolean(false));
				request.getRequestDispatcher("single-group.jsp?id="+groupId).forward(request, response);
				// TODO: handle exception
			}
			User users=(User) request.getSession().getAttribute("userLoginStatus");
			String comCon=request.getParameter("comCon");
			if(users==null||comCon==null||comCon.equals("")){
				request.getSession().setAttribute("GroupComStatus", new Integer(-1));
				response.sendRedirect("single-group.jsp?id="+groupId);
			}
			else {
				request.getSession().setAttribute("GroupComStatus", new Integer(1));
				DataAccessObject.setGroupCommentWithGroupIdNUserIdNContent(groupId,users.getUserId(),comCon);
//				request.getRequestDispatcher("single.jsp?id="+picId).forward(request, response);
				response.sendRedirect("single-group.jsp?id="+groupId);
			}
		}
}
