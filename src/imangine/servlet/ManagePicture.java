package imangine.servlet;

import imangine.database.dao.DataAccessObject;
import imangine.database.entity.Picture;
import imangine.database.entity.User;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 * Servlet implementation class ManagePicture
 */
@WebServlet("/ManagePicture")
public class ManagePicture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagePicture() {
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
		
		//Add anti-SqlInject code later
		String title = request.getParameter("title");
		String tags = request.getParameter("tag");
		String des = request.getParameter("description");
		Part part = request.getPart("inputfile");
		
		
		
		User user = (User)request.getSession().getAttribute("userLoginStatus");
		System.out.println(part+title+tags+des);
		if(part==null||!part.getContentType().contains("image")){
			response.sendRedirect("picture_upload.jsp?error=2");
//			System.out.println(part.getContentType());
			
		}
		else if(title.length()>39||tags.length()>254||des.length()>254){
			response.sendRedirect("picture_upload.jsp?error=1");
		}
		else{
//			System.out.println("ÕâÊÇÍ·"+part.getHeader("content-disposition"));
			File folder = new File(DataAccessObject.getFilesDirectory() + "\\"+user.getUserId());
			if(folder.exists());
			else {
				folder.mkdirs();
			}
//			String header = part.getHeader("content-disposition");
			String fileName = ""+user.getUserId()+"_"+(new Date().getTime())+"."+getFileType(part);
			String fileAddress = DataAccessObject.getFilesDirectory()+"\\"+user.getUserId()+"\\"+fileName;
			part.write(fileAddress);
			
			String address = "files/"+user.getUserId()+"/"+fileName;
			
			Picture picture = DataAccessObject.setPictureWithPathNTitleNTagsNDescriptionNPosterId(address, title, tags, des, user.getUserId());
			
			response.sendRedirect("picture_detail.jsp?id="+picture.getPictureId());
		}
	}
	
	public String getFileType(String header) {
		String[] tmp1 = header.split("\\.");
		String[] tmp2 = tmp1[tmp1.length-1].split("\"");
		
		
		return tmp2[0];
	}
	
	public String getFileType(Part part){
		String[] tmp = part.getSubmittedFileName().split("\\.");
		return tmp[tmp.length-1];
	}

}
