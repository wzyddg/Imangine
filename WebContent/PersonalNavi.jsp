<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="col-md-2">
	<ul id="main-nav" class="main-nav nav nav-tabs nav-stacked" style="">
		<li class="main-nav-a"><a href="personal.jsp"> <i
				class="glyphicon glyphicon-th-large"></i> 个人信息
		</a></li>
		<li class="main-nav-a"><a href="#systemSetting"
			class="nav-header collapsed" data-toggle="collapse"> <i
				class="glyphicon glyphicon-cog"></i> 修改信息 <span
				class="pull-right glyphicon glyphicon-chevron-toggle"></span>
		</a>
			<ul id="systemSetting" class="nav nav-list secondmenu collapse"
				style="height: 0px;">
				<li><a href="personal-modify.jsp"><i
						class="glyphicon glyphicon-user"></i>&nbsp;修改基本信息</a></li>
			</ul></li>
		<li class="main-nav-a"><a href="#configSetting"
			class="nav-header collapsed" data-toggle="collapse"> <i
				class="glyphicon glyphicon-credit-card"></i> 我的收藏 <span
				class="pull-right glyphicon  glyphicon-chevron-toggle"></span>
		</a>
			<ul id="configSetting" class="nav nav-list secondmenu collapse in">
				<li class="active"><a href="favPic.jsp"><i
						class="glyphicon glyphicon-globe"></i>&nbsp;图片收藏</a></li>
				<li><a href="album-fav.jsp"><i class="glyphicon glyphicon-star-empty"></i>&nbsp;专辑收藏</a></li>
				<li><a href="album-my.jsp"><i class="glyphicon glyphicon-star"></i>&nbsp;我的专辑</a></li>
			</ul></li>

		<li class="main-nav-a"><a href="#disSetting"
			class="nav-header collapsed" data-toggle="collapse"> <i
				class="glyphicon glyphicon-globe"></i> 好友圈 <span
				class="pull-right glyphicon glyphicon-chevron-toggle"></span>
		</a>
			<ul id="disSetting" class="nav nav-list secondmenu collapse">
				<li><a href="group-fav.jsp"><i class="glyphicon glyphicon-th-list"></i>&nbsp;加入的小组</a></li>
				<li><a href="group-my.jsp"><i class="glyphicon glyphicon-th-list"></i>&nbsp;建立的小组</a></li>
			</ul></li>
	</ul>
</div>