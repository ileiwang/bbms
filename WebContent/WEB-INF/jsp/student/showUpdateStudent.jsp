<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>修改学生信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<link href="${ctx}/css/css.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#updateStudent").submit(function(){
				var num = $("#num");
				var name = $("#name");
				var birthday = $("#birthday");
				var idcard = $("#idcard");
				var sex = $("#sex");
				var password = $("#password");
				var tel = $("#tel");
				var qq = $("#qq");
				var email = $("#email");
				var address = $("#address");
				var msg = "";
				if ($.trim(num.val()) == ""){
					msg = "学号不能为空！";
					num.focus();
				}else if ($.trim(name.val()) == ""){
					msg = "姓名不能为空！";
					name.focus();
				}else if ($.trim(idcard.val()) == ""){
					msg = "身份证不能为空！";
					idcard.focus();
				}else if ($.trim(sex.val()) == ""){
					msg = "性别不能为空！";
					sex.focus();
				}
				else if ($.trim(password.val()) == ""){
					msg = "密码不能为空！";
					password.focus();
				}
				else if ($.trim(tel.val()) == ""){
					msg = "电话不能为空！";
					tel.focus();
				}
				else if ($.trim(qq.val()) == ""){
					msg = "QQ不能为空！";
					qq.focus();
				}
				else if ($.trim(email.val()) == ""){
					msg = "邮箱不能为空！";
					email.focus();
				}
				else if ($.trim(address.val()) == ""){
					msg = "地址不能为空！";
					address.focus();
				}
				if (msg != ""){
					$.ligerDialog.error(msg);
					return false;
				}else{
					return true;
				}
				$("#updateStudent").submit();
			});
		});
	</script>
</head>
<body>
	<form action="${ctx}/student/updateStudent" id="updateStudent" method="post">
		<input type="hidden" name="flag" value="2">
		<input type="hidden" name="id" value="${student.id }">
		<table class="table table-hover">
			<tr><td>学号：<input type="text" name="num" id="num" size="20" value="${student.num }"/></td></tr>
			<tr><td>姓名：<input type="text" name="name" id="name" size="20" value="${student.name }"/></td></tr>
			<tr><td>身份证：<input type="text" name="idcard" id="idcard" size="20" value="${student.idcard }"/></td></tr>
			<tr><td>性别：<input type="text" name="sex" id="sex" size="20" value="${student.sex }"/></td></tr>
			<tr><td>密码：<input type="text" name="password" id="password" size="20" value="${student.password }"/></td></tr>
			<tr><td>电话：<input type="text" name="tel" id="tel" size="20" value="${student.tel }"/></td></tr>
			<tr><td>QQ：<input type="text" name="qq" id="qq" size="20" value="${student.qq }"/></td></tr>
			<tr><td>Email：<input type="text" name="email" id="email" size="20" value="${student.email }"/></td></tr>
			<tr><td>地址：<input type="text" name="address" id="address" size="20" value="${student.address }"/></td></tr>
			<tr><td><input type="submit" value="修改 ">&nbsp;&nbsp;
				<input type="reset" value="取消 "></td></tr>
			</table>
		</form>
	</body>
	</html>