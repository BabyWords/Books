<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Insert title here</title>
</head>

<!-- 需要添加js来验证索书号是否为数字以及标题等是否超出长度 -->
<body>
	<div class="container">
		<div class="col-md-4 col-md-offset-4">
			<form action="<%=basePath%>addbooks" method="post" role="form">
				<div class="form-group">
					<label>书号：</label> <input type="text" class="form-control"
						name="marc_no" id="marc_no" /><br>
				</div>
				<div class="form-group">
					<label>书名：</label> <input type="text" class="form-control"
						name="title" id="title" /><br>
				</div>
				<div class="form-group">
					<label>作者：</label><input type="text" class="form-control"
						name="author" id="author" /></br>
				</div>
				<div class="form-group">
					<label>出版社：</label><input type="text" class="form-control"
						name="press" id="press" /></br>
				</div>
				<div align="center">
					<div>
						<button type="submit" class="btn btn-default">添加书本</button>
						<button class="btn btn-info" type="button"
							onClick="window.location.href='<%=basePath%>getallbooks'">返回列表</button>
					</div>
			</form>
		</div>
	</div>
</body>
</html>