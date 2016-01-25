<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>picSharing</title>
    <link href="css/font.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<!--webfont-->
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

    function change(n){
        if(n%2==1){
            document.getElementById('l'+(n+1)).style.display="inline";
            document.getElementById('l'+n).style.display="none";
        }
        if(n%2==0){
            document.getElementById('l'+n).style.display="none";
            document.getElementById('l'+(n-1)).style.display="inline";
        }
    }

    </script>
    <style>
        .thumbnail {
            max-height:210px;
            min-height:200px;
            overflow:hidden;
            bottom:0;
            margin:0;
            padding: 0;
        }
    </style>

</head>
<body>
	<!-- header-section-starts -->
	<!--<div class="header" id="header">-->
		<!--<div class="container">-->
			<!--<div class="logo">-->
				<!--<a href="index.html"><img src="images/imangine.png" alt="" /></a>-->

			<!--</div>-->
			<!--<div class="clearfix"></div>-->
		<!--</div>-->
	<!--</div>-->
	<!--<div class="header-bottom">-->
		<!--<div class="container">-->
		<!--</div>-->
	<!--</div>-->
	<jsp:include page="header_picture_block.jsp" />
	<div class="content">
		<div class="container">
			<div class="projects-section">
				<h4 class="head"><a href="hot_picture_recommendation.jsp">Hot Pictures</a><span class="line"></span></h4>
				<div class="latest-projects">
                    <jsp:include page="hot_picture_recommendation_block.jsp" flush="true"><jsp:param
							name="page" value="0" /><jsp:param
							name="index" value="0" /></jsp:include>
					<div class="clearfix"></div>
				</div>


				<h4 class="head"><a href="latest_picture_recommendation.jsp">Recent Pictures</a><span class="line"></span></h4><!-- 朋友圈 -->
				<div class="latest-projects">
                    <jsp:include page="hot_picture_recommendation_block.jsp" flush="true"><jsp:param
							name="page" value="1" /><jsp:param
							name="index" value="1" /></jsp:include>
					<div class="clearfix"></div>
				</div>

				<h4 class="head"><a href="preferred_picture_recommendation.jsp">Pciture Discovery</a><span class="line"></span></h4>
				<div class="latest-projects">
                    <jsp:include page="hot_picture_recommendation_block.jsp" flush="true"><jsp:param
							name="page" value="2" /><jsp:param
							name="index" value="2" /></jsp:include>
					<div class="clearfix"></div>
				</div>
			</div>
			
				<!---/start-text-slider-->
				<div class="testimonials">
		
		</div>
		</div>
	</div>
	<jsp:include page="footer_block.jsp" />
	
</body>
</html>