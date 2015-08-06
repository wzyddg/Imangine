<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
String getType(String pageName){
	
	if(	pageName.equals("/Imangine/sharing-hot.jsp")||
		pageName.equals("/Imangine/pic.jsp")||
		pageName.equals("/Imangine/picUpload.jsp")||
		pageName.equals("/Imangine/sharing-discov.jsp")||
		pageName.equals("/Imangine/sharing-moment.jsp")||
		pageName.equals("/Imangine/single-unsigned.jsp")||
		pageName.equals("/Imangine/single.jsp")
			)
		return "/Imangine/pic.jsp";
	
	if(	pageName.equals("/Imangine/favPic.jsp")||
			pageName.equals("/Imangine/blog.jsp")||
			pageName.equals("/Imangine/personal-modify.jsp")||
			pageName.equals("/Imangine/personal.jsp")
				)
			return "/Imangine/blog.jsp";
	
	if(	pageName.equals("/Imangine/portfolio.jsp")
				)
			return "/Imangine/portfolio.jsp";
	
	if(	pageName.equals("/Imangine/album-fav.jsp")||
			pageName.equals("/Imangine/album-my.jsp")||
			pageName.equals("/Imangine/album.jsp")||
			pageName.equals("/Imangine/single-album.jsp")
				)
			return "/Imangine/album.jsp";
	
	if(	pageName.equals("/Imangine/group.jsp")||
			pageName.equals("/Imangine/group-my.jsp")||
			pageName.equals("/Imangine/group-fav.jsp")||
			pageName.equals("/Imangine/single-group.jsp")
				)
			return "/Imangine/group.jsp";
	
	if(	pageName.equals("/Imangine/about.jsp")
			)
		return "/Imangine/about.jsp";
	
	return "";
}

String getActive(String url,String pageName){
	if(getType(url).equals("/Imangine/"+pageName))
		return "class=\"active\"";
	else
		return "";
}
%>
<div class="navigation-strip">
    <div class="container">
        <div class="nav_content">
            <div class="home">
                <a href="index.jsp"><img src="images/home1.png" alt="" /></a>
            </div>
            <!-- <div class="search">
                <form>
                    <input type="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search..';}"/>
                    <input type="submit" value="">
                </form>
            </div> -->
            <span class="menu"></span>
            <div class="top-menu">
                <ul>
                <%String urlString=request.getRequestURI(); 
          //      System.out.println(urlString);
                %>
                    <li><a  <%=getActive(urlString, "pic.jsp") %>  href="pic.jsp">Sharing</a></li>
                    <li><a  <%=getActive(urlString, "blog.jsp") %>  href="blog.jsp">Personal</a></li>
                    <li><a  <%=getActive(urlString, "portfolio.jsp") %>  href="portfolio.jsp">Portfolio</a></li>
                    <li><a  <%=getActive(urlString, "album.jsp") %>  href="album.jsp">Album</a></li>
                    <li><a  <%=getActive(urlString, "group.jsp") %>  href="group.jsp">Group</a></li>
                    <li><a  <%=getActive(urlString, "about.jsp") %>  href="about.jsp">About Us</a></li>
                    <div class="clearfix">
                    </div>
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
