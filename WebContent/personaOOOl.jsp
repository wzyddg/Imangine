<%@page import="imangine.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Personal Center</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/respond.js"></script>
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
html {
	-ms-text-size-adjust: 100%;
	-webkit-text-size-adjust: 100%;
}

body {
	font-family: 'Microsoft Yahei', '微软雅黑', '宋体', \5b8b\4f53, Tahoma, Arial,
		Helvetica, STHeiti;
	margin: 0;
}

.main-nav-a a:hover {
	color: #ff5656;
}

.main-nav-a a:focus {
	color: #ff8e92;
}

/*********************************************自定义部分*********************************************/
.secondmenu a {
	font-size: 12px;
	color: #4A515B;
	text-align: center;
	border-radius: 4px;
}

.secondmenu>li>a:hover {
	background-color: rgba(179, 137, 68, 0.7);
	color: #ffffff;
}

.secondmenu>li.focus {
	background-color: rgba(222, 202, 196, 0.5);
	border-radius: 4px;
	color: #ff5656;
}

.secondmenu li.focus>a {
	color: #ff5656;
}

.collapse.glyphicon-chevron-toggle, .glyphicon-chevron-toggle:before {
	content: "\e113";
}

.collapsed.glyphicon-chevron-toggle:before {
	content: "\e114";
}

.UserInfo {
	text-align: center;
	background-color: rgba(179, 137, 68, 0.2);
	border-radius: 15px;
	color: black;
}
</style>
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
	
	<div class="content">
		<div class="container">
			<div class="container-fluid">
				<div class="row">
				
					<jsp:include page="PersonalNavi.jsp" />
					
					<%
						Users userLoginStatus = (Users) session
								.getAttribute("userLoginStatus");
					%>
					<div class="col-md-10">
						<div class="UserInfo">
							<div class="position"></div>
							<div class="UserInfo-p">
								<a><img width=500 src='<%=userLoginStatus.getDoll()%>' /></a>
							</div>
							<div class="position"></div>
							<div class="UserInfo-t">
								用户名：<span><%=userLoginStatus.getEmail()%></span>
							</div>
							<div class="position"></div>
							<div class="UserInfo-t">
								昵称：<span><%=userLoginStatus.getUserName()%></span>
							</div>
							<div class="position"></div>
							<div class="UserInfo-t">
								所在城市：<span><%=userLoginStatus.getCity() %></span>
							</div>
							<div class="position"></div>
							<div class="UserInfo-t">
								性别：<span><%=userLoginStatus.getGender() %></span>
							</div>
							<div class="position"></div>
							<div class="UserInfo-t">
								生日：<span><%=userLoginStatus.getBirthdayString() %></span>
							</div>
							<div class="position"></div>
							<div class="UserInfo-t">
								个人说明：<span><%=userLoginStatus.getDiscription()%></span>
							</div>
							<div class="position"></div>

						</div>
					</div>
				</div>
			</div>

		</div>

		<!---/start-text-slider-->

	</div>
	<jsp:include page="copyright.jsp" />
</body>
</html>