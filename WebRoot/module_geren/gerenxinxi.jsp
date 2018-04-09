<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>无标题文档</title>
	<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="place">
	<span>位置：</span>
	<ul class="placeul">
		<li><a href="#">个人中心</a></li>
		<li><a href="#">基本信息维护</a></li>
	</ul>
</div>

<form action="UpdateAdmin" method="post">
	<div class="formbody">
		<div class="formtitle"><span>基本信息</span></div>
		<ul class="forminfo">
			<li>
				<label>用户名</label>
				<input readonly="readonly" name="account" value="${map.account}" type="text" class="dfinput"/>
				<i>名称不能修改</i>
			</li>
			
			<li>
				<label>电话</label>
				<input name="phonenum" type="text" class="dfinput" value="${map.phonenum}"/>
				<i></i>
			</li>
			<li>
				<label>地址</label>
				<input name="address" type="text" class="dfinput" value="${map.address}"/>
				<i></i>
			</li>
			<li>
				<label>邮箱</label>
				<input name="mailbox" type="text" class="dfinput" value="${map.mailbox}"/>
				<i></i>
			</li>
			
			
			<li>
				<label>&nbsp;</label>
				<input name="" type="submit" class="btn" value="确认修改"/>
			</li>
		</ul>
	</div>
</form>

<script src="<%=basePath %>js/upload.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jQuery/jquery.js"></script>
</body>
</html>
	