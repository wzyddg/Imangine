<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Can't Find Page</title>
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
</head>
<body>
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
			<!--404-->
			<div class="error">
			<div class="error-head">
						 <h1>4<span>0</span>4</h1>
						 <h2>Sorry This page is not found...!</h2>
						 <a class="hvr-bounce-to-left button" href="index.jsp">Go Back</a>
					 </div>
			</div>
		</div>	
	</div>
	<br/>
	<jsp:include page="copyright.jsp"/>
</body>
</html>