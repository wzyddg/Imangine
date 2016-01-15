<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Register</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="picture,album,share,upload" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<!--webfont-->
<link href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
 <script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
			});
		});
	</script>
	<script src="http://www.lanrenzhijia.com/ajaxjs/jquery.min.js"></script>
	<script>
	$(function(){
	$(".hov").hide();
	$(".text").hide();	
	$(".col-md-3").hover(function(){	
		$(this).find(".hov").stop().fadeTo(286,0.5)
		$(this).find(".text").stop().show();
	},
	function(){
		$(this).find(".hov").stop().fadeTo(286,0)
		$(this).find(".text").stop().hide();
		// $(this).find(".text").animate({left:"-286px"}, {duration: 0})
	});
});
</script>
</head>
<body>
	<!-- header-section-starts -->
<div class="header" id="header">
		<jsp:include page="UserInfoBar.jsp"/>
	</div>
<div class="header-bottom">
    <div class="container">

    </div>
</div>
<jsp:include page="NaviBar.jsp"/>
	<div class="content">
		<div class="container">
			<div id="register">

                <form role="form" action="UserReg" enctype="multipart/form-data" method="post">
                    <div class="form-group">
                        <label for="name">用户名（手机/邮箱）</label>
                        <input type="text" class="form-control" id="name"
                               placeholder="请输入手机/邮箱">
                    </div>
                    <div class="form-group">
                        <label for="password">密码</label>
                        <input type="password" class="form-control" id="password"
                               placeholder="请输入密码">
                    </div>
                    <div class="form-group">
                        <label for="password">确认密码</label>
                        <input type="password" class="form-control" id="password"
                               placeholder="请输入密码">
                    </div>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox"> 阅读并接受《Imangine协议》
                        </label>
                    </div>
                    <input type="submit" class="btnsub" value="提交">
                </form>

			</div>
		</div>
	</div>
			<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<jsp:include page="copyright.jsp"/>
	
</body>
</html>