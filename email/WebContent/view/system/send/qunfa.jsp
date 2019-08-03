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
<link rel="stylesheet" href="css/position.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<script>
	$(function() {
		var array = new Array();
		<c:forEach items="${selectedNames}" var="name" >
		array.push("${name}"); //对象，加引号       
		</c:forEach>
		for (var i = 0; i < array.length; i++) {
			$("#" + array[i]).attr("checked", "checked");
		}
	})
</script>
</head>


<body>
	<form method="post" action="<%=basePath%>SendController?methodName=qf">
		<input type="hidden" name="recUser_name[]" value="${user.login_name}">
		<input type="hidden" name="recUser_ids[]" value="${user.user_id}">
		<input type="hidden" name="sendUser_name" value="${USER.login_name }">
		<div class="panel admin-panel">
			<!-- 	<div class="padding border-bottom">
				<ul class="search"></ul>
			</div> -->
			<div class="form-group " style="margin-bottom: 10px">
				<div class="label">
					<label>主题:</label>
				</div>
				<div class="field theme_class">
					<input type="text" class="input w51 " value="" name="email_theme"
						data-validate="required:请写入主题" />
					<div class="tips"></div>
				</div>
			</div>
			<div class="form-group ">
				<div class="label ">
					<label>正文:</label>
				</div>
				<div class="field theme_class">
					<input type="text" class="input w51 " value="" name="email_text"
						data-validate="required:请输入正文" style="height: 400px" />
					<div class="tips"></div>
				</div>
				<table class="table table-hover text-left">
					<tr>
						<td>勾选你要发送的用户</td>
					</tr>
					<c:forEach items="${userList }" var="user">
						<tr>
							<td><input type="hidden" name="recUser_ids[]"
								value="${user.user_id}" />${user.user_id}<input type="checkbox" name="recUser_name[]"
								value="${user.login_name}" />${user.name }
								</td> 
						</tr>
					</c:forEach>

				</table>
			</div>
			<button type="submit" class="button button-little bg-blue  send">发送</button>
		</div>
	</form>
	<script type="text/javascript">
		function del(id) {
			if (confirm("您确定要删除吗?")) {
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
				var t = confirm("您确认要删除选中的内容吗？");
				if (t == false)
					return false;
			} else {
				alert("请选择您要删除的内容!");
				return false;
			}
		}
	</script>
</body>
</html>