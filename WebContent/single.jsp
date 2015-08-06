<%@page import="imangine.Users"%>
<%@page import="imangine.AlbumIncluded"%>
<%@page import="imangine.PicLiked"%>
<%@page import="imangine.PicTag"%>
<%@page import="imangine.PicComment"%>
<%@page import="java.util.List"%>
<%@page import="dbMatter.DBQuerrier"%>
<%@page import="imangine.Pictures"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%String picIdString = request.getParameter("id"); 
	String prePage = request.getRequestURI();
	prePage = prePage.split("/")[2];
	//System.out.print(prePage);
				Integer picId=null;
					try{
						picId = Integer.parseInt(picIdString);
					}catch (Exception e){
						%>
						<jsp:forward page='404.jsp'/>
						<%
					}
					Pictures pic = DBQuerrier.getPicWithPicId(picId);
					if(pic==null){
						%><jsp:forward page='404.jsp'/><%
					}
				%>
<title>Picture:<%=pic.getTitle() %></title>
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

        function change(n){
            if(n==1){
                document.getElementById('l2').style.display="inline";
                document.getElementById('l1').style.display="none";
                $.post("Like",{like:"1"+"##pic##"+<%=picId %>});
            }
            if(n==2){
                document.getElementById('l1').style.display="inline";
                document.getElementById('l2').style.display="none";
                $.post("Like",{like:"2"+"##pic##"+<%=picId %>});
            }
        }
	</script>
	<style>
        .text-top{
            text-align: center;
        }
        .leave input[type="submit"]{
            border:none;
            color: #fff;
            font-size:1.4em;
            width: 48%;
            margin: 3em 1em 0;
            padding:0.3em;
            background:none;
            transition: 0.5s all;
            -webkit-transition: 0.5s all;
            -moz-transition: 0.5s all;
            -o-transition: 0.5s all;
            font-weight:700;
            background:#362f2f;
        }
        .unsign {
            font-weight: 500;
            font-size: 30px;
            background-color: #ff5656;
            margin:30px;
            color:#fff;
        }
    </style>

</head>
<body>
	<!-- header-section-starts -->
	
	
<div class="header" id="header">
		<jsp:include page="UserInfoBar.jsp"/>
	</div>
<div class="header-bottom">
    <div class="container"></div>
</div>
<jsp:include page="NaviBar.jsp"/>

