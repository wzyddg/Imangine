<%@page import="imangine.database.entity.Picture"%>
<%@page import="imangine.database.entity.User"%>

<%@page import="imangine.database.dao.DataAccessObject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 一个share是两行 -->

<div class="row">
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

		List<Picture> pics = DataAccessObject
				.getHotSharePicsWithIndex(pageInt);

		for (int i = 0; i < pics.size(); i++) {
			Picture tmp = pics.get(i);
	%>
	<div class="col-md-3 project">
		<a href="picture_detail.jsp?id=<%=tmp.getPictureId()%>" class="thumbnail"><img
			src='<%=tmp.getPath()%>' alt="" /></a>
		<div class="hov">
			<img class="likeit pull-right" id='l<%=16 * indexInt + i * 2 + 1%>'
				onclick="change(<%=16 * indexInt + i * 2 + 1%>,<%=tmp.getPictureId()%>)"
				style="display: inline;" src="images/hollowheart.png" /> <img
				class="likeit pull-right" id="l<%=16 * indexInt + i * 2 + 2%>"
				onclick="change(<%=16 * indexInt + i * 2 + 2%>,<%=tmp.getPictureId()%>)"
				style="display: none;" src="images/fullheart.png" />
		</div>
		<a href="picture_detail.jsp?id=<%=tmp.getPictureId()%>"><div class="text">
				<div>
					<%=tmp.getTitle()%>
				</div>
			</div></a>
	</div>

	<%
		if (i == 3) {
				out.print("</div>  <div class=\"row\">");
			}
		}
	%>

</div>




