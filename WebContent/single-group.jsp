<%@page import="imangine.GroupMem"%>
<%@page import="imangine.GroupComment"%>
<%@page import="imangine.Groups"%>
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
	String groupIdString = request.getParameter("id");
	Users user = (Users) session.getAttribute("userLoginStatus");
	String prePage = request.getRequestURI();
	//prePage = prePage.split("/")[2];
	//System.out.print(prePage);
	Integer groupId = null;
	try {
		groupId = Integer.parseInt(groupIdString);
	} catch (Exception e) {
%>
<jsp:forward page='404.jsp' />
<%
	}
	Groups group = DBQuerrier.getGroupWithGroupId(groupId);
	
	List<AlbumIncluded> ai = DBQuerrier.getAlbumContentsPicIdsWithAlbumId(groupId);
	
	if (group == null) {
%>
<jsp:forward page='404.jsp' />
<%
	}
%>
<head>
<title>Group:<%=group.getName()%></title>
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
	margin-bottom: 20px;
}

.unsign {
	font-weight: 500;
	font-size: 30px;
	background-color: #ff5656;
	margin: 30px;
	color: #fff;
}
.text-top {
	text-align: center;
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
					<h2><%=group.getName()%></h2>

				</div>
				<!-- /head-section -->
				<div class="single-top">
					<img src='<%=group.getUsers().getDoll()%>' alt="" />
				</div>
				<div class="top-single">
					<h2><%=group.getTheme()%></h2>
					<div class="grid-single">
						<div class="single-one">
							<span><i> </i><%=group.getSetDate().toString()%>
						</div>
						</li>
						<%
							List<GroupComment> gcs = DBQuerrier
									.getGroupCommentsWithGroupId(groupId);
						%>
						<div class="single-one">
							<span><a href="#"><i class="com"> </i><%=gcs.size()%></a></span>
						</div>
						<div class="clearfix"></div>
					</div>



					<div class="single-middle">
						<div class="postor-info">
							<div class=" col-md-2 postor-port">
								<a href="blog.jsp?id=<%=group.getUsers().getUserId()%>"><img
									src='<%=group.getUsers().getDoll()%>' alt="" /> </a>
							</div>
							<div class="col-md-5 postor-info-i">
								<span><%=group.getUsers().getUserName()%></span>
							</div>
							<div class="col-md-5 postor-info-i">
								<%=group.getUsers().getDiscription()%>
							</div>
						</div>
						<div class="clearfix"></div>

						<div class="clearfix"></div>

						<%
							List<GroupMem> gm = DBQuerrier.getGroupMembersWithGroupId(groupId);
						%>
						<div class="group-members">
							<h4 class="head">
								<a href="sharing-discov.jsp">Members</a><span class="line"></span>
							</h4>


							<%
								for (int i = 0; i < gm.size(); i++) {
									Users mem = gm.get(i).getUsers();
									if (i % 6 == 0) {
							%>
							<div class="row">
								<%
									}
								%>

								<div class="col-md-2">
									<a href="blog.jsp?id=<%=mem.getUserId()%>" class="thumbnail"><img
										src='<%=mem.getDoll()%>' alt="" /></a>
								</div>

								<%
									if (i % 6 == 5 || i == (gm.size() - 1)) {
								%>
							</div>
							<div class="clearfix"></div>
							<%
								}
							%>
							<%
								}
							%>


							<!--</div>-->
							<div class="clearfix"></div>
						</div>
						<div class="top-comments">
							<h3>Comments</h3>

							<%
								for (int i = 0; i < gcs.size(); i++) {
									GroupComment groupComment = gcs.get(i);
							%>


							<div class="met">
								<div class="code-in">
									<p class="smith">
										<a href="#"><%=groupComment.getUsers().getUserName()%></a> <span><%=groupComment.getCommentDate().toString()%></span>
									</p>

									<div class="clearfix"></div>
								</div>
								<div class="comments-top-top">
									<div class="men">
										<img src='<%=groupComment.getUsers().getDoll()%>' alt="">
									</div>
									<p class="men-it"><%=groupComment.getContent()%></p>
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
								session.setAttribute("prePage", prePage + "?id=" + groupId);
								if (user != null) {
									if (session.getAttribute("GroupComStatus") == null)
										;
									else if (((Integer) session.getAttribute("GroupComStatus"))
											.equals(new Integer(0))) {
										//				System.out.println(session.getAttribute("GroupComStatus") + "这个要什么都不显示的");
									} else if ((Integer) session.getAttribute("GroupComStatus") == 1) {
										//			System.out.println(session.getAttribute("GroupComStatus") + "这个要显示成功的");
							%>
							<font color="#00FF00">评论成功！</font>
							<%
								} else {
										System.out.println(session.getAttribute("GroupComStatus")
												+ "这个要显示失败的");
							%><font color="#FF0000">评论不能为空！</font>
							<%
								}
									session.setAttribute("GroupComStatus", 0);
							%>
							<form action="SendGroupComment?groupId=<%=groupId%>" method="post">
								<div class="col-md-1">
									<div class="leave-info">
										<div class="leave-port">
											<img src='<%=user.getDoll()%>' alt="">
										</div>
										<div>
											<span><%=user.getUserName()%></span>
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
							<%
								} else {
							%>
							<div>
								<div class="text-top">
									<div class="col-md-6 text-in">
										<a href="login.jsp"><div class="unsign">Login</div></a>
									</div>
									<div class="col-md-6 text-in">
										<a href="register.jsp"><div class="unsign">Register</div></a>
									</div>
									<div class="clearfix"></div>
								</div>
							</div>


							<%
								}
							%>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="copyright.jsp" />
</body>
</html>