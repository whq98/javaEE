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
<title>Insert title here</title>
</head>
<body>
<input type="hidden" name="rec_login_name" value="${email.rec_login_name }">
<input type="hidden" name="sendUser_name" value="${email.sendUser_name }">
<input type="hidden" name="email_theme" value="${email.email_theme }">
<input type="hidden" name="email_text" value="${email.email_text }">
</body>
</html>