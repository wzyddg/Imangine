<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="imangine.database.entity.User"%>
<%
	User userLoginStatus = (User) session
			.getAttribute("userLoginStatus");
	//	System.out.println(userLoginStatus);
	if (userLoginStatus == null) {
%>
<div class="navigation-strip">
    <div class="container">
        <div class="nav_content">
            <div class="home">
                <a href="index.jsp"><img src="images/imangine.png" alt="" /></a>
            </div>

            <div class="reglogbar-user pull-right">
                <div class="userp">
                    <a href="login.jsp">LOGIN</a> | <a href="register.jsp">REGISTER</a>
                </div>
            </div>
            <span class="menu"></span>
            <div class="top-menu">
                <ul>
                    <li><a href="picture_home.jsp">Picture</a></li>
                    <li><a href="album_home.jsp">Album</a></li>
                    <li><a href="group_home.jsp">Group</a></li>
                    <li><a class="active" href="search.jsp">Search</a></li>
                    <li><a href="about_imangine.jsp">About us</a></li>
                    <div class="clearfix"></div>
                </ul>
            </div>
            <!-- script for menu -->
            <script>
                $( "span.menu" ).click(function() {
                    $( ".top-menu" ).slideToggle( "slow", function() {
                        // Animation complete.
                    });
                });
            </script>
            <!-- script for menu -->
            <div class="clearfix"></div>
        </div>
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
                    <a href="personal.jsp"> <span><%=userLoginStatus.getUserName() %> &nbsp;</span> </a>
                    <a href="personal.jsp"> <img src="<%=userLoginStatus.getAvatarPath() %>" /> </a>
                </div>
            </div>
            <span class="menu"></span>
            <div class="top-menu">
                <ul>
                    <li><a href="picture_home.jsp">Picture</a></li>
                    <li><a href="album_home.jsp">Album</a></li>
                    <li><a href="group_home.jsp">Group</a></li>
                    <li><a class="active" href="search.jsp">Search</a></li>
                    <li><a href="about_imangine.jsp">About us</a></li>
                    <div class="clearfix"></div>
                </ul>
            </div>
            <!-- script for menu -->
            <script>
                $( "span.menu" ).click(function() {
                    $( ".top-menu" ).slideToggle( "slow", function() {
                        // Animation complete.
                    });
                });
            </script>
            <!-- script for menu -->
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<%
	}
%>