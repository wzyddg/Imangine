<%@page import="imangine.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="myCarousel" class="carousel slide">
	<!-- 轮播（Carousel）指标 -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>
	<!-- 轮播（Carousel）项目 -->
	<div class="carousel-inner">
		<div class="item active">
			<img src="images/slide1.jpg" alt="First slide">
			<div class="carousel-caption">天墉城</div>
		</div>
		<div class="item">
			<img src="images/slide2.jpg" alt="Second slide">
			<div class="carousel-caption">宫殿山</div>
		</div>
		<div class="item">
			<img src="images/slide3.jpg" alt="Third slide">
			<div class="carousel-caption">大明寺</div>
		</div>
	</div>
	<!-- 轮播（Carousel）导航 -->
	<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
	<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
</div>
<%
	Users user = (Users) session.getAttribute("userLoginStatus");
%>
<nav class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#example-navbar-collapse">
			<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#">Hi! <%=(user==null? "游客" : user.getUserName())%></a>
	</div>
	<div class="collapse navbar-collapse" id="example-navbar-collapse">
		<ul class="nav navbar-nav">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"> Picture <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a href="blog.jsp">My Picture</a></li>
					<li><a href="favPic.jsp">Favorite Picture</a></li>
				</ul></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"> Album <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a href="album-my.jsp">My Album</a></li>
					<li><a href="album-fav.jsp">Favorite Album</a></li>
				</ul></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"> Group <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a href="group-my.jsp">My Group</a></li>
					<li><a href="group-fav.jsp">Favorite Group</a></li>
				</ul></li>
		</ul>
	</div>
</nav>
