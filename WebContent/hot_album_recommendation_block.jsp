<%@page import="imangine.database.entity.Album"%>
<%@page import="imangine.database.entity.User"%>

<%@page import="imangine.database.dao.DataAccessObject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 一个block是两行 -->

<%
	String pageString = request.getParameter("page");
	int pageInt = 0;
	try {
		pageInt = Integer.parseInt(pageString);
	} catch (Exception e) {

	}

	String indexString = request.getParameter("index");
	int indexInt = 0;
	try {
		indexInt = Integer.parseInt(indexString);
	} catch (Exception e) {

	}

	List<Album> albums = DataAccessObject
			.getHotAlbumsWithIndex(indexInt);

	for (int i = 0; i < albums.size(); i++) {
		Album tmp = albums.get(i);
		if (i == 0 || i == 3) {
%>
<div class="col-md-4 blog-posts">
	<%
		}
			if (i == 6) {
	%>
	<div class="col-md-4 blog-posts span_66">
		<%
			}
		%>
		<div class="blog-post">
			<a class="thumbnail" href='album_detail.jsp?id=<%=tmp.getAlbumId()%>'><img
				src='<%=tmp.getCoverPath()%>'></a> <a
				href='album_detail.jsp?id=<%=tmp.getAlbumId()%>' class="blog-title"><%=tmp.getTheme()%></a>
			<p class="sub_head">
				Set by <a href="personal.jsp?id=<%=tmp.getUser().getUserId()%>"><%=tmp.getUser().getUserName()%></a>
				on 12/04/2014
			</p>
			<span></span>
		</div>
		<%
			if (i % 3 == 2) {
					out.print("</div>");
				}
			}
		%>
		<div class="clearfix"></div>