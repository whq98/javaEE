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
<meta charset="UTF-8">
<title>回复页面</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>回复邮件</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x"
				action="<%=basePath%>SendController?methodName=sendMail">
				<input type="hidden" name="sendUser_name"
					value="${USER.login_name}"> ${message}
				<div class="form-group">
					<div class="label">
						<label>收件人:</label>
					</div>
					<div class="field">
						<input type="text" class="input w50"
							value="${email.send_login_name }" name="rec_login_name"
							data-validate="required:请输入收件人id" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>主题:</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="" name="email_theme"
							data-validate="required:请写入主题" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>正文：</label>
					</div>
					<div class="field">
						<textarea name="email_text" class="input" style="height: 120px;"
							></textarea>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit">
							提交</button>
						<button class="button bg-main icon-check-square-o" type="reset">
							重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>