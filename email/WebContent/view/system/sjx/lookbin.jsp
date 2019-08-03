<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta charset="UTF-8">
<title>回收站邮件详细信息</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-pencil-square-o"></span> 发件人:<font color="red">${email.send_login_name}</font></strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="<%=basePath%>SJXController?methodName=replyUI">
				<input type="hidden" name="email_id" value="${email.email_id }"/>
				<div class="form-group">
					<div class="label">
						<label>标题：</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="stitle" value="${email.email_theme}" readonly="readonly"/>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>正文：</label>
					</div>
					<div class="field">
						<textarea name="scopyright" class="input" style="height: 120px;" readonly="readonly">${email.email_text}</textarea>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					
				</div>
			</form>
		</div>
	</div>
</body>
</html>