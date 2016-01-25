<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="imangine.database.entity.AlbumIncluded"%>
<%@page import="imangine.database.entity.AlbumIncludedId"%>
<%@page import="imangine.database.entity.AlbumLiked"%>
<%@page import="imangine.database.entity.AlbumLikedId"%>
<%@page import="imangine.database.entity.AlbumComment"%>
<%@page import="imangine.database.entity.Album"%>
<%@page import="imangine.database.entity.User"%>

<%@page import="imangine.database.dao.DataAccessObject"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<%
	String albumIdString = request.getParameter("id");
	User user = (User) session.getAttribute("userLoginStatus");
	String prePage = request.getRequestURI();
	//prePage = prePage.split("/")[2];
	//System.out.print(prePage);
	Integer albumId = null;
	try {
		albumId = Integer.parseInt(albumIdString);
	} catch (Exception e) {
%>
<jsp:forward page='404.jsp' />
<%
	}
	Album album = DataAccessObject.getAlbumWithAlbumId(albumId);
	
	List<AlbumIncluded> ai = DataAccessObject.getAlbumContentsPicIdsWithAlbumId(albumId);
	
	if (album == null) {
%>
<jsp:forward page='404.jsp' />
<%
	}
%>
<head>
<title><%=album.getTheme()%></title>
<link href="css/font.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.custom.js"></script>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Metushi Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!--webfont-->
<link
	href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1200);
		});
	});

	$(function() {
		$(".hov").hide();
		$(".text").hide();
		$(".col-md-3").hover(function() {
			$(this).find(".hov").stop().fadeTo(286, 0.5);
			$(this).find(".text").stop().show();
		}, function() {
			$(this).find(".hov").stop().fadeTo(286, 0);
			$(this).find(".text").stop().hide();
		});
	});

	function change(n) {
		if (n % 2 == 1) {
			document.getElementById('l' + (n + 1)).style.display = "inline";
			document.getElementById('l' + n).style.display = "none";
		}
		if (n % 2 == 0) {
			document.getElementById('l' + n).style.display = "none";
			document.getElementById('l' + (n - 1)).style.display = "inline";
		}
	}

	function changeA(n) {
		if (n % 2 == 1) {
			document.getElementById('l' + (n + 1)).style.display = "inline";
			document.getElementById('l' + n).style.display = "none";
			like: "1" + "##album##" +
<%=albumId%>
	}
		if (n % 2 == 0) {
			document.getElementById('l' + n).style.display = "none";
			document.getElementById('l' + (n - 1)).style.display = "inline";
			like: "2" + "##album##" +
<%=albumId%>
	}
	}
</script>
<style>
.thumbnail {
	max-height: 210px;
	min-height: 200px;
	overflow: hidden;
	bottom: 0;
	margin: 0;
	padding: 0;
}

.who-liked {
	width: 100%;
	float: left;
	padding: 10px;
	background-color: rgba(255, 86, 86, 0.2);
	border-radius: 20px;
}

