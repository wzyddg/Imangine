<%@page import="imangine.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Users userLoginStatus = (Users) session
			.getAttribute("userLoginStatus");
//	System.out.println(userLoginStatus);
	if (userLoginStatus == null) {
%>
<div class="container">
	<div class="reglogbar">
		<div>
			<a href="login.jsp">登录</a> | <a href="register.jsp">注册</a>
		</div>
	</div>
	<div class="logo">
		<a href="index.jsp"><img src="images/logo.png" alt="" /></a>
	</div>
	<div class="clearfix"></div>
</div>
<%
	} else {
		//System.out.println(request.getRequestURL());
%>
<div class="container">
	<div class="reglogbar">
		<div>
			<a><img src='<%=userLoginStatus.getDoll()%>' /></a> <a href="blog.jsp"><%=userLoginStatus.getUserName()%></a>，你好！
			| <a href="Logout">退出</a> | <a href="personal.jsp">个人中心</a>
		</div>
	</div>
	<div class="logo">
		<a href="index.jsp"><img src="images/logo.png" alt="" /></a>
	</div>
	<div class="clearfix"></div>
</div>
<%
	}
%>
