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
<title>已经删除的邮件</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
	<form method="post"
		action="<%=basePath%>SendController?methodName=thoroughPLDelete">
		<input type="hidden" name="id[]" value="${mail.email_id}"> <input
			type="hidden" name="user_name" value="${USER.login_name}">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 留言管理</strong>
			</div>
			<div class="padding border-bottom">
				<ul class="search">
					<li>
						<button type="button" class="button border-green" id="checkall">
							<span class="icon-check"></span> 全选
						</button> <a href="view/system/user/addUser.jsp" class="button border-blue"><span
							class="icon-plus"></span> 增加</a>
						<button type="submit" class="button border-red">
							<span class="icon-trash-o"></span> 批量删除
						</button>
					</li>
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th></th>
					<th>收件人</th>
					<th>主题</th>
					<th>发送时间</th>
					<th colspan="2">操作</th>
				</tr>
				<c:forEach items="${mailList}" var="mail">
					<tr>
						<td><input type="checkbox" name="id[]"
							value="${mail.email_id }" /></td>
						<td>${mail.rec_login_name }</td>
						<td>${mail.email_theme }</td>
						<td>${mail.email_create_time }</td>
						<td><div class="button-group">
								<a class="button border-green"
									href="<%=basePath%>SendController?methodName=queryMail&mail_id=${mail.email_id}"><span
									class="icon-trash-o"></span> 查看</a> <a class="button border-blue"
									href="<%=basePath%>SendController?methodName=recoverMail&mail_id=${mail.email_id}&user_name=${USER.login_name}"><span
									class="icon-share"></span> 恢复到发件箱</a> <a
									class="button border-red"
									href="<%=basePath%>SendController?methodName=thoroughdeleteMail&user_name=${USER.login_name}&mail_id=${mail.email_id }"
									onclick="if(confirm('您确定要删除吗?')==false)return false;"><span
									class="icon-trash-o"></span> 删除</a>
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
				//<a href="a.html" onclick="if(confirm('确定删除?')==false)return false;">删除</a>
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