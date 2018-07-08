<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改图书信息</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="author" content="图书借阅管理平台">
    <meta name="description" content="图书借阅管理平台，是一个专注于图书借阅的平台">
    <meta name="keywords" content="读书,阅读,小说,文学">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/css/yds.css">
    <link rel="stylesheet" href="${ctx}/css/ucenter.css">
    <script src="${ctx}/js/jquery-1.11.3.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
</head>
<body class="docs">
    <div id="navtop">
      <div class="wp1080">
        <div class="yds_channels">
          <ul><li class="item"><a href="${ctx}">首页</a></li></ul>
          <ul><li class="item"><a href="${ctx}/bookmgmt">书籍管理</a></li></ul>
          <ul><li class="item"><a href="${ctx}/remarkmgmt">书评管理</a></li></ul>
          <ul><li class="item"><a href="${ctx}/usermgmt">用户管理</a></li></ul>
          <ul><li class="item"><a href="${ctx}/borrowmgmt">借阅管理</a></li></ul>
          <ul><li class="item"><a href="${ctx}/categorymgmt">分类管理</a></li></ul>
          <ul><li class="item"><a href="${ctx}/advancedsearch">高级搜索</a></li></ul>
      </div>
      <div class="yds_userbar">
                     <c:if test="${sessionScope.student!=null}">
      [ <a href="${ctx}/showusercenter">用户中心</a> | <a href="${ctx}/logoff">退出</a> ]
      </c:if>
      
      <c:if test="${sessionScope.admin!=null}">
      [ <a href="${ctx}/showadmincenter">管理员中心</a> | <a href="${ctx}/logoff">退出</a> ]
      </c:if>
    </div>
</div>
</div>
<nav class="main">
    <div class="container">
        <a href="${ctx}" class="brand">图书借阅管理平台</a>
        <div class="search">
            <form class="bs-example bs-example-form" role="form" action="${ctx}/searchbook" method="post">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="input-group">
                            <input type="text" value="" maxlength="60" name="name" id="search" placeholder="书名" class="form-control">
                            <span class="input-group-btn">
                                <button type="submit" class="btn btn-default">找书</button>&nbsp;<a href="${ctx}/advancedsearch"><button type="button" class="btn btn-default">高级检索</button></a>
                            </span>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <ul class="main-nav">
            <li class="nav-docs"><a href="${ctx}">首页</a></li>
            <li class="nav-community"><a href="${ctx}/showbooks">图书列表</a></li>
            <li class="nav-community"><a href="${ctx}/showaddbook">添加图书</a></li>

        </ul>
    </div>
</nav>


<div class="docs-wrapper container">

   <h1>修改图书信息</h1>
   <hr>
    <form name="form" class="form-horizontal" role="form" action="${ctx}/modifybook" method="post">
    <input name="id" value="${requestScope.book.id}" type="hidden">
    
    <div class="form-group">
      <label for="name" class="col-sm-2 control-label">书名:</label>
      <div class="col-sm-10">
         <input id="name" name="name" class="form-control input-lg" type="text" maxlength="150" value="${requestScope.book.name}">
      </div>
    </div>
    
    <div class="form-group">
      <label for="author" class="col-sm-2 control-label">作者:</label>
      <div class="col-sm-10">
         <input id="author" name="author" class="form-control input-lg" type="text" maxlength="150" value="${requestScope.book.author}">
      </div>
    </div>
    
   <div class="form-group">
      <label for="category" class="col-sm-2 control-label">分类:</label>
      <div class="col-sm-10">
      	<select  name="category_id" class="form-control input-lg">
			<c:forEach items="${requestScope.categorys }" var="category">
			<option value="${category.id }">${category.name}</option>
			</c:forEach>
		</select>
      </div>
    </div>
    
    <div class="form-group">
      <label for="isbn" class="col-sm-2 control-label">ISBN:</label>
      <div class="col-sm-10">
         <input id="isbn" name="isbn" class="form-control input-lg" type="text" maxlength="150" value="${requestScope.book.isbn}">
      </div>
    </div>

    <div class="form-group">
      <label for="publisher" class="col-sm-2 control-label">出版社:</label>
      <div class="col-sm-10">
         <input id="publisher" name="publisher" class="form-control input-lg" type="text" maxlength="150" value="${requestScope.book.publisher}">
      </div>
    </div>

<!-- 	<div class="form-group">
      <label for="coverfile" class="col-sm-2 control-label">封面:</label>
      <div class="col-sm-10">
         <input id="coverfile" name="coverfile" class="form-control input-lg" type="file">
      </div>
    </div> -->

    <div class="form-group">
      <label for="year" class="col-sm-2 control-label">出版年份:</label>
      <div class="col-sm-10">
         <input id="year" name="year" class="form-control input-lg" type="text" maxlength="150" value="${requestScope.book.year}">
      </div>
    </div>


   	<div class="form-group">
      <label for="words" class="col-sm-2 control-label">字数:</label>
      <div class="col-sm-10">
         <input id="words" name="words" class="form-control input-lg" type="text" maxlength="150" value="${requestScope.book.words}">
      </div>
    </div>
    
    
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
         <span class="ms"></span>
      <input type="reset" class="btn btn-warning btn-lg" name="重置" value="重置" style="float:right">
      <input type="submit" class="btn btn-success btn-lg" name="修改" value="修改" style="float:right">
      </div>
    </div>
    </form> 

</div>

<footer class="main">
    <ul>
        <li class="nav-docs"><a href="${ctx}/about" target="_blank">关于本系统</a></li>
    </ul>
    <p class="less-significant"><a href="${ctx}" target="_blank">图书借阅管理平台</a></p>
    <p class="beianaa">Copyright(C) 2018 All Rights Reserved 版权所有</p>
</footer>
</body>
</html>