<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="imangine.database.entity.AlbumIncluded"%>
<%@page import="imangine.database.entity.PictureComment"%>
<%@page import="imangine.database.entity.PictureLiked"%>
<%@page import="imangine.database.entity.PictureLikedId"%>
<%@page import="imangine.database.entity.PictureTag"%>
<%@page import="imangine.database.entity.PictureTagId"%>
<%@page import="imangine.database.entity.Picture"%>
<%@page import="imangine.database.entity.User"%>

<%@page import="imangine.database.dao.DataAccessObject"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<%
	String picIdString = request.getParameter("id"); 
	String prePage = request.getRequestURI();
	prePage = prePage.split("/")[2];
	//System.out.print(prePage);
		Integer picId=null;
	try{
		picId = Integer.parseInt(picIdString);
	}catch (Exception e){
%>
<jsp:forward page='404.jsp' />
<%
	}
	Picture pic = DataAccessObject.getPicWithPicId(picId);
	if(pic==null){
%><jsp:forward page='404.jsp' />
<%
	}
%>
<title>Picture:<%=pic.getTitle()%></title>
<link href="css/font.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Metushi Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
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
		$('#sharing').click(function() {
			$("#sharingModal").modal('toggle');
		});
	});

	function change(n) {
		if (n == 1) {
			document.getElementById('l2').style.display = "inline";
			document.getElementById('l1').style.display = "none";
			$.post("Like", {
				like : "1" + "##pic##" +
<%=picId%>
	});
		}
		if (n == 2) {
			document.getElementById('l1').style.display = "inline";
			document.getElementById('l2').style.display = "none";
			$.post("Like", {
				like : "2" + "##pic##" +
<%=picId%>
	});
		}
	}
</script>
<style>
.single-one {
	width: 25%;
}

.btn-shar:hover {
	background-color: #a37a8c !important;
	color: #ffffff !important;
}

