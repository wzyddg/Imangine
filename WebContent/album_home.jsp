<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="imangine.database.entity.Album"%>
<!DOCTYPE html>
<html>
<head>
<title>Album</title>
<link href="css/font.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
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
	max-height: 357px;
	min-height: 357px;
	overflow: hidden;
	bottom: 0;
	margin: 0;
	padding: 0;
}
</style>
</head>
<body>
	<!-- header-section-starts -->

	<jsp:include page="header_album_block.jsp" />
	<div class="content">
		<div class="container">
			<div class="blog-posts-section">
				<!-- head-section -->

				<h4 class="head">
					<a href="album-hot.html">Hot Albums</a><span class="line"></span>
				</h4>

				<div class="blog-post-grids blog_grids">
					<jsp:include page="hot_album_recommendation_block.jsp" />

					<h4 class="head">
						<a href="album-recent.html">Recent Albums</a><span class="line"></span>
					</h4>

					<div class="blog-post-grids blog_grids">
						<jsp:include page="hot_album_recommendation_block.jsp" />

						<h4 class="head">
							<a href="album-disc.html">Album Discovery</a><span class="line"></span>
						</h4>

						<div class="blog-post-grids blog_grids">
							<jsp:include page="hot_album_recommendation_block.jsp" />

						</div>
						
					</div>
				</div>
			</div>

		</div>
	</div>
	<jsp:include page="footer_block.jsp" />
</body>
</html>