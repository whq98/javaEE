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
<title>收件箱回收站</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
	<form method="post"
		action="<%=basePath%>SJXController?methodName=deepDeletes"
		onsubmit="return DelSelect()">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 收件垃圾箱</strong> <font color="red">${message}</font>
			</div>
			<div class="padding border-bottom">
				<ul class="search">
					<li>
						<button type="button" class="button border-green" id="checkall">
							<span class="icon-check"></span> 全选
						</button>
						<button type="submit" class="button border-red">
							<span class="icon-trash-o"></span> 批量删除
						</button>
						
					</li>
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th></th>
					<th>发件人</th>
					<th>主题</th>
					<th>正文</th>
					<th>发件时间</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${emailList}" var="email">
					<tr>
						<td><a
							href="<%=basePath%>SJXController?methodName=lookbin&email_id=${email.email_id }"><input
								type="checkbox" name="id[]" value="${email.email_id }" /></a></td>
						<td><a
							href="<%=basePath%>SJXController?methodName=lookbin&email_id=${email.email_id }">${email.send_login_name }</a></td>
						<td><a
							href="<%=basePath%>SJXController?methodName=lookbin&email_id=${email.email_id }">${email.email_theme }</a></td>
						<td><a
							href="<%=basePath%>SJXController?methodName=lookbin&email_id=${email.email_id }"><span
								style="color: #A0A0A0">${email.email_text }......</span></a></td>
						<td><fmt:formatDate value="${email.email_create_time }"
								type="both" /></td>
						<td><div class="button-group">
						<a class="button border-green"
									href="<%=basePath%>SJXController?methodName=recoveryEmail&email_id=${email.email_id }"><span class="icon-repeat"></span> 还原</a>
								<a class="button border-red"
									href="<%=basePath%>SJXController?methodName=deepDelete&email_id=${email.email_id }"
									onclick="return del(${email.email_id })"><span
									class="icon-trash-o"></span> 彻底删除</a>
		
							</div></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="8"><div class="pagelist">
							<a href="">上一页</a> <span class="current">1</span><a href="">2</a><a
								href="">3</a><a href="">下一页</a><a href="">尾页</a>
						</div></td>
				</tr>
			</table>
		</div>
	</form>
	<script type="text/javascript">
		function del(id) {
			if (confirm("您确定要删除吗?")) {
				return true;
			} else {
				return false;
			}
		}

		$("#checkall").click(function() {
			$("input[name='id[]']").each(function() {
				if (this.checked) {
					this.checked = false;
				} else {
					this.checked = true;
				}
			});
		})

		function DelSelect() {
			var Checkbox = false;
			$("input[name='id[]']").each(function() {
				if (this.checked == true) {
					Checkbox = true;
				}
			});
			if (Checkbox) {
				if (confirm("您确认要删除选中的内容吗？")) {
					return true;
				} else {
					return false;
				}
			} else {
				alert("请选择您要删除的内容!");
				return false;
			}
		}
	</script>
</body>
</html>