<% Users user = (Users) session.getAttribute("userLoginStatus"); %>

	<div class="content">
		<div class="container">
			<div class="single">				
				<!-- head-section -->
				<div class="head-section text-center">
						<h2><%=pic.getTitle() %></h2>
				<%if(user!=null) {%>
                        <img class="likeit" id="l1" onclick="change(1)"  style="display:inline;" src="images/hollowheart.png"/>
                        <img class="likeit" id="l2" onclick="change(2)"  style="display:none;" src="images/fullheart.png"/>
				<%} %>
				</div>
				<div class="cod-md-12">	
				<div class="single-top">
					<img  src='<%=pic.getAddress() %>' alt=""/>
				</div>
			</div>
				<div class="top-single">
				<h2><%=pic.getDescription() %></h2>
					<div class="grid-single">
						<div class="single-one"><span><i> </i><%=pic.getPostDate().toString() %> </div></li>
						
						<%
						List<PicComment> picComments=DBQuerrier.getPicCommentsWithPicId(picId);
						List<PicTag> picTags=DBQuerrier.getPicTagsWithPicId(picId);
						List<PicLiked> picLikeds=DBQuerrier.getPicLikeUserIdsWithPicId(picId);
						List<AlbumIncluded> picAlbum=DBQuerrier.getAlbumsWithPicId(picId);
						%>
						<div class="single-one"><span><a href="#"><i class="com"> </i><%=picComments.size() %></a></span></div>
						<div class="single-one"><span><i class="four"> </i><%=picLikeds.size() %></span></div>
						<div class="clearfix"> </div>
					</div>

			<div class="single-middle">
				<div class="postor-info">
                    <div class=" col-md-2 postor-port">
                        <a href="blog.jsp"><img src='<%=pic.getUsers().getDoll() %>' alt="" />
                        </a>
                    </div>
                    <div class="col-md-5 postor-info-i">
                        <span><%=pic.getUsers().getUserName() %></span>
                    </div>
                    <div class="col-md-5 postor-info-i">
                        <%=pic.getUsers().getDiscription() %>
                    </div>
				</div>
				<br/><br/><br/>
				
                <div class="who-liked">
                    <img  src="images/fullheart.png" alt=""/>
                    
                    <%for(int i=0;i<picLikeds.size();i++){%>
                	
                		<img  src='<%=picLikeds.get(i).getUsers().getDoll() %>' alt=""/>
                		
                	<% } %>
                	
                </div>
                <div class="collected-album ">                
                    <img  src="images/album.png" alt=""/>
                    
               		<%for(int i=0;i<picAlbum.size();i++){
               			//album需要添加封面，替换下面
               			%>
               			<img  src='<%=picAlbum.get(i).getAlbums().getCoverAdderss() %>' alt=""/>
               			<%
               		} %>
               <!--      <img  src="images/cover1.jpg" alt=""/>
                    <img  src="images/cover2.jpg" alt=""/>
                    <img  src="images/cover3.jpg" alt=""/>
                    <img  src="images/cover4.jpg" alt=""/>
                    <img  src="images/cover5.jpg" alt=""/>--> 

                </div>
                <div class="clearfix"> </div>
                <div class="pic-tags">
                	<%for(int i=0;i<picTags.size();i++){%>
                	
                		<a><%=picTags.get(i).getId().getTag() %></a><span> </span>
                		
                	<% } %>
                    
                </div>
                <div class="clearfix"> </div>
			</div>
			<div class="top-comments">
			<h3>Comments</h3>
			
			<%for(int i=0;i<picComments.size();i++){ 
				PicComment picComment=picComments.get(i);%>
			<div class="met">
				<div class="code-in">
					<p class="smith"><a href="#"><%=picComment.getUsers().getUserName() %></a> <span><%=picComment.getCommentDate().toString() %></span></p>
					<div class="clearfix"> </div>
				</div>
				<div class="comments-top-top">
					<div class="men" >
						<img  src='<%=picComment.getUsers().getDoll() %>' alt="">
					</div>					
						<p class="men-it"><%=picComment.getContent() %></p>
					<div class="clearfix"> </div>
				</div>
			</div>
			<%} %>
		</div>
		<div class="leave">
		<h3>Leave a comment</h3>
		<%
		//	System.out.println(request.getRequestURI());
		//	System.out.println(request.getRequestURL());
		//	System.out.println(session.getAttribute("PicComStatus")+"目前的状态  user:"+user);
			session.setAttribute("prePage", prePage+"?id="+picId);
		if(user!=null) {
			if(session.getAttribute("PicComStatus")==null);
			else if(((Integer)session.getAttribute("PicComStatus")).equals(new Integer(0))){
//				System.out.println(session.getAttribute("PicComStatus") + "这个要什么都不显示的");
			}
			else if((Integer)session.getAttribute("PicComStatus")==1){
		//			System.out.println(session.getAttribute("PicComStatus") + "这个要显示成功的");
			%>
			<font color="#00FF00">评论成功！</font> <%
				}else{
					System.out.println(session.getAttribute("PicComStatus") + "这个要显示失败的");
			%><font color="#FF0000">评论不能为空！</font><%} 
			session.setAttribute("PicComStatus", 0);
			 %>
				<form action="SendPicComment?picId=<%=pic.getPicId() %>" method="post">
					<div class="col-md-1">
                        <div class="leave-info">
                            <div class="leave-port">
                                <img  src='<%=user.getDoll() %>' alt="">
                            </div>
                            <div>
                                <span><%=user.getUserName() %></span>
                            </div>
                        </div>
					</div>
					<div class="text-top">
						<div class="col-md-8 text-in">
							<textarea  name="comCon" placeholder="Comment"></textarea>
						</div>
						<div class="col-md-3 text-in">
							<input type="submit" value="SEND" >
						</div>
						<div class="clearfix"> </div>
					</div>
				</form>
		<%}else{ %>
				<div>
					<div class="text-top">
						<div class="col-md-6 text-in">
							<a href="login.jsp"><div class="unsign">Login</div></a>
						</div>
                        <div class="col-md-6 text-in">
                            <a href="register.jsp"><div class="unsign">Register</div></a>
                        </div>
						<div class="clearfix"> </div>
					</div>
				</div>

		<%}
		 %>
		</div>
			</div>			
		</div>
		</div>
	</div>
	<jsp:include page="copyright.jsp"/>
</body>
</html>