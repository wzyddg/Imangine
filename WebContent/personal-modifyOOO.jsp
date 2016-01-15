<%@page import="imangine.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Personal Modify</title>
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
<script type="text/javascript">
	var isIE = /msie/i.test(navigator.userAgent) && !window.opera;
	function fileChange(target, id) {
		var fileSize = 0;
		var filepath = target.value;
		var filemaxsize = 1024 * 2;
		if (filepath) {
			var isnext = false;
			var fileend = filepath.substring(filepath.indexOf("."));

		} else {
			return false;
		}
		if (isIE && !target.files) {
			var filePath = target.value;
			var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
			if (!fileSystem.FileExists(filePath)) {
				alert("图片不存在，请重新输入！");
				return false;
			}
			var file = fileSystem.GetFile(filePath);
			fileSize = file.Size;
		} else {
			fileSize = target.files[0].size;
		}

		var size = fileSize / 1024;
		if (size > filemaxsize) {
			alert("图片大小不能大于" + filemaxsize / 1024 + "M！");
			target.value = "";
			return false;
		}
		if (size <= 0) {
			alert("图片大小不能为0M！");
			target.value = "";
			return false;
		}
	}
</script>
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
						Users user = (Users) session.getAttribute("userLoginStatus");
					%>
					<div class="col-md-10">
						<form role="form" action="ModifyPersonal"
							enctype="multipart/form-data" method="post">
							<div class="position"></div>
							<div class="form-group">
								<label for="inputfile">修改头像</label> <input type="file"
									id="inputfile" name="inputfile" onchange="fileChange(this);">
								<!--<p class="help-block">这里是块级帮助文本的实例。</p>-->
							</div>
							<div class="form-group">
								<label for="name">修改昵称</label> <input type="text"
									class="form-control" id="name" name="name"
									value='<%=user.getUserName()%>' placeholder="请输入用户名">
							</div>

							<div class="form-group">
								<label for="city">修改所在城市</label> <input type="text"
									class="form-control" id="city" name="city"
									value='<%=user.getCity()%>' placeholder="请输入城市名">
							</div>
							<div class="form-group">
								<label for="gender">修改性别</label> <input type="text"
									class="form-control" id="gender" name="gender"
									value='<%=user.getGender()%>' placeholder="请输入性别">
							</div>
							<div class="form-group">
								<label for="description">修改个人描述</label> <input type="text"
									class="form-control" id="description" name="description"
									value='<%=user.getDiscription()%>' placeholder="请输入个人描述">
							</div>

							<div class="form-group">
								<label for="opassword">修改密码</label> <input type="password"
									class="form-control" id="opassword" name="opassword"
									placeholder="请输入旧密码">
							</div>
							<div class="form-group">
								<label for="npassword">新密码</label> <input type="password"
									class="form-control" id="npassword" name="npassword"
									placeholder="请输入新密码">
							</div>
							<div class="form-group">
								<label for="cnpassword">确认新密码</label> <input type="password"
									class="form-control" id="cnpassword" name="cnpassword"
									placeholder="请再次输入新密码">
							</div>
							<%
								if (request.getParameter("error") == null)
									;
								else if (request.getParameter("error").equals("" + 1)) {
							%>
							<br /> <font color="#FF0000">信息长度不合法！</font>
							<%
								} else if (request.getParameter("error").equals("" + 3)) {
							%>
							<br /> <font color="#FF0000">当前密码错误！</font>
							<%
								} else if (request.getParameter("error").equals("" + 0)) {
							%>
							<br /> <font color="#00FF00">修改成功！</font>
							<%
								} else if (request.getParameter("error").equals("" + 4)) {
							%>
							<br /> <font color="#FF0000">两次输入的新密码不一致！</font>
							<%
								} else if (request.getParameter("error").equals("" + 2)) {
							%>
							<br /> <font color="#FF0000">请为头像选择图片文件！</font>
							<%
								}
							%><p>
							<input type="submit" class="inputbtn" value="提交">
							<div class="position"></div>
						</form>

					</div>
				</div>
			</div>



		</div>



	</div>

	<jsp:include page="copyright.jsp" />
</body>
</html>