package imangine.servlet;

import imangine.database.entity.User;
import imangine.database.dao.DataAccessObject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Like
 */
@WebServlet("/Like")
public class Like extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Like() {
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
		User users  = (User) request.getSession().getAttribute("userLoginStatus");
		if(users==null)
			return;
		
		String para=request.getParameter("like");
		String[] instruction=para.split("##");
		System.out.println(para);
		
		int itemId = 0;
		 try {
			itemId = Integer.parseInt(instruction[2]);
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
		if(instruction[1].equals("pic")&&instruction[0].equals("1"))
			DataAccessObject.setPictureLikeWithPictureIdNUserId(itemId, users.getUserId());
		else if(instruction[1].equals("pic")&&instruction[0].equals("2"))
			DataAccessObject.removePictureLikeWithPictureIdNUserId(itemId, users.getUserId());
		else if(instruction[1].equals("album")&&instruction[0].equals("1"))
			DataAccessObject.setAlbumLikeWithAlbumIdNUserId(itemId, users.getUserId());
		else if(instruction[1].equals("album")&&instruction[0].equals("2"))
			DataAccessObject.removeAlubmLikedWithAlbumIdNUserId(itemId, users.getUserId());
		else ;
		
			//TODO: add friend and group
	}

}
