package myServlet;

import imangine.Groups;
import imangine.Users;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dbMatter.DBQuerrier;

@WebServlet("/SetupGroup")
public class SetupGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public SetupGroup() {
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
//		
//		//Add anti-SqlInject code later
//		String title = request.getParameter("title");
//		String tags = request.getParameter("tag");
//		String des = request.getParameter("description");
//		Part part = request.getPart("inputfile");
//		
//		Users user = (Users)request.getSession().getAttribute("userLoginStatus");
//		
//		if(part==null||!part.getContentType().contains("image")){
//			response.sendRedirect("picUpload.jsp?error=2");
////			System.out.println(part.getContentType());
//			
//		}
//		else if(title.length()>39||tags.length()>254||des.length()>254){
//			response.sendRedirect("picUpload.jsp?error=1");
//		}
//		else{
////			System.out.println("’‚ «Õ∑"+part.getHeader("content-disposition"));
//			File folder = new File("F:\\files\\"+user.getUserId());
//			if(folder.exists());
//			else {
//				folder.mkdirs();
//			}
////			String header = part.getHeader("content-disposition");
//			String fileName = ""+user.getUserId()+"_"+(new Date().getTime())+"."+getFileType(part);
//			String fileAddress = "F:\\files\\"+user.getUserId()+"\\"+fileName;
//			part.write(fileAddress);
//			
//			String address = "files/"+user.getUserId()+"/"+fileName;
//			
//			Integer picId = DBQuerrier.setPicWithAddressNTitleNTagsNDescriptionNposterId(address, title, tags, des, user.getUserId());
//			
//			response.sendRedirect("single.jsp?id="+picId);
//		}
		String name = request.getParameter("name");
		String themeString = request.getParameter("theme");
		
		Users user = (Users)request.getSession().getAttribute("userLoginStatus");
		System.out.println(name+themeString+user);
		
		if(name.equals("")||themeString.equals("")||user==null){
			response.sendRedirect("setup-group.jsp?error=1");
		}else {
			Groups groups = DBQuerrier.setGroupWithNameNSetterIdNTheme(name, user.getUserId(), themeString);
			response.sendRedirect("single-group.jsp?id="+groups.getGroupId());
		}
		
	}
	
}
