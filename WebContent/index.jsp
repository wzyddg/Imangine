<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Home</title>
<link href="css/font.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->

<!-- Custom Theme files -->
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.custom.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>

<!--webfont-->
<!--<link href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>-->
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

<script>
	$(function() {
		$(".hov").hide();
		$(".text").hide();
		$(".col-md-3").hover(function() {
			$(this).find(".hov").stop().fadeTo(286, 0.5);
			$(this).find(".text").stop().show();
		}, function() {
			$(this).find(".hov").stop().fadeTo(286, 0);
			$(this).find(".text").stop().hide();
		});
	});
	//    $(".like").hide();

	//    $(function likeit(){
	//        for(var i=1;i<=16;i++){
	//            if(document.getElementById("u"+i).onclick==true){
	//                document.getElementById("u"+i).hide();
	//                document.getElementById("l"+i).show();
	//            }
	//        }
	//    });
	//
	//    $(function unlikeit(){
	//        for(var i=1;i<=16;i++){
	//            if(document.getElementById("l"+i).onclick==true){
	//                document.getElementById("l"+i).hide();
	//                document.getElementById("u"+i).show();
	//            }
	//        }
	//    });
</script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});

	//        function change(n){
	//            if(n%2==1){
	//                document.getElementById('l'+(n+1)).style.display="inline";
	//                document.getElementById('l'+n).style.display="none";
	//
	//            }
	//            if(n%2==0){
	//                document.getElementById('l'+n).style.display="none";
	//                document.getElementById('l'+(n-1)).style.display="inline";
	//            }
	//        }

	function change(n, id) {
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
	<jsp:include page="index_header_block.jsp" />
	<div class="slideing">
		<div class="head-bg">
			<!-- container -->
			<div class="container">
				<!--<div class="head-logo">-->
				<!--<a href="index.jsp"><img src="images/logo.png" alt="" /></a>-->
				<!--</div>-->
				<div class="top-nav">
					<ul class="cl-effect-1">
						<!--<li><a href="contact.jsp">Contact</a></li>-->
						<li><a href="about_imangine.jsp">About us</a></li>
						<li><a href="search.jsp">Search</a></li>
						<li><a href="group_home.jsp">Group</a></li>
						<li><a href="album_home.jsp">Album</a></li>
						<li><a href="picture_home.jsp">Picture</a></li>
						<li><a href="picture_upload.jsp">Upload</a></li>

						<!--<div class="clearfix"></div>-->
					</ul>
					<!-- script-for-menu -->
					<script>
						$("span.menu").click(function() {
							$("ul.cl-effect-1").slideToggle(300, function() {
								// Animation complete.
							});
						});
					</script>
					<!-- /script-for-menu -->
				</div>
				<div class="clearfix"></div>
			</div>
			<!-- //container -->
		</div>
		<!-- container -->
		<div class="container">
			<!-- banner Slider starts Here -->
			<script src="js/responsiveslides.min.js"></script>
			<script>
				// You can also use "$(window).load(function() {"
				$(function() {
					// Slideshow 4
					$("#slider3").responsiveSlides(
							{
								auto : true,
								pager : false,
								nav : false,
								speed : 500,
								namespace : "callbacks",
								before : function() {
									$('.events').append(
											"<li>before event fired.</li>");
								},
								after : function() {
									$('.events').append(
											"<li>after event fired.</li>");
								}
							});

				});

				//                function change(n){
				//                    if(n==1){
				//                        document.getElementById('l2').show();
				//                        document.getElementById('l1').hidden();
				//                    }
				//                    if(n==2){
				//                        document.getElementById('l1').show();
				//                        document.getElementById('l2').hidden();
				//                    }
				//                }
			</script>
			<!--//End-slider-script -->
			<div id="top" class="callbacks_container">
				<ul class="rslides" id="slider3">
					<li>
						<div class="head-info">
							<h1>
								Life<span>Innovate and take the time</span>
							</h1>
							<p>Investing the resources and caring enough to try.</p>
						</div>
					</li>
					<li>
						<div class="head-info">
							<h1>
								Design<span>Soul of a human-made creation</span>
							</h1>
							<p>Nothing could be further from the meaning of design.</p>
						</div>
					</li>
					<li>
						<div class="head-info">
							<h1>
								Sharing<span>Good coffee to friends and taste</span>
							</h1>
							<p>We must be Shared with other life of our earth.</p>
						</div>
					</li>
				</ul>
			</div>

		</div>
		<!-- container -->
	</div>

	<div class="content">
		<div class="container">
			<div class="projects-section">
				<h4 class="head">
					Hot Sharing<span class="line"></span>
				</h4>
				<div class="latest-projects">
					<jsp:include page="hot_picture_recommendation_block.jsp" flush="true"><jsp:param
							name="page" value="0" /><jsp:param
							name="index" value="0" /></jsp:include>
					<jsp:include page="hot_picture_recommendation_block.jsp" flush="true"><jsp:param
							name="page" value="1" /><jsp:param
							name="index" value="1" /></jsp:include>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="footer-top">
			<div class="container">
				<div class="col-md-4 footer-grid">
					<h5>ABOUT US</h5>
					<p>Group from School of Software Engineering in Tongji
						University</p>
				</div>
				<div class="col-md-4 footer-grid">
					<h5>FEED</h5>
					<p>Please send email to charlottie77@163.com</p>
					<span>1 day ago</span>
					<p>
						<a href="#">@envanto</a>, Motive wordpress theme full responsive
						is coming soon...
					</p>
					<span>4 day ago</span>
				</div>
				<div class="col-md-4 footer-grid">
					<h5>FOLLOW US</h5>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Nulla in purus nibh. Donec ornare felis neque. Nullam tortor!</p>


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
					<a href="#header" class="scroll"><img
						src="images/go-to-top.png" alt="" /></a>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>

</body>
</html>