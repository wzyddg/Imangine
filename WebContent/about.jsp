<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>About</title>
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
    <style>
        .slideing{
            background: url(images/about-us.jpg) no-repeat 0px 0px;
            background-size: cover;
            min-height:700px;
        }
        .logo {
            float:left;
            background: rgba(158,74,52,1);
            padding: 2em 1.5em;
        }
        .top-nav ul li {
            display: inline-block;
            margin: 0 .5em;
            outline: none;
            text-decoration: none;
            text-transform: uppercase;
            letter-spacing: 1px;
            font-weight: 400;
            font-size: 16px;
            float:right;
            background-color:rgba(220,150,187,0.5);
        }
        .head-info h1{
            font-size: 50px;
            font-weight: 700;
            color: #7c306d;
            font-family: 'Courier New', cursive;
            margin: 0;
            letter-spacing: 3px;
        }
        .head-info span{
            color:#e8ba02;
            display: block;
            font-weight: 200;
            text-transform: lowercase;
        }
        .head-info p{
            color: #ffffff;
            font-size: 16px;
            margin: 1em 0 0 0;
            letter-spacing: 2px;
        }
    </style>
</head>
<body>
	<!-- header-section-starts -->
	<div class="header" id="header">
		<jsp:include page="UserInfoBar.jsp"/>
	</div>

    <div class="slideing">
        <div class="head-bg">
            <!-- container -->
            <div class="container">
                <!--<div class="head-logo">-->
                <!--<a href="index.jsp"><img src="images/logo.png" alt="" /></a>-->
                <!--</div>-->
                <div class="top-nav">
                    <ul class="cl-effect-1">
                        <li><a href="about.jsp">About Us</a></li>
                        <!--<li><a href="contact.jsp">Contact</a></li>-->
                        <li><a href="album.jsp">Album</a></li>
                        <li><a href="group.jsp">Group</a></li>
                        <li><a href="portfolio.jsp">Portfolio</a></li>
                        <li><a href="blog.jsp">Personal</a></li>
                        <li><a href="pic.jsp">Sharing</a></li>

                        <!--<div class="clearfix"></div>-->
                    </ul>
                    <!-- script-for-menu -->
                    <script>
                        $( "span.menu" ).click(function() {
                            $( "ul.cl-effect-1" ).slideToggle( 300, function() {
                                // Animation complete.
                            });
                        });
                    </script>
                    <!-- /script-for-menu -->
                </div>
                <div class="clearfix"> </div>
            </div>
            <!-- //container -->
        </div>
        <!-- container -->
        <div class="container">
            <!-- banner Slider starts Here -->
            <script src="js/responsiveslides.min.js"></script>
            <script>
                // You can also use "$(window).load(function() {"
                $(function () {
                    // Slideshow 4
                    $("#slider3").responsiveSlides({
                        auto: true,
                        pager: false,
                        nav: false,
                        speed: 500,
                        namespace: "callbacks",
                        before: function () {
                            $('.events').append("<li>before event fired.</li>");
                        },
                        after: function () {
                            $('.events').append("<li>after event fired.</li>");
                        }
                    });

                });


            </script>
            <!--//End-slider-script -->
            <div  id="top" class="callbacks_container">
                <ul class="rslides" id="slider3">
                    <li>
                        <div class="head-info">
                            <h1>Perfect<span>What we will always chase</span></h1>
                            <p>Investing the resources and caring enough to try.</p>
                        </div>
                    </li>
                    <li>
                        <div class="head-info">
                            <h1>Design<span>Soul of a human-made creation</span></h1>
                            <p>Nothing could be further from the meaning of design. </p>
                        </div>
                    </li>
                    <li>
                        <div class="head-info">
                            <h1>Excellent<span>The way we live</span></h1>
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
	<div class="about-content">
			<!-- about-us -->
			<div id="about" class="about-us text-center">
				<!-- head-section -->
					<div class="head-section text-center">
						<h2>About us</h2>
						<span> </span>
					</div>
					<!-- /head-section -->
					<p>Thanks for your supporting. We will try our best to chase the perfect.</p>
					<!-- about-grids -->
					<div class="about-grids">
                        <div class="row">
						<div class="col-md-4 about-grid text-center">
							<div class="about-grid-info">

								<h4>Shepard</h4>
								<span>JSP/JAVA/SSH</span>

							</div>
							<div class="about-grid-caption">
								<h5>Contact Us !</h5>
                                <a href="contact.jsp"><span> </span></a>
							</div>
						</div>
						<div class="col-md-4 about-grid text-center">
							<div class="about-grid-info">

								<h4>Gretchen</h4>
								<span>UI/JS/HTML/CSS</span>

							</div>
							<div class="about-grid-caption">
								<h5>Contact Us !</h5>
								<a href="contact.jsp"><span> </span></a>
							</div>
						</div>
						<div class="col-md-4 about-grid text-center">
							<div class="about-grid-info">
								<h4>Johnson</h4>
								<span>DBA/SQL/HQL</span>

							</div>
							<div class="about-grid-caption">
								<h5>Contact Us !</h5>
								<a href="contact.jsp"><span> </span></a>
							</div>
						</div>
                        </div>



						<div class="clearfix"> </div>
					</div>
					<!-- about-grids -->				
			</div>
			<!--<div class="about-middle-grids">-->
				<!--<div class="col-md-4 about-middle-grid">-->
					<!--<h3>our advantages</h3>-->
					<!--<img src="images/about-picx.jpg" alt="" />-->
					<!--<h5>Verasleras lasere tisesra serta</h5>-->
					<!--<p>Meciegast nveritekytars lertyasu aysety kertya asetabo serde fae kertydemo eniptes ades. Bolernatur aut oditaut. onsequuntur magni dolores eo qui ratione.</p>-->
					<!--<a href="single.jsp" class="btn-default btn2">more</a>-->
				<!--</div>-->
				<!--<div class="col-md-4 about-middle-grid">-->
					<!--<h3>Our Links</h3>-->
					<!--<h5>Aloecase magna umsan hausyes maleasit onuris fermen:</h5>-->
					<!--<ul>-->
						<!--<li><a href="#">Giegast nveriaruayse</a></li>-->
						<!--<li><a href="#">Beker tyudera</a></li>-->
						<!--<li><a href="#">Snemo eniptaiade</a></li>-->
						<!--<li><a href="#">Volernatur aut outsequ</a></li>-->
						<!--<li><a href="#">Magni doloatione</a></li>-->
						<!--<li><a href="#">Voluptate</a></li>-->
						<!--<li><a href="#">Asequi nesciunt</a></li>-->
					<!--</ul>-->
					<!--<a href="single.jsp" class="btn-default btn2">more</a>-->
				<!--</div>-->
				<!--<div class="col-md-4 about-middle-grid">-->
					<!--<h3>Primary Contacts</h3>-->
					<!--<h4>28 Jackson Blvd Ste 1020</h4>-->
					<!--<h4>Chicago</h4>-->
					<!--<h4>IL 60604-2340</h4>-->
					<!--<div class="follow-us">-->
						<!--<h3>Follow Us</h3>-->
						<!--<div class="social-icons1">-->
							<!--<a href="#"><i class="facebook1"></i></a>-->
							<!--<a href="#"><i class="twitter1"></i></a>-->
							<!--<a href="#"><i class="googlepluse1"></i></a>-->
							<!--<a href="#"><i class="pinterest1"></i></a>-->
						<!--</div>-->
					<!--</div>-->
				<!--</div>-->
				<!--<div class="clearfix"></div>-->
			<!--</div>-->
			<!--</div>-->
				<!---/start-text-slider----->
				<!--<div class="testimonials">-->
			<!--<h4>Testimonials</h4>-->
		<!--<div id="testimonials">-->
			 <!--<div class="wmuSlider example1">-->
		 	<!--<div class="container-flueid">-->
				 <!--<article style="position: absolute;"> -->
				   	<!--<div class=" cont span_2_of_3  client-main">-->
							<!--<div class="slide-text">-->
								<!--<p>Praesent pulvinar, est eget pharetra euismod, metus felis condimentum massa, ut vestibulum ipsum risus vel ligula. In hac habitasse platea dictumst.</p>-->
						  		<!--<a href="#">by Esmet Hajrizi</a>-->
								<!--<div class="clearfix"></div>								-->
						 	<!--</div> -->
					<!--</div>-->
				 <!--</article>-->
				 <!--<article style="position: absolute;"> -->
				   	<!--<div class=" cont span_2_of_3  client-main">-->
							<!--<div class="slide-text">-->
								<!--<p>Praesent pulvinar, est eget pharetra euismod, metus felis condimentum massa, ut vestibulum ipsum risus vel ligula. In hac habitasse platea dictumst.</p>-->
						  		<!--<a href="#">by Esmet Hajrizi</a>	-->
								<!--<div class="clearfix"></div>-->
						 	<!--</div> -->
					<!--</div>-->
				 <!--</article>-->
				 <!--<article style="position: absolute;"> -->
				   	<!--<div class=" cont span_2_of_3  client-main">-->
							<!--<div class="slide-text">-->
								<!--<p>Praesent pulvinar, est eget pharetra euismod, metus felis condimentum massa, ut vestibulum ipsum risus vel ligula. In hac habitasse platea dictumst.</p>-->
						  		<!--<a href="#">by Esmet Hajrizi</a>-->
								<!--<div class="clearfix"></div>-->
						 	<!--</div> -->
					<!--</div>-->
				 <!--</article>-->
				 <!--<article style="position: absolute;"> -->
				   	<!--<div class=" cont span_2_of_3  client-main">-->
							<!--<div class="slide-text">-->
								<!--<p>Praesent pulvinar, est eget pharetra euismod, metus felis condimentum massa, ut vestibulum ipsum risus vel ligula. In hac habitasse platea dictumst.</p>-->
						  		<!--<a href="#">by Esmet Hajrizi</a>-->
								<!--<div class="clearfix"></div>-->
						 	<!--</div> -->
					<!--</div>-->
				 <!--</article>	 -->
                  <!--<script src="js/jquery.wmuSlider.js"></script> -->
					<!--<script>-->
       				     <!--$('.example1').wmuSlider();         -->
   					<!--</script> 	-->
						<!--<div class="clearfix"></div>-->
	         <!--</div>-->
	     <!--</div>-->
		 <!--<div class="arrow">-->
			<!--<div class="shows">-->
				<!--<span class="a1"><img src="images/tes.png" alt="" /></span>-->
			<!--</div>-->
		 <!--</div>-->
	 <!--&lt;!&ndash;-//text-slider---&ndash;&gt;-->

			<!--</div>-->
		<!--</div>-->
		</div>
	</div>
	
	</div>
	<jsp:include page="copyright.jsp"/>
</body>
</html>