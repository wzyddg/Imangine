<%@page import="imangine.GroupMem"%>
<%@page import="imangine.Groups"%>
<%@page import="imangine.Users"%>
<%@page import="dbMatter.DBQuerrier"%>
<%@page import="imangine.Pictures"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Favorite Group</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="picture,album,share,upload" />
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
</script>
</head>
<body>
	<!-- header-section-starts -->
	<div class="header" id="header">
		<jsp:include page="UserInfoBar.jsp" />
	</div>
	<div class="header-bottom">
		<div class="container"></div>
	</div>
	<jsp:include page="NaviBar.jsp" />

	<%
		Users userLoginStatus = (Users) session
				.getAttribute("userLoginStatus");
		String pageString = request.getParameter("page");
		int pageNum = 0;
		if (pageString == null || pageString.equals("")) {
			pageNum = 0;
		} else {
			try {
				pageNum = Integer.parseInt(pageString);
			} catch (Exception e) {
				pageNum = 0;
			}
		}

		List<GroupMem> grouplist = DBQuerrier.getGroupsWithUserIdNIndex(
				userLoginStatus.getUserId(), pageNum);

		if (grouplist.size() == 0 && pageNum > 0) {
			response.sendRedirect("group-fav.jsp?page=" + (pageNum - 1));
		}
	%>

	<div class="content">
		<div class="container">
			<div class="blog-posts-section">
				<!-- head-section -->
				<div class="head-section text-center">
					<h2>Group</h2>
					<span> </span>
				</div>
				<div class="picUpload">
					<a href="picUpload.jsp">建立小组</a> <span> </span>
				</div>
				<jsp:include page="Carousel.jsp" />

				<div class="blog-post-grids blog_grids">
					<%
						for (int i = 0; i < grouplist.size(); i++) {
							GroupMem tmp = grouplist.get(i);
							if (i == 0 || i == 3) {
					%>
					<div class="col-md-4 blog-posts">
						<%
							}
								if (i == 6) {
						%>
						<div class="col-md-4 blog-posts span_66">
							<%
								}
							%>
							<div class="blog-post">
								<a
									href="single-group.jsp<%="?id=" + tmp.getGroups().getGroupId()%>"><img
									src='<%=tmp.getGroups().getUsers().getDoll()%>'></a> <a
									href="single-group.jsp<%="?id=" + tmp.getGroups().getGroupId()%>"
									class="blog-title"><%=tmp.getGroups().getName()%></a>
								<p class="sub_head">
									Posted by <a href="#"><%=tmp.getGroups().getUsers().getUserName()%></a>
									on
									<%=tmp.getGroups().getSetDate().toString()%>
								</p>
								<span></span>

							</div>
							<%
								if (i % 3 == 2 || i == (grouplist.size() - 1)) {
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
					<div class="pagination text-center">
						<ul>
							<li><a class="prev"
								href="group-fav.jsp?page=<%=(pageNum > 0 ? pageNum - 1 : 0)%>">＜Prev</a></li>
							<li><%=pageNum + 1%></li>
							<li><a class="next"
								href="group-fav.jsp?page=<%=pageNum + 1%>">Next＞</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="copyright.jsp" />
</body>
</html>