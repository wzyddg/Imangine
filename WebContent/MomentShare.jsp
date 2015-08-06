<%@page import="dbMatter.DBQuerrier"%>
<%@page import="imangine.Pictures"%>
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
		
		List<Pictures> pics = DBQuerrier.getMomentSharePicsWithIndex(pageInt);

		for (int i = 0; i < pics.size(); i++) {
			Pictures tmp = pics.get(i);
	%>

	<div class="col-md-3 project">
		<a href="single.jsp?id=<%=tmp.getPicId()%>" class="thumbnail"><img
			src='<%=tmp.getAddress()%>' alt="" /></a>
		<div class="hov">
			<img class="likeit pull-right" id='l<%=16*indexInt+i*2+1 %>' onclick="change1(<%=16*indexInt+i*2+1 %>,<%=tmp.getPicId()%>)"
				style="display: inline;" src="images/hollowheart.png" /> <img
				class="likeit pull-right" id="l<%=16*indexInt+i*2+2 %>" onclick="change1(<%=16*indexInt+i*2+2 %>,<%=tmp.getPicId()%>)"
				style="display: none;" src="images/fullheart.png" />
		</div>
		<a href="single.jsp?id=<%=tmp.getPicId()%>"><div class="text">
				<div><%=tmp.getTitle()%></div>
			</div></a>
	</div>


	<%
		if (i == 3) {
				out.print("</div>  <div class=\"row\">");
			}
		}
	%>

</div>