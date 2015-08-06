<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Portfolio</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="picture,share,like,beauty,download" />
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
	  <!-- Light Box -->
    <link rel="stylesheet" href="css/swipebox.css">
    <script src="js/jquery.swipebox.min.js"></script> 
    <script type="text/javascript">
		jQuery(function($) {
			$(".swipebox").swipebox();
		});
	</script>
    <!-- Eng Light Box -->	
	 <!-- Script for gallery Here -->
				<script type="text/javascript" src="js/jquery.mixitup.min.js"></script>
					<script type="text/javascript">
					$(function () {
						
						var filterList = {
						
							init: function () {
							
								// MixItUp plugin
								// http://mixitup.io
								$('#portfoliolist').mixitup({
									targetSelector: '.portfolio',
									filterSelector: '.filter',
									effects: ['fade'],
									easing: 'snap',
									// call the hover effect
									onMixEnd: filterList.hoverEffect()
								});				
							
							},
							
							hoverEffect: function () {
							
								// Simple parallax effect
								// $('#portfoliolist .portfolio').hover(
								// 	function () {
								// 		$(this).find('.label').stop().animate({bottom: 0}, 200, 'easeOutQuad');
								// 		$(this).find('img').stop().animate({top: -30}, 500, 'easeOutQuad');				
								// 	},
								// 	function () {
								// 		$(this).find('.label').stop().animate({bottom: -40}, 200, 'easeInQuad');
								// 		$(this).find('img').stop().animate({top: 0}, 300, 'easeOutQuad');								
								// 	}		
								// );				
							
							}
				
						};
						
						// Run the show!
						filterList.init();
						
						
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
	<div class="portfolio-content">
			<!-- portfolio -->
			<div class="portfolio-section" id="portfolio">			
				<!-- head-section -->
					<div class="head-section text-center">
						<h2>LIFE IS A KIND OF DESIGN</h2>
						<span> </span>
						<div><a href="single.jsp"></a></div>
					</div>
					<!-- /head-section -->
				 <ul id="filters" class="clearfix">
						<li><span class="filter active" data-filter="app card icon logos web">ALL</span></li>
						<!-- <li><span class="filter" data-filter="">Photography</span></li> -->
						<li><span class="filter" data-filter="app">Photography</span></li>
						<li><span class="filter" data-filter="card">Events</span></li>
						<li><span class="filter" data-filter="icon">Design</span></li>
						<li><span class="filter" data-filter="logos">Projects</span></li>
						</ul>
					<div id="portfoliolist">
					<div class="portfolio card mix_all  wow bounceIn" data-wow-delay="0.4s" data-cat="card" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper grid_box">		
							 <a href="images/pic-1.jpg" class="swipebox"  title="Image Title"> <img src="images/pic-1.jpg" class="img-responsive" alt=""><span class="zoom-icon"> </span> </a>

		                </div>
					</div>				
					<div class="portfolio app mix_all  wow bounceIn" data-wow-delay="0.4s" data-cat="app" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper grid_box">		
							 <a href="images/pic-2.jpg" class="swipebox"  title="Image Title"> <img src="images/pic-2.jpg" class="img-responsive" alt=""><span class="zoom-icon"></span> </a>

		                </div>
					</div>					
					<div class="portfolio icon mix_all  wow bounceIn" data-wow-delay="0.4s" data-cat="icon" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper grid_box">		
							 <a href="images/pic-3.jpg" class="swipebox"  title="Image Title"> <img src="images/pic-3.jpg" class="img-responsive" alt=""><span class="zoom-icon"></span> </a>

		                </div>

					</div>
					
					<div class="portfolio app mix_all  wow bounceIn" data-wow-delay="0.4s" data-cat="app" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper grid_box">		
							 <a href="images/pic-4.jpg" class="swipebox"  title="Image Title"> <img src="images/pic-4.jpg" class="img-responsive" alt=""><span class="zoom-icon"></span> </a>

		                </div>
					</div>			
					<div class="portfolio card mix_all  wow bounceIn" data-wow-delay="0.4s" data-cat="card" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper grid_box">		
							 <a href="images/pic-5.jpg" class="swipebox"  title="Image Title"> <img src="images/pic-5.jpg" class="img-responsive" alt=""><span class="zoom-icon"></span> </a>

		                </div>
					</div>	
					<div class="portfolio card mix_all  wow bounceIn" data-wow-delay="0.4s" data-cat="card" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper grid_box">		
							 <a href="images/pic-6.jpg" class="swipebox"  title="Image Title"> <img src="images/pic-6.jpg" class="img-responsive" alt=""><span class="zoom-icon"></span> </a>

		                </div>
					</div>	
					<div class="portfolio icon mix_all  wow bounceIn" data-wow-delay="0.4s" data-cat="icon" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper grid_box">		
							 <a href="images/pic-7.jpg" class="swipebox"  title="Image Title"> <img src="images/pic-7.jpg" class="img-responsive" alt=""><span class="zoom-icon"></span> </a>

		                </div>
						</div>
						<div class="portfolio logos mix_all wow bounceIn" data-wow-delay="0.4s" data-cat="logos" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper grid_box">		
							 <a href="images/pic-8.jpg" class="swipebox"  title="Image Title"> <img src="images/pic-8.jpg" class="img-responsive" alt=""><span class="zoom-icon"></span> </a>

		                </div>
					</div>
						<div class="portfolio logos mix_all wow bounceIn" data-wow-delay="0.4s" data-cat="logos" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper grid_box">		
							 <a href="images/pic-9.jpg" class="swipebox"  title="Image Title"> <img src="images/pic-9.jpg" class="img-responsive" alt=""><span class="zoom-icon"></span> </a>

		                </div>
					</div>
					<div class="portfolio app mix_all  wow bounceIn" data-wow-delay="0.4s" data-cat="app" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper grid_box">		
							 <a href="images/pic-10.jpg" class="swipebox"  title="Image Title"> <img src="images/pic-10.jpg" class="img-responsive" alt=""><span class="zoom-icon"></span> </a>

		                </div>
					</div>
					<div class="portfolio icon mix_all  wow bounceIn" data-wow-delay="0.4s" data-cat="icon" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper grid_box">		
							 <a href="images/pic-11.jpg" class="swipebox"  title="Image Title"> <img src="images/pic-11.jpg" class="img-responsive" alt=""><span class="zoom-icon"></span> </a>

		                </div>	
						</div>
					<div class="portfolio card mix_all  wow bounceIn" data-wow-delay="0.4s" data-cat="card" style="display: inline-block; opacity: 1;">
						<div class="portfolio-wrapper grid_box">		
							 <a href="images/pic-12.jpg" class="swipebox"  title="Image Title"> <img src="images/pic-12.jpg" class="img-responsive" alt=""><span class="zoom-icon"></span> </a>

		                </div>
					</div>					
<div class="clearfix"></div>					
				</div>			
<div class="clearfix"></div>	
			</div>

			</div>
		</div>
	</div>
	<jsp:include page="copyright.jsp"/>
</body>
</html>