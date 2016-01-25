<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="imangine.database.entity.User"%>
<%
	User userLoginStatus = (User) session
			.getAttribute("userLoginStatus");
	//	System.out.println(userLoginStatus);
	if (userLoginStatus == null) {
%>
<div class="header" id="header" style="background: #27121c">
	<div class="container">
		<div class="reglogbar">
			<div>
				<a href="login.jsp">LOGIN</a> | <a href="register.jsp">REGISTER</a>
			</div>
		</div>
		<div class="logo" style="padding: 10px;">
			<a href="index.jsp"><img src="images/imangine.png" alt="" /></a>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<%
	} else {
		//System.out.println(request.getRequestURL());
%>
<div class="navigation-strip">
	<div class="container">
		<div class="nav_content">
			<div class="home">
				<a href="index.jsp"><img src="images/imangine.png" alt="" /></a>
			</div>
			<div class="reglogbar-user pull-right">
				<div class="userp">
					<a href="personal.jsp"> <span><%=userLoginStatus.getUserName()%>
							&nbsp;</span>
					</a> <a href="personal.jsp"> <img
						src="<%=userLoginStatus.getAvatarPath()%>" />
					</a>
				</div>
			</div>

			<div class="clearfix"></div>
		</div>
	</div>
</div>

<%
	}
%>