.single-top img {
	max-width: 500px;
	height: auto;
}
</style>
</head>
<body>
	<jsp:include page="header_album_block.jsp" />
	<div class="content">
		<div class="container">
			<div class="single">
				<!-- head-section -->
				<div class="head-section text-center">
					<h2><%=album.getTheme()%></h2>
					<img class="likeit" id="l1" onclick="changeA(1)"
						style="display: inline;" src="images/hollowheart.png" /> <img
						class="likeit" id="l2" onclick="changeA(2)" style="display: none;"
						src="images/fullheart.png" />
					<!--<span> </span>-->
				</div>
				<!-- /head-section -->
				<div class="single-top ">
					<img src='<%=album.getCoverPath()%>' alt="" />
				</div>
				<div class="top-single">
					<h2><%=album.getDescription()%></h2>
					<div class="pull-right">
						<a href="album_modify.jsp">Album Management</a>
					</div>
					<%
						List<AlbumComment> albumComments = DataAccessObject
								.getAlbumCommentsWithAlbumId(albumId);
						List<AlbumLiked> albumLikeds = DataAccessObject
								.getAlbumLikeUserIdsWithAlbumId(albumId);
						List<AlbumIncluded> picAlbum = DataAccessObject
								.getAlbumContentsPicIdsWithAlbumId(albumId);
					%>
					<div class="grid-single">
						<div class="single-one">
							<span><i> </i><%=album.getSetDate().toString()%></span>
						</div>
						<div class="single-one">
							<span><a href="#"><i class="com"> </i><%=albumComments.size()%></a></span>
						</div>
						<div class="single-one">
							<span><i class="four"> </i><%=albumLikeds.size()%></span>
						</div>
						<div class="clearfix"></div>
					</div>

					<div class="album-content">
						<jsp:include page="hot_picture_recommendation_block.jsp"
							flush="true"><jsp:param name="page" value="0" /><jsp:param
								name="index" value="0" /></jsp:include>
						<jsp:include page="hot_picture_recommendation_block.jsp"
							flush="true"><jsp:param name="page" value="0" /><jsp:param
								name="index" value="0" /></jsp:include>
						<div class="pull-right">
							<a href=""><label>View All</label></a>
						</div>

						<div class="clearfix"></div>
					</div>

					<div class="single-middle">
						<div class="postor-info">
							<div class=" col-md-2 postor-port">
								<a href="personal.jsp?id=<%=album.getUser().getUserId() %>"><img src="<%=album.getUser().getAvatarPath() %>"
									alt="" /> </a>
							</div>
							<div class="col-md-5 postor-info-i">
								<span><%=album.getUser().getUserName() %></span>
							</div>
							<div class="col-md-5 postor-info-i"><%=album.getUser().getDescription() %></div>
						</div>

						<div class="who-liked">
							<img src="images/fullheart.png" alt="" /> <%
								for (int i = 0; i < albumLikeds.size(); i++) {
							%>

							<img src='<%=albumLikeds.get(i).getUser().getAvatarPath()%>' alt="" />

							<%
								}
							%><a href=""><label>View
									All</label></a>
						</div>
						
						<div class="clearfix"></div>
					</div>
					<div class="top-comments">
						<h3>Comments</h3>
						<%
							for (int i = 0; i < albumComments.size(); i++) {
								AlbumComment albumComment = albumComments.get(i);
						%>
						<div class="met">
							<div class="code-in">
								<p class="smith">
									<a href="#"><%=albumComment.getUser().getUserName()%></a> <span><%=albumComment.getCommentDate().toString() %></span>
								</p>
								<div class="clearfix"></div>
							</div>
							<div class="comments-top-top">
								<div class="men">
									<img src='<%=albumComment.getUser().getAvatarPath()%>' alt="">
								</div>
								<p class="men-it"><%=albumComment.getContent()%></p>
								<div class="clearfix"></div>
							</div>
						</div>
						<%
							}
						%>
					</div>
					<div class="leave">
						<h3>Leave a comment</h3>
						<%
							session.setAttribute("prePage", prePage + "?id=" + albumId);
							if (session.getAttribute("AlbumComStatus") == null)
								;
							else if (((Integer) session.getAttribute("AlbumComStatus"))
									.equals(new Integer(0))) {
								//				System.out.println(session.getAttribute("PicComStatus") + "这个要什么都不显示的");
							} else if ((Integer) session.getAttribute("AlbumComStatus") == 1) {
								//			System.out.println(session.getAttribute("PicComStatus") + "这个要显示成功的");
						%>
						<font color="#00FF00">评论成功！</font>
						<%
							} else {
								System.out.println(session.getAttribute("AlbumComStatus")
										+ "这个要显示失败的");
						%><font color="#FF0000">评论不能为空！</font>
						<%
							}
							session.setAttribute("AlbumComStatus", 0);
						%>
						<form action="SendAlbumComment?albumId=<%=album.getAlbumId() %>" method = "POST">
							<div class="col-md-1">
								<div class="leave-info">
									<div class="leave-port">
										<img src='<%=user.getAvatarPath()%>' alt="">
									</div>
									<div>
										<span><%=user.getUserName() %></span>
									</div>
								</div>
							</div>
							<div class="text-top">
								<div class="col-md-8 text-in">
									<textarea name="comCon" placeholder="Comment"></textarea>
								</div>
								<div class="col-md-3 text-in">
									<input type="submit" value="SEND">
								</div>
								<div class="clearfix"></div>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer_block.jsp" />
</body>
</html>