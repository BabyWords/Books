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
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=path%>/dist/css/bootstrap.min.css" />
<link href="<%=path%>/layui/css/layui.css" rel="stylesheet">
<title>书目列表</title>
</head>
<body>
	<script type="text/javascript" src="<%=path%>/layui/layui.js"></script>
	<div class="container">
		<div class="col-md-8 col-md-offset-2" style="margin-top: 80px">
			<form class="form-horizontal" role="form"
				action="<%=basePath%>searchbooks" method="post">
				<div class="form-group" id="searchform">
					<label class="col-md-3" style="font-size: 30px">书目列表</label>
					<div class="col-md-9" align="right">
						<input type="text" id="booktitle" name="booktitle" " />
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

				<c:forEach var="book" items="${blist}">
					<tr>
						<td>${book.marc_no}</td>
						<td>${book.title}</td>
						<td>${book.author}</td>
						<td>${book.press }</td>
						<td><a href="<%=basePath%>deletebook?marc_no=${book.marc_no}">删除</a>&nbsp|&nbsp
							<a href="#">修改</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div align="center">
				<button class="btn btn-info"
					onClick="window.location.href='addbook.jsp'">添加书本信息</button>
			</div>
		</div>
		<div id="pagecontent" class="col-md-8 col-md-offset-2" align="center"></div>
	</div>
	<script type="text/javascript">
    layui.use(['layer', 'laypage'], function(){
    	/* alert("sadaa") */
    	debugger;
    	
        var laypage=layui.laypage;
        laypage({
            cont: 'pagecontent' //分页容器的id
            ,pages: '${page.totalPage}' //总页数
            ,skin: '#8ab86e' //自定义选中色值
            ,skip: true //开启跳页
            ,curr:'${page.currentPage}'
            ,jump:function (obj, first) {
                if(first!=true){
                    window.location.href="<%=basePath%>getallbooks?currentPage="+obj.curr;
									}
								}
							});
						})
	</script>
</body>

</html>