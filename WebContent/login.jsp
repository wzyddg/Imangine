<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Login</title>
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
</script>
<style>
.inputbtn {
	background-color: #ff5656;
	color: #fff;
	font-weight: 700;
	font-family: "Microsoft YaHei";
}
</style>
</head>
<body>
	<!-- header-section-starts -->

	<jsp:include page="header_index_block.jsp" />
	<div class="content">
		<div class="container">
			<form role="form" action="Login" method="post"
				style="padding: 30px 0;">
				<div class="form-group">
					<label for="name">User Name (Phone Number/E-mail)</label> <input
						type="text" class="form-control" id="name" name="name"
						placeholder="Please input your user name">
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						class="form-control" id="password" name="password"
						placeholder="Please input your password">
				</div>
				<%
					Boolean loginSuccess = (Boolean) request
							.getAttribute("LoginSuccess");
					if (loginSuccess == null || loginSuccess == true)
						;
					else {
				%>
				<font color="#FF0000">Invalid User Name or Password !<br />
				<br /></font>
				<%
					}
				%>
				<input class="inputbtn" type="submit" name="rigister" value="Login">


				<!--<button type="submit" class="btnsub">登录</button>-->
			</form>

			<!---/start-text-slider-->
			<div class="testimonials"></div>
		</div>
	</div>
	<jsp:include page="footer_block.jsp" />

</body>
</html>