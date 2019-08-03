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
<body style="background-color: #f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="images/y.jpg" class="radius-circle rotate-hover"
					height="50" alt="" />简易邮件管理系统
			</h1>
		</div>
		<div class="head-l">
			<a class="button button-little bg-green" href="" target="_blank"><span
				class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;<a href="##"
				class="button button-little bg-blue"><span class="icon-wrench"></span>
				清除缓存</a> &nbsp;&nbsp;<a class="button button-little bg-red"
				href="login.jsp"><span class="icon-power-off"></span> 退出登录</a>
		</div>
	</div>
	<div class="leftnav">
		<div class="leftnav-title">
			<strong><span class="icon-list"></span>菜单列表</strong>
		</div>
		<h2>
			<span class="icon-user"></span>基本设置
		</h2>
		<ul style="display: block">
			<li><a href="<%=basePath%>SendController?methodName=sendMailUI"
				target="right"><span class="icon-caret-right"></span>写信</a></li>
			<li><a
				href="<%=basePath%>SendController?methodName=qfUI&user_name=${USER.login_name}"
				target="right"><span class="icon-caret-right"></span>群发邮件</a></li>
			<li><a
				href="<%=basePath%>SJXController?methodName=getEmail&user_name=${USER.login_name}"
				target="right" target="right"><span class="icon-caret-right"></span>收件箱</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>邮件管理
		</h2>
		<ul>
			<li><a
				href="<%=basePath%>SendController?methodName=OutBox&login_name=${USER.login_name}"
				target="right"><span class="icon-caret-right"></span>已发送</a></li>
			<li><a
				href="<%=basePath%>SendController?methodName=queryDeletedMail&user_name=${USER.login_name}"
				target="right"><span class="icon-caret-right"></span>发件箱回收站</a></li>
			<li><a
				href="<%=basePath%>SJXController?methodName=getBinEmail&user_name=${USER.login_name}"
				target="right"><span class="icon-caret-right"></span>收件箱回收站</a></li>
			<li><a href="<%=basePath%>CGXController?methodName=pagelist" target="right"><span
					class="icon-caret-right"></span>草稿箱</a></li>
			<!-- <li><a href="#" target="right"><span
					class="icon-caret-right"></span>垃圾箱</a></li> -->
		</ul>
	</div>
	<script type="text/javascript">
		$(function() {
			$(".leftnav h2").click(function() {
				$(this).next().slideToggle(200);
				$(this).toggleClass("on");
			})
			$(".leftnav ul li a").click(function() {
				$("#a_leader_txt").text($(this).text());
				$(".leftnav ul li a").removeClass("on");
				$(this).addClass("on");
			})
		});
	</script>
	<ul class="bread">
		<li><a href="{:U('Index/info')}" target="right" class="icon-home">
				首页</a></li>
		<li><a href="##" id="a_leader_txt">网站信息</a></li>
		<li><b>当前语言：</b><span style="color: red;">中文</php></span>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a
			href="##">英文</a></li>
	</ul>
	<div class="admin">
		<iframe scrolling="auto" rameborder="0" src="view/main/info.jsp"
			name="right" width="100%" height="100%"></iframe>
	</div>
	<div style="text-align: center;"></div>
</body>
</html>