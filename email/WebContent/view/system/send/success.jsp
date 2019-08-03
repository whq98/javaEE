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
<title>发送成功页面</title>
</head>
<body>
<div>
<center>${message }</center>
<a href="view/system/send/send.jsp" class="button button-little bg-blue">继续发送</a>
<a href="view/main/info.jsp" class="button button-little bg-blue">点击返回主页面</a>
</div>
</body>
</html>