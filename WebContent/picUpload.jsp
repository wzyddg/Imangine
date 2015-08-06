<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Picture Upload</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
	var isIE = /msie/i.test(navigator.userAgent) && !window.opera;
	function fileChange(target, id) {
		var fileSize = 0;
		var filepath = target.value;
		var filemaxsize = 1024 * 5; 
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
	<div class="header" id="header">
		<jsp:include page="UserInfoBar.jsp" />
	</div>
	<div class="header-bottom">
		<div class="container"></div>
	</div>
	<jsp:include page="NaviBar.jsp" />
	<div class="content">
		<div class="container">
			<div id="login">
				<form role="form" action="PictureUpload"
					enctype="multipart/form-data" method="post">
					<div class="form-group">
						<label for="title">图片标题</label> <input type="text"
							class="form-control" id="title" name="title"
							placeholder="请输入图片标题">
					</div>
					<div class="form-group">
						<label for="tag">图片标签（多个标签用逗号隔开）</label> <input type="text"
							class="form-control" id="tag" name="tag" placeholder="请输入图片标签">
					</div>
					<div class="form-group">
						<label for="description">图片描述</label>
						<textarea class="form-control" id="description" name="description"
							rows="3" placeholder="请输入图片描述"></textarea>
					</div>
					<div class="form-group">
						<label for="inputfile">文件输入</label>
						<%
							if (request.getParameter("error") == null);
							else if (request.getParameter("error").equals("" + 1)) {
						%>
						<br />
						<font color="#FF0000">图片信息过长或不合法！</font>
						<%
							} else if (request.getParameter("error").equals("" + 2)) {
						%>
						<br />
						<font color="#FF0000">请选择图片文件！</font>
						<%
							}
						%>
						<input type="file" id="inputfile" name="inputfile" onchange="fileChange(this);">
					</div>
					<input class="inputbtn" type="submit" name="upload" value="立即上传">
				</form>

			</div>
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
		</div>
	</div>

	<jsp:include page="copyright.jsp" />

</body>
</html>