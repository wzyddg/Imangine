<%@page import="imangine.database.dao.DataAccessObject"%>
<%@page import="imangine.database.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="imangine.database.entity.Picture"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>picSharing</title>
<link href="css/font.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<script src="js/jquery.min.js"></script>
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
</script>
<script src="http://www.lanrenzhijia.com/ajaxjs/jquery.min.js"></script>
<script>
	$(function() {
		$(".hov").hide();
		$(".text").hide();
		$(".col-md-3").hover(function() {
			$(this).find(".hov").stop().fadeTo(286, 0.5)
			$(this).find(".text").stop().show();
		}, function() {
			$(this).find(".hov").stop().fadeTo(286, 0)
			$(this).find(".text").stop().hide();
			// $(this).find(".text").animate({left:"-286px"}, {duration: 0})
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
</style>
</head>
<body>
	<!-- header-section-starts -->

	<jsp:include page="header_picture_block.jsp" />
	<%
		User userLoginStatus = (User) session
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

			List<Picture> pics = DataAccessObject.getHotSharePicsWithIndex(pageNum*2);

			if (pics.size() == 0 && pageNum > 0) {
		response.sendRedirect("hot_picture_recommendation.jsp?page=" + (pageNum - 1));
			}
	%>

	<div class="content">
		<div class="container">
			<div class="projects-section">
				<h4 class="head">
					<a href="hot_picture_recommendation.jsp">Hot Pictures</a><span
						class="line"></span>
				</h4>
				<div class="latest-projects">

					<jsp:include page="hot_picture_recommendation_block.jsp"
						flush="true"><jsp:param name="page"
							value="<%=2 * pageNum%>" /><jsp:param name="index" value="0" /></jsp:include>
					<jsp:include page="hot_picture_recommendation_block.jsp"
						flush="true"><jsp:param name="page"
							value="<%=2 * pageNum + 1%>" /><jsp:param name="index" value="1" /></jsp:include>

					<div class="clearfix"></div>
				</div>
				<div class="row">
					<div clss="col-md-12"></div>
					<div class="pagination text-center">
						<ul>
							<li><a class="prev"
								href="hot_picture_recommendation.jsp?page=<%=(pageNum > 0 ? pageNum - 1 : 0)%>">＜Prev</a></li>
							<li><%=pageNum + 1%></li>
							<li><a class="next"
								href="hot_picture_recommendation.jsp?page=<%=pageNum + 1%>">Next＞</a></li>
						</ul>
					</div>
				</div>
			</div>

		</div>
	</div>
	<jsp:include page="footer_block.jsp" />

</body>
</html>