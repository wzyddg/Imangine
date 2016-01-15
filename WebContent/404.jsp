<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html>
<head>
<title>404</title>
<link href="css/font.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Metushi Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
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
	<div class="navigation-strip">
        <div class="container">
            <div class="nav_content">
                <div class="home">
                    <a href="index.jsp"><img src="images/imangine.png" alt="" /></a>
                </div>
                <div class="search">
                    <form>
                        <input type="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search..';}"/>
                        <input type="submit" value="">
                    </form>
                </div>
                <!--<div class="reglogbar-user pull-right">-->
                    <!--<div class="userp">-->
                        <!--<a href="#"> <span>Jully Coco &nbsp;</span> </a>-->
                        <!--<a href="#"> <img src="images/user-p.png" /> </a>-->
                    <!--</div>-->
                <!--</div>-->
                <span class="menu"></span>
                <div class="top-menu">
                    <ul>
                        <li><a class="active" href="pic.jsp">Picture</a></li>
                        <li><a href="album.jsp">Album</a></li>
                        <li><a href="group.jsp">Group</a></li>
                        <li><a href="search.jsp">Search</a></li>
                        <li><a href="about.jsp">About us</a></li>
                        <div class="clearfix"></div>
                    </ul>
                </div>
                <!-- script for menu -->
                <script>
                    $( "span.menu" ).click(function() {
                        $( ".top-menu" ).slideToggle( "slow", function() {
                            // Animation complete.
                        });
                    });
                </script>
                <!-- script for menu -->
                <div class="clearfix"></div>
            </div>
        </div>
	</div>
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
	<div class="footer">
		<div class="footer-top">
			<div class="container">
				<div class="col-md-4 footer-grid">
					<h5>ABOUT US</h5>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla in purus nibh. Donec ornare felis neque. Nullam tortor nulla, sodales quis posuere quis, tristique nec libero. Proin vitae convallis odio. Morbi nec enim nisi. Aliquam erat volutpat. </p>
				</div>
				<div class="col-md-4 footer-grid">
					<h5>TWITTER FEED</h5>
					<p>Check out th best Themes online in the world <br>at <a href="mail-to:example.com">http://example.com </a></p>
					<span>1 day ago</span>
					<p><a href="#">@envanto</a>, Motive wordpress theme full responsive is coming soon...</p>
					<span>4 day ago</span>
				</div>
				<div class="col-md-4 footer-grid">
					<h5>FOLLOW US</h5>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla in purus nibh. Donec ornare felis neque. Nullam tortor! </p>
					
			<div class="social-icons">
				<a href="#"><i class="twitter"></i></a>
				<a href="#"><i class="facebook"></i></a>
				<a href="#"><i class="dribble"></i></a>
				<a href="#"><i class="rss"></i></a>
			</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="container">
				<div class="copyrights">
                    <p>Copyright &copy; 2015.Imangine All rights reserved.</p>
				</div>
				<div class="go-top">
					<a href="#header" class="scroll"><img src="images/go-to-top.png" alt="" /></a>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</body>
</html>