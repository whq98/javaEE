<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>网站信息</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-pencil-square-o"></span> 用户信息</strong>
		</div>
		<div class="body-content">
			<!-- <form method="post" class="form-x" action=""> -->
				<div class="form-group">
					<div class="label">
						<label>当前用户:</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="stitle"
							value="${USER.name }" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>登陆名：</label>
					</div>
					<div class="field">
						<input type="text" id="url1" name="slogo" class="input tips"
							style="width: 25%; float: left;" value="${USER.login_name }"
							data-toggle="hover" data-place="right" data-image="images/y.jpg" /> 
					</div>
					<!-- <button class="button bg-main icon-check-square-o" >
							确定</button> -->
				</div>

			<!-- </form> -->
		</div>
	</div>
</body>
</html>