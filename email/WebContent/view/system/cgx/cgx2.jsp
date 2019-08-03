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
	<form method="post" action="<%=basePath%>cgxController?methodName=PLdelete"
		onsubmit="return DelSelect()">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 草稿箱</strong> <font color="red">${message}</font>
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
					<th>ID</th>
					<th>主题</th>
					<th>创建时间</th>
					<th>当前状态</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pb.beanList}" var="cgx">
					<tr>
						<td><input type="checkbox" name="id[]" value="${cgx.cgx_id}" />${cgx.cgx_id }</td>
						<td><a
							href="<%=basePath%>cgxController?methodName=updateUI&cgx_id=${cgx.cgx_id }">${cgx.base}</a></td>
						<td><fmt:formatDate value="${cgx.putcgx_time }" type="both" /></td>


						<td><c:if test="${cgx.cgx_type==0}">
									     未发送
									</c:if> <c:if test="${cgx.cgx_type==1}">
									     已发送
									</c:if></td>




						<td><div class="button-group">
								<a class="button border-red"
									href="<%=basePath%>cgxController?methodName=delete&cgx_id=${cgx.cgx_id }"
									onclick="return del(${cgx.cgx_id })"><span
									class="icon-trash-o"></span> 删除</a>
									
									
									
										<a class="button border-red"  
									href="#"
									onclick="return del(${cgx.cgx_id })"><span
									class="icon-check"></span> 转发</a>
							</div></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="8"><div class="pagelist">
					<a href="<c:url value='/cgxController?methodName=pagelist&nowpage=1'/>">首页</a>
					<c:if test="${pb.nowpage>1 }">
					   <a href="<c:url value='/cgxController?methodName=pagelist&nowpage=${pb.nowpage-1 }'/>">上一页</a>
					</c:if>
					<c:if test="${pb.nowpage<pb.totalpagesize-1}">
					    <a href="<c:url value='/cgxController?methodName=pagelist&nowpage=${pb.nowpage+1 }'/>">下一页</a>
					</c:if>
					<a href="<c:url value='/cgxController?methodName=pagelist&nowpage=${pb.totalpagesize-1}'/>">尾页</a>
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