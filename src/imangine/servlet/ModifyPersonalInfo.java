package imangine.servlet;

import imangine.database.entity.Users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import imangine.database.dao.DataAccessObject;

/**
 * Servlet implementation class ModifyPersonal
 */
@WebServlet("/ModifyPersonalInfo")
@MultipartConfig(location = "F:\\files\\avatar")
public class ModifyPersonalInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyPersonalInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String opsw = request.getParameter("opassword");
		String npsw = request.getParameter("npassword");
		Users user = (Users) request.getSession().getAttribute(
				"userLoginStatus");
		String cnpsw = request.getParameter("cnpassword");
		String gender = request.getParameter("gender");
		gender = (gender.equals("male") || gender.equals("female")
				 ? gender : "classified");
		String city = request.getParameter("city");
		String description = request.getParameter("description");
		Part part = request.getPart("inputfile");

		if (!opsw.equals(user.getPassword())) {
			response.sendRedirect("personal-modify.jsp?error=3");
		} else if (name.length() > 40 || npsw.length() > 20
				|| description.length() > 254 || name.length() < 1
				|| (npsw.length() < 6 && npsw.length() != 0)
				|| city.length() > 19 || city.length() < 1) {
			response.sendRedirect("personal-modify.jsp?error=1");
		} else

		if (!npsw.equals(cnpsw)) {
			response.sendRedirect("personal-modify.jsp?error=4");
		} else {
			String passwordString = (npsw.equals("") ? opsw : npsw);

			if (!part.getContentType().contains("image")) {
				// response.sendRedirect("personal-modify.jsp?error=2");
				if (!part.getContentType().equals("application/octet-stream"))
					response.sendRedirect("personal-modify.jsp?error=2");
			}
			String fileName = "" + user.getUserId();
			String fileAddress = "F:\\files\\avatar\\" + fileName;
			String address = user.getAvatarPath();
			if (part.getContentType().contains("image")) {
				fileName = "" + user.getUserId();
				fileAddress = "F:\\files\\avatar\\" + fileName;
				address = "files/avatar/" + fileName;
				part.write(fileAddress);
			}

			System.out.println(name + passwordString + address + city + gender
					+ description);

			DataAccessObject.updateUserInfo(user.getUserId(), name, passwordString,
					address, user.getEmail(), city, gender, description,
					user.getBirthdayString());

			request.getSession().setAttribute("userLoginStatus",
					DataAccessObject.getUserwithuserId(user.getUserId()));
			response.sendRedirect("personal-modify.jsp?error=0");
		}

	}

}
