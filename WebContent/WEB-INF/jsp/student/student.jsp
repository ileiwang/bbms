<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>所有学生</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<link href="${ctx}/css/css.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="${ctx}/js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
	<link href="${ctx}/js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="${ctx }/js/jquery-migrate-1.2.1.js"></script>
	<script src="${ctx}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="${ctx}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="${ctx}/js/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
	<link href="${ctx}/css/pager.css" type="text/css" rel="stylesheet" />
	
	
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">  
	<script src="${ctx}/js/jquery.min.js"></script>
	<script src="${ctx}/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
		$(function(){
			/** 获取上一次选中的部门数据 */
			var boxs  = $("input[type='checkbox'][id^='box_']");

			
			
			/** 删除员工绑定点击事件 */
			$("#delete").click(function(){
				/** 获取到用户选中的复选框  */
				var checkedBoxs = boxs.filter(":checked");
				if(checkedBoxs.length < 1){
					$.ligerDialog.error("请选择一个需要删除的用户！");
				}else{
					/** 得到用户选中的所有的需要删除的ids */
					var ids = checkedBoxs.map(function(){
						return this.value;
					})
					
					$.ligerDialog.confirm("确认要删除吗?","删除用户",function(r){
						if(r){
	 					   // 发送请求
	 					   window.location = "${ctx }/student/removeStudent?ids=" + ids.get();
	 					}
	 				});
				}
			})
		})
	</script>
</head>
<body>
	<table class="table table-striped">
		<tr>
			<td height="30">
				<table class="table table-striped">
					<tr>
						<td>
							<form name="empform" method="post" id="empform" action="${ctx}/student/selectStudent">
								<table>
									<tr>
										<td>
											学号：<input type="text" name="num">
											姓名：<input type="text" name="name">
											<input type="submit" value="搜索"/>
											<input id="delete" type="button" value="删除"/>
										</td>
									</tr>
								</table>
							</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		
		<tr>
			<td>
				<table class="table table-hover">
					<tr class="success" align="center">
						<td><input type="checkbox" name="checkAll" id="checkAll"></td>
						<td>学号</td>
						<td>密码</td>
						<td>姓名</td>
						<td>性别</td>
						<td>生日</td>
						<td align="center">操作</td>
					</tr>
					<c:forEach items="${requestScope.students}" var="student" varStatus="stat">
					<tr id="data_${stat.index}" align="center" onMouseOver="move(this);" onMouseOut="out(this);">
						<td><input type="checkbox" id="box_${stat.index}" value="${student.id}"></td>
						<td>${student.num}</td>
						<td>${student.password }</td>
						<td>${student.name}</td>
						<td>${student.sex}</td>
						<td><f:formatDate value="${student.birthday}" type="date" dateStyle="long"/></td>
						<td align="center" width="40px;"><a href="${ctx}/student/updateStudent?flag=1&id=${student.id}"><img title="修改" src="${ctx}/images/update.png"/></a></td>
					</tr>
				</c:forEach>
			</table>
		</td>
	</tr>
	
	
	<tr>
		<td align="center">
			<sms:pager
			pageIndex="${requestScope.pageModel.pageIndex}" 
			pageSize="${requestScope.pageModel.pageSize}"
			recordCount="${requestScope.pageModel.recordCount}" 
			style="digg"
			submitUrl="${ctx}/student/selectStudent?pageIndex={0}"/>
		</td>
	</tr>
</table>
</body>
</html>