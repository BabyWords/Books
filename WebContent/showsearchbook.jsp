<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=path%>dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=path%>/dist/css/bootstrap.min.css" />
<title>查询结果</title>
</head>
<body>
	<div class="container">
		<div class="col-md-8 col-md-offset-2" style="margin-top: 80px">
			<form class="form-horizontal" role="form" action="<%=basePath%>searchbooks" method="post">
				<div class="form-group" id="searchform">
					<label class="col-md-3" style="font-size: 30px">书目列表</label>
					<div class="col-md-9" align="right">
						<input type="text" id="booktitle" name="booktitle"" />
						<button type="submit" class="btn btn-default">&nbsp搜&nbsp&nbsp索&nbsp</button>
					</div>
				</div>
			</form>
			<table id="booktable"
				class="table table-striped table-hover table-bordered">
				<tr>
					<td>索书号</td>
					<td>书名</td>
					<td>作者</td>
					<td>出版社</td>
					<td>操作</td>
				</tr>

				<c:forEach var="book" items="${booklist}">
					<tr>
						<td>${book.marc_no}</td>
						<td>${book.title}</td>
						<td>${book.author}</td>
						<td>${book.press }</td>
						<td><a href="<%=basePath%>deletebook?marc_no=${book.marc_no}">删除</a>&nbsp|&nbsp
							<a href="<%=basePath%>modifybook?marc_no=${book.marc_no}">修改</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div align="center">
				<button class="btn btn-info" onClick="window.location.href='<%=basePath%>getallbooks'">返回列表</button>
			</div>
		</div>
	</div>

</body>
</html>