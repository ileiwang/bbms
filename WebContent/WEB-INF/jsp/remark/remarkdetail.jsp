<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>图书借阅管理平台</title>
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
        [ <a href="${ctx}/showusercenter">个人中心</a> | <a href="${ctx}/logoff">退出</a> ]
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
      <div class="review">
       <h1>${remark.title}</h1>
       <div class="touxiang">
         <a class="aw-user-name" href="${ctx }/showprofile?id=${remark.student.id}">
          <img class="pil" src="${ctx}/images/face.jpg">
        </a>
      </div>
      <div class="mn"><span>来自: <a class="aw-user-name" href="${ctx}/showprofile?id=${remark.student.id}">${remark.student.name}</a></span><span>于 <fmt:formatDate value="${remark.time}" pattern="yyyy-MM-dd HH:mm:ss"/></span></div> 
      <div class="mn"><span>对<a href="${ctx}/showbookdetail?id=${remark.book.id}">《${remark.book.name}》</a>的评论</span><span class="bigstar50"></span></div> 
      <hr>
      <div class="reviewtext clearfix">
        <p>${remark.content}</p>
      </div>
      
      <c:if test="${sessionScope.student!=null}">
            <hr>
      <br>
      <br>
      <h3>我要评论</h3>
      <hr>
        <div class="pinglun">
          <a class="aw-user-name" href="${ctx }/showprofile?id=${remark.student.id}">
            <img src="${ctx}/images/avatar-min.png">
          </a>
          <span class="uname"><a href="${ctx}/showusercenter/">${sessionScope.student.name}</a></span>
        </div>
        <br>

        <form id="form" method="post" action="${ctx}/addremark">
          <input type="hidden" name="student_id" id="student_id" value="${sessionScope.student.id}">
          <input type="hidden" name="book_id" id="book_id" value="${remark.book.id}">
                 
         <div class="input-group input-group-lg">
			<span class="input-group-addon">标题</span>
			<input type="text" class="form-control" placeholder="在此输入标题" name="title" id="title">
		</div>
          <div class="form-group">              
            <textarea name="content" id="content" class="form-control contxt" rows="5" placeholder="在此进行评论"></textarea>
          </div>
          <div class="right">
            <span id="ms"></span>
            <button type="input" id="spbutton" class="btn btn-success">发布</button>
          </div>
        </form> 
      
      </c:if>
 
      </div>
      <div style="clear:both;"></div>
      <div class="comment-list">
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