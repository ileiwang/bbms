<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>个人信息</title>
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
        <!-- 学生显示 -->
        <c:if test="${sessionScope.student!=null}">
          <ul><li class="item"><a href="${ctx}">首页</a></li></ul>
          <ul><li class="item"><a href="${ctx}/showbooks">书库</a></li></ul>
          <ul><li class="item"><a href="${ctx}/showremarks">书评</a></li></ul>
          <ul><li class="item"><a href="${ctx}/advancedsearch">高级搜索</a></li></ul>
        </c:if>
        
        <!--管理员显示  -->
        <c:if test="${sessionScope.admin!=null}">
          <ul><li class="item"><a href="${ctx}">首页</a></li></ul>
          <ul><li class="item"><a href="${ctx}/bookmgmt">书籍管理</a></li></ul>
          <ul><li class="item"><a href="${ctx}/remarkmgmt">书评管理</a></li></ul>
          <ul><li class="item"><a href="${ctx}/usermgmt">用户管理</a></li></ul>
          <ul><li class="item"><a href="${ctx}/borrowmgmt">借阅管理</a></li></ul>
          <ul><li class="item"><a href="${ctx}/categorymgmt">分类管理</a></li></ul>
          <ul><li class="item"><a href="${ctx}/advancedsearch">高级搜索</a></li></ul>
        </c:if>
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

		<c:if test="${sessionScope.student!=null}">
        <ul class="main-nav">
            <li class="nav-docs"><a href="${ctx}">首页</a></li>
            <li class="nav-community"><a href="${ctx}/showbooks">书库</a></li>
            <li class="nav-community"><a href="${ctx}/showremarks">书评</a></li>
            <li class="nav-community"><a href="${ctx}/showwishbook">想读</a></li>
        </ul>
        </c:if>
        
        <c:if test="${sessionScope.admin!=null}">
        <ul class="main-nav">
            <li class="nav-community"><a href="${ctx}/bookmgmt">图书</a></li>
            <li class="nav-community"><a href="${ctx}/remarkmgmt">书评</a></li>
            <li class="nav-community"><a href="${ctx}/usermgmt">用户</a></li>
            <li class="nav-community"><a href="${ctx}/borrowmgmt">借阅</a></li>
            <li class="nav-community"><a href="${ctx}/categorymgmt">分类</a></li>
        </ul>
        </c:if>
    </div>
</nav>

<div id="yds_screen">
    <div id="yds_content" class="clearfix">


        <div class="spaceleft">
            <div class="adminnav">
              <a href="${ctx }/showusercenter" class="img">
                <img src="${ctx }/images/avatar-min.png" title="${sessionScope.student.name}" alt="${sessionScope.student.name}">
            </a>
            <a href="${ctx}/showmyprofile">修改个人资料</a>
        </div>
        <div class="adminmenus">
          <ul>
            <li class="caption">
              <strong>个人信息管理</strong>
              <ol>
                  <li><a href="${ctx}/showmyprofile">修改个人资料</a></li>
                  <li><a href="${ctx}/changepasswd?flag=1">修改登录密码</a></li>
<!--                   <li><a href="">更改头像图片</a></li> -->
              </ol>
          </li>
      </ul>
  </div>
</div>


<div class="spaceList adminbody">
    <div class="adminhead">
        <h1>修改个人资料</h1>
    </div>
    <div class="admincontent mainform">
        <form name="form" class="form-horizontal" method="post" action="${ctx}/updateprofile">
            <input type="hidden" name="_token" value="">
            <div class=""><span>学号：</span><span>${sessionScope.student.num}</span></div>
          	<input class="form-control" style="width:300px;" name="id" maxlength="128" value="${sessionScope.student.id}" type="hidden">
          	<input class="form-control" style="width:300px;" name="num" maxlength="128" value="${sessionScope.student.num}" type="hidden">
            <div class="">
                <span>姓名：</span>
                <span>
                    <input class="form-control" style="width:300px;" name="name" maxlength="128" value="${sessionScope.student.name}" type="text">
                </span>
            </div>
            
            <c:if test="${sessionScope.student.sex.equals(\"男\")}">
          	<div class="">
                <span>性别：</span>
                <span>
                    <input name="sex" value="男" type="radio" checked="checked">男 
                    <input name="sex" value="女" type="radio">女
                </span>
            </div>
        	</c:if>
        	
        	<c:if test="${sessionScope.student.sex.equals(\"女\")}">
          	<div class="">
                <span>性别：</span>
                <span>
                    <input name="sex" value="男" type="radio">男 
                    <input name="sex" value="女" type="radio" checked="checked">女
                </span>
            </div>
        	</c:if>
            <div class="">
                <span>证件：</span>
                <span>
                    <input class="form-control" style="width:300px;" name="idcard" maxlength="128" value="${sessionScope.student.idcard}" type="text">
                </span>
            </div>
            
            <div class="">
                <span>QQ：</span>
                <span>
                    <input class="form-control" style="width:300px;" name="qq" maxlength="128" value="${sessionScope.student.qq}" type="text">
                </span>
            </div>
            <div class="">
                <span>邮箱：</span>
                <span>
                    <input class="form-control" style="width:300px;" name="email" maxlength="128" value="${sessionScope.student.email}" type="text">
                </span>
            </div>
            <div class="">
                <span>手机：</span>
                <span>
                    <input class="form-control" style="width:300px;" name="tel" maxlength="128" value="${sessionScope.student.tel}" type="text">
                </span>
            </div>
            <div class="">
                <span>专业：</span>
                <span>
                    <input class="form-control" style="width:300px;" name="major" maxlength="128" value="${sessionScope.student.major}" type="text">
                </span>
            </div>
            <div class="">
                <span>学院：</span>
                <span>
                    <input class="form-control" style="width:300px;" name="college" maxlength="128" value="${sessionScope.student.college}" type="text">
                </span>
            </div>
            <div class="">
                <span>地址：</span>
                <span>
                    <input class="form-control" style="width:300px;" name="address" maxlength="128" value="${sessionScope.student.address}" type="text">
                </span>
            </div>

            <div class="bton"><span class="ms"></span><button type="submit" id="saveprofile" class="btn btn-success">保存</button></div>
        </form>
    </div>
</div>
</div>
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