.btn-c:hover {
	background-color: #ff0000 !important;
	color: #ffffff !important;
}
</style>
</head>
<body>
	<jsp:include page="header_picture_block.jsp" />
	<%
		User user = (User) session.getAttribute("userLoginStatus");
	%>
	<div class="content">
		<div class="container">
			<div class="single">
				<!-- head-section -->
				<div class="head-section text-center">
					<h2><%=pic.getTitle()%></h2>
					<img class="likeit" id="l1" onclick="change(1)"
						style="display: inline;" src="images/hollowheart.png" /> <img
						class="likeit" id="l2" onclick="change(2)" style="display: none;"
						src="images/fullheart.png" />
					<!--<span> </span>-->
				</div>
				<!-- /head-section -->
				<div class="single-top">
					<img src='<%=pic.getPath()%>' alt="" />
				</div>
				<div class="top-single">
					<h2><%=pic.getDescription()%></h2>
					<div class="pull-right">
						<a href="picture_modify.jsp">Modify Picture Info</a>
					</div>

					<%
						List<PictureComment> picComments = DataAccessObject
								.getPictureCommentsWithPicId(picId);
						List<PictureTag> picTags = DataAccessObject
								.getPictureTagsWithPicId(picId);
						List<PictureLiked> picLikeds = DataAccessObject
								.getPicLikeUserIdsWithPicId(picId);
						List<AlbumIncluded> picAlbum = DataAccessObject
								.getAlbumsWithPicId(picId);
					%>

					<div class="grid-single">
						<div class="single-one">
							<span><i> </i><%=pic.getUploadDate().toString()%>
						</div>
						<div class="single-one">
							<span><a href="#"><i class="com"> </i><%=picComments.size()%></a></span>
						</div>
						<div class="single-one">
							<span><i class="four"> </i><%=picLikeds.size()%></span>
						</div>
						<div class="single-one" id="sharing">
							<span><i class="fen"> </i>Sharing</span>
						</div>

						<div class="clearfix"></div>
					</div>

					<div class="single-middle">
						<div class="postor-info">
							<div class=" col-md-2 postor-port">
								<a href="personal.jsp?id=<%=pic.getUser().getUserId() %>"><img
									src='<%=pic.getUser().getAvatarPath()%>' alt="" /> </a>
							</div>
							<div class="col-md-5 postor-info-i">
								<span><%=pic.getUser().getUserName()%></span>
							</div>
							<div class="col-md-5 postor-info-i"><%=pic.getUser().getDescription()%></div>
						</div>


						<div class="who-liked">
							<img src="images/fullheart.png" alt="" />
							<%
								for (int i = 0; i < picLikeds.size(); i++) {
							%>

							<img src='<%=picLikeds.get(i).getUser().getAvatarPath()%>' alt="" />

							<%
								}
							%>
							<a href=""><label>View All</label></a>
						</div>
						<div class="collected-album ">
							<img src="images/album.png" alt="" />
							<%
								for (int i = 0; i < picAlbum.size(); i++) {
									//album需要添加封面，替换下面
							%>
							<img src='<%=picAlbum.get(i).getAlbum().getCoverPath()%>' alt="" />
							<%
								}
							%>
							<a href=""><label>View All</label></a>
						</div>
						<div class="clearfix"></div>
						<div class="pic-tags">
							<%
								for (int i = 0; i < picTags.size(); i++) {
							%>

							<a><%=picTags.get(i).getId().getTag()%></a><span> </span>

							<%
								}
							%>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="top-comments">
						<h3>Comments</h3>
						<%
							for (int i = 0; i < picComments.size(); i++) {
								PictureComment picComment = picComments.get(i);
						%>
						<div class="met">
							<div class="code-in">
								<p class="smith">
									<a href="#"><%=picComment.getUser().getUserName()%></a> <span><%=picComment.getCommentDate().toString()%></span>
								</p>
								<div class="clearfix"></div>
							</div>
							<div class="comments-top-top">
								<div class="men">
									<img src='<%=picComment.getUser().getAvatarPath()%>' alt="">
								</div>
								<p class="men-it"><%=picComment.getContent()%></p>
								<div class="clearfix"></div>
							</div>
						</div>
						<%
							}
						%>
					</div>
					<div class="leave">
						<h3>Leave a comment</h3>
						<%
							session.setAttribute("prePage", prePage + "?id=" + picId);
							if (session.getAttribute("PicComStatus") == null)
								;
							else if (((Integer) session.getAttribute("PicComStatus"))
									.equals(new Integer(0))) {
								//				System.out.println(session.getAttribute("PicComStatus") + "这个要什么都不显示的");
							} else if ((Integer) session.getAttribute("PicComStatus") == 1) {
								//			System.out.println(session.getAttribute("PicComStatus") + "这个要显示成功的");
						%>
						<font color="#00FF00">评论成功！</font>
						<%
							} else {
								System.out.println(session.getAttribute("PicComStatus")
										+ "这个要显示失败的");
						%><font color="#FF0000">评论不能为空！</font>
						<%
							}
							session.setAttribute("PicComStatus", 0);
						%>
						<form action="SendPictureComment?picId=<%=pic.getPictureId() %>" method="post">
							<div class="col-md-1">
								<div class="leave-info">
									<div class="leave-port">
										<img src='<%=user.getAvatarPath()%>' alt="">
									</div>
									<div>
										<span><%=user.getUserName() %></span>
									</div>
								</div>
							</div>
							<div class="text-top">
								<div class="col-md-8 text-in">
									<textarea name="comCon" placeholder="Comment"></textarea>
								</div>
								<div class="col-md-3 text-in">
									<input type="submit" value="SEND">
								</div>
								<div class="clearfix"></div>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer_block.jsp" />
	<!-- Modal -->
	<div class="modal fade" id="sharingModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Sharing</h4>
				</div>
				<div class="modal-body">
					<button type="button" class="btn-shar btn btn-default "
						data-dismiss="modal">Wechat</button>
					<button type="button" class="btn-shar btn btn-default "
						data-dismiss="modal">QQ</button>
					<button type="button" class="btn-shar btn btn-default "
						data-dismiss="modal">Weibo</button>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn-c btn btn-default "
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
</body>
</html>

