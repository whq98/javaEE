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
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>修改草稿内容</strong>
		</div>
		<form method="post" class="form-x"
			action="<%=basePath%>cgxController?methodName=update&cgx_id=${ec.cgx_id}">
			<input type="hidden" name="sendUser_id" value="${USER.user_id}">
			${message}
			<div class="body-content">
				<div class="form-group">
					<label>简述:</label>
				</div>
				<div class="field">
					<input type="text" class="input w50" value="${ec.base }"
						name="base" data-validate="required:请写入主题" />
					<div class="tips"></div>
				</div>
			</div>
			<div class="body-content">
				<div class="form-group">
					<label>正文:</label>
				</div>
				<div class="field">
					<input type="text" class="input w50" value="${ec.cgx_text }"
						name="cgx_text" data-validate="required:请输入正文" />
					<div class="tips"></div>
				</div>
			</div>


			<div class="form-group">
				<div class="field">
					<button class="button bg-main icon-check-square-o" type="submit"
						>保存修改</button>
					${msg} <a  href="<%=basePath%>cgxController?methodName=pagelist" class="button bg-main">返回</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>