<%@page import="imangine.Pictures"%>
<%@page import="imangine.AlbumIncluded"%>
<%@page import="imangine.AlbumLiked"%>
<%@page import="java.util.List"%>
<%@page import="imangine.Users"%>
<%@page import="dbMatter.DBQuerrier"%>
<%@page import="imangine.Albums"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
	String albumIdString = request.getParameter("id");
	Users user = (Users) session.getAttribute("userLoginStatus");
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
	Albums album = DBQuerrier.getAlbumWithAlbumId(albumId);
	
	List<AlbumIncluded> ai = DBQuerrier.getAlbumContentsPicIdsWithAlbumId(albumId);
	
	if (album == null) {
%>
<jsp:forward page='404.jsp' />
<%
	}
%>
<head>
<title>Album:<%=album.getTheme()%></title>
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
			$.post("Like", {
				like : "1" + "##album##" + <%=albumId%>
	});
		}
		if (n % 2 == 0) {
			document.getElementById('l' + n).style.display = "none";
			document.getElementById('l' + (n - 1)).style.display = "inline";
			$.post("Like", {
				like : "2" + "##album##" + <%=albumId%>
	});
		}
	}

	function change1(n, pi) {
		if (n % 2 == 1) {
			document.getElementById('l' + (n + 1)).style.display = "inline";
			document.getElementById('l' + n).style.display = "none";
			$.post("Like", {
				like : "1##pic##" + pi
			});
		}
		if (n % 2 == 0) {
			document.getElementById('l' + n).style.display = "none";
			document.getElementById('l' + (n - 1)).style.display = "inline";
			$.post("Like", {
				like : "2##pic##" + pi
			});
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
</style>
</head>
<body>
	<div class="header" id="header">
		<jsp:include page="UserInfoBar.jsp" />
	</div>
	<div class="header-bottom">
		<div class="container"></div>
	</div>
	<jsp:include page="NaviBar.jsp" />


	<div class="content">
		<div class="container">
			<div class="single">
				<!-- head-section -->
				<div class="head-section text-center">
					<h2><%=album.getTheme()%></h2>
					<%if(user!=null) {%>
					<img class="likeit" id="l1" onclick="change(1)"
						style="display: inline;" src="images/hollowheart.png" /> <img
						class="likeit" id="l2" onclick="change(2)" style="display: none;"
						src="images/fullheart.png" />
					<%} %>
				</div>
				
				<div class="single-top">
					<img src='<%=album.getCoverAdderss() %>' alt="" />
				</div>
				<div class="top-single">
					<h2><%=album.getDescription() %></h2>
					<div class="grid-single">
						<div class="single-one">
							<span><i> </i><%=album.getSetDate().toString() %>
						</div>
						<%
						List<AlbumLiked> albumLiked = DBQuerrier.getAlbumLikeUserIdsWithAlbumId(albumId);
						%>
						</li>
						<div class="single-one">
							<span><i class="four"> </i><%=albumLiked.size() %></span>
						</div>
						<div class="clearfix"></div>
					</div>

					<div class="album-content">
							
							
							<%for(int i=0;i<ai.size();i++) {
								Pictures tmp = ai.get(i).getPictures();
								
								if(i%4==0){
							%>
							<div class="row">
							<%}
							%>
							<div class="col-md-3 project">
							<a href="single.jsp?id=<%=tmp.getPicId() %>" class="thumbnail"><img
									src='<%=tmp.getAddress() %>' alt="" /></a>
								<div class="hov">
								
								<img class="likeit pull-right" id='l<%=2*i+1 %>' onclick='change1(<%=2*i+1 %>,<%=tmp.getPicId() %>)'
										style="display: inline;" src="images/hollowheart.png" /> <img
										class="likeit pull-right" id='l<%=2*i+2 %>' onclick='change1(<%=2*i+2 %>,<%=tmp.getPicId() %>)'
										style="display: none;" src="images/fullheart.png" />
								</div>
								
								<!-- 点赞 -->
								
								<a href="single.jsp?id=<%=tmp.getPicId() %>"><div class="text">
										<div><%=tmp.getTitle() %></div>
									</div></a>
							</div>
								
							<%
								if (i % 4 == 3 || i == (ai.size() - 1)) {
							%>
						</div>
						<%
							}
							%>
							<%
								}
							%>		
							
						<div class="clearfix"></div>
					</div>

					<div class="single-middle">
						<div class="postor-info">
							<div class=" col-md-2 postor-port">
								<img src='<%=album.getUsers().getDoll() %>'
									alt="" />
							</div>
							<div class="col-md-5 postor-info-i">
								<span><%=album.getUsers().getUserName() %></span>
							</div>
							<div class="col-md-5 postor-info-i"><%=album.getUsers().getDiscription() %></div>
						</div>

						<div class="who-liked">
							<img src="images/fullheart.png" alt="" /> 
								<%for(int i=0;i<albumLiked.size();i++){ %>
									<img src='<%=albumLiked.get(i).getUsers().getDoll() %>' alt="" />
								<%} %>
						</div>

						<div class="clearfix"></div>
					</div>
			
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="copyright.jsp" />
</body>
</html>