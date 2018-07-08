<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">  
	<script src="${ctx}/js/jquery.min.js"></script>
	<script src="${ctx}/js/bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>添加学生</title>
</head>
<body>
	<center>

		<form action="${ctx}/student/addStudent" method="post" id="addStudent">
			<table class="table table-hover">
				<input type="hidden" name="flag" value="2">
				<tr><td class="text-center">学号：<input type="text" name="num" class="form-control" placeholder="请输入学号"><br></td><tr>
					<tr><td class="text-center">姓名：<input type="text" name="name" class="form-control" placeholder="请输入姓名"><br></td></tr>
					<tr><td class="text-center">生日：<input type="text" name="birthday" class="form-control" placeholder="请输入生日"><br></td></tr>
					<tr><td class="text-center">身份证：<input type="text" name="idcard" class="form-control" placeholder="请输入身份证"><br></td></tr>
					<tr><td class="text-center">性别：<select name="sex">
						<option value="男">男</option>
						<option value="女">女</option>
					</select><br></td></tr>
					<tr><td class="text-center">密码：<input type="text" name="password" class="form-control" placeholder="请输入密码"><br></td></tr>
					<tr><td class="text-center">电话：<input type="text" name="tel" class="form-control" placeholder="请输入电话"><br></td></tr>
					<tr><td class="text-center">QQ:<input type="text" name="qq" class="form-control" placeholder="请输入QQ"><br></td></tr>
					<tr><td class="text-center">Email:<input type="text" name="email" class="form-control" placeholder="请输入邮箱"><br></td></tr>
					<tr><td class="text-center">地址：<input type="text" name="address" class="form-control" placeholder="请输入邮箱"><br></td></tr>
					<tr><td class="text-center"><input type="submit" value="添加" class="btn btn-default"><input type="reset" value="重置" class="btn btn-default"></td></tr>
				</table>
			</form>

		</center>
	</body>
	</html>

