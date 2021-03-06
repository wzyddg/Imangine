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
		Users users  = (Users) request.getSession().getAttribute("userLoginStatus");
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
			DBQuerrier.setPicLikeWithPicIdNUserId(itemId, users.getUserId());
		else if(instruction[1].equals("pic")&&instruction[0].equals("2"))
			DBQuerrier.removePicLikeWithPicIdNUserId(itemId, users.getUserId());
		else if(instruction[1].equals("album")&&instruction[0].equals("1"))
			DBQuerrier.setAlbumLikeWithAlbumIdNUserId(itemId, users.getUserId());
		else if(instruction[1].equals("album")&&instruction[0].equals("2"))
			DBQuerrier.removeAlubmLikedWithPicIdNUserId(itemId, users.getUserId());
		else ;
		
			//TODO: add friend and group
	}

}
