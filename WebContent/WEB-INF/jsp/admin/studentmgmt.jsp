<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户管理</title>
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
          <ul><li class="item"><a href="${ctx}/studentmgmt">用户管理</a></li></ul>
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
        <ul class="main-nav nav-pills">
            <li class="nav-docs"><a href="${ctx}">首页</a></li>
            <li class="nav-community"><a href="${ctx}/showallstudent">学生列表</a></li>
            <li class="nav-community"><a href="${ctx}/register?flag=1">添加学生</a></li>
        </ul>
    </div>
</nav>



<footer class="main">
    <ul>
        <li class="nav-docs"><a href="${ctx}/about" target="_blank">关于本系统</a></li>
    </ul>
    <p class="less-significant"><a href="${ctx}" target="_blank">图书借阅管理平台</a></p>
    <p class="beianaa">Copyright(C) 2018 All Rights Reserved 版权所有</p>
</footer>
</body>
</html>