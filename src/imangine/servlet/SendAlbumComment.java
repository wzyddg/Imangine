package imangine.servlet;

import imangine.database.dao.DataAccessObject;
import imangine.database.entity.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendAlbumComment
 */
@WebServlet("/SendAlbumComment")
public class SendAlbumComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendAlbumComment() {
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
		Integer albumId=0;
		try {
			albumId=Integer.parseInt(request.getParameter("albumId"));
		} catch (Exception e) {
			request.getSession().setAttribute("AlbumComStatus", new Boolean(false));
			request.getRequestDispatcher("album_detail.jsp?id="+albumId).forward(request, response);
			// TODO: handle exception
		}
		User user=(User) request.getSession().getAttribute("userLoginStatus");
		String comCon=request.getParameter("comCon");
		if(user==null||comCon==null||comCon.equals("")){
			request.getSession().setAttribute("AlbumComStatus", new Integer(-1));
//			request.getRequestDispatcher("single.jsp?id="+albumId).forward(request, response);\
			response.sendRedirect("album_detail.jsp?id="+albumId);
		}
		else {
			request.getSession().setAttribute("AlbumComStatus", new Integer(1));
			DataAccessObject.setAlbumCommentWithAlbumIdNUserIdNContent(albumId,user.getUserId(),comCon);
//			request.getRequestDispatcher("single.jsp?id="+albumId).forward(request, response);
			response.sendRedirect("album_detail.jsp?id="+albumId);
		}
	}
}
