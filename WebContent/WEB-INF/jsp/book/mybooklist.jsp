<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>我的书单</title>
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
            <div class="owner">
                <a href="${ctx}/showmyprofile" class="img">
                  <img src="${ctx}/images/avatar-min.png" title="${sessionScope.student.name}" alt="${sessionScope.student.name}">
              	</a>
              <span class="u">
                  <span class="name"><a href="${ctx}/showusercenter">${sessionScope.student.name}</a></span>
                  <span class="opts">
                    <img align="absmiddle" src="${ctx }/images/men.png">      
                    <a href="${ctx}/showmyprofile">修改资料</a>
<%--                     <a href="${ctx}/changeface?student_id = ${sessionScope.student.id}/">更换头像</a> --%>
                </span>
            </span>
            <div class="clear"></div>
        </div>
        <div class="opts clearfix">
          <a href="${ctx}/showmybooklist" class="a1 books"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx}/images/book1.png" width="50" height="50" /><br><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我的书包</span></a>
          <a href="${ctx}/showmyremarklist" class="a2 books"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${ctx}/images/remark.png" width="50" height="50" /><br><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我的评论</span></a>
      </div>
    <div id="blogcatalogs" class="mod">
          <strong>最近借阅</strong>
          <ul>
<%--             <li><a href="${ctx}/showmybooklist">我的书包</a> --%>
            <span>
                 <c:forEach items="${sessionScope.student.books}" var="book" varStatus="stat"  begin="0" end="3" step="1">
                    <li class="">
                        <div class="">
                            <img src="${ctx}/images/${book.coverfilename}" width="50" height="50" /><a href="${ctx}/showbookdetail?id=${book.id}" target="_blank">${book.name}</a>
                        </div>
                    </li>
                </c:forEach>
            </span>
            </li>
        </ul>
    </div>


</div>
      
      
      <div class="spaceList userlist">
        <h1>未归还图书<span class="subtitle">当前借阅 ${fn:length(requestScope.books)} 本图书&nbsp;&nbsp;&nbsp;已归还 ${fn:length(requestScope.backbooks)} 本图书</span></h1>
       <div class="ibklist">
        <ul class="list-col">
        	<c:if test="${fn:length(sessionScope.student.books)==0}">
				<div class="nodata">还没有借阅图书</div>
			</c:if>
            <c:forEach items="${requestScope.books}" var="book" varStatus="stat">
            <li class="">
              <div class="cover">
                <a href="${ctx}/showbookdetail?id=${book.id}" target="_blank" title="${book.name}">
                  <img src="${ctx}/images/${book.coverfilename}" class="" alt="${book.name}" height="158px" width="106px">
                </a>
              </div>
              <div class="">
                <div class="title"><a class="" href="${ctx}/showbookdetail?id=${book.id}" target="_blank" title="${book.name}">${book.name}</a></div>
                <div class="author">${book.author}</div>
              </div>
            </li>
          </c:forEach>
          </ul>
          </div>
        </div>
        
        
              <div class="spaceList userlist">
        <h1>已归还图书<span class="subtitle">当前借阅 ${fn:length(requestScope.books)} 本图书&nbsp;&nbsp;&nbsp;已归还 ${fn:length(requestScope.backbooks)} 本图书</span></h1>
       <div class="ibklist">
        <ul class="list-col">
        	<c:if test="${fn:length(requestScope.backbooks)==0}">
				<div class="nodata">还没有借阅图书</div>
			</c:if>
            <c:forEach items="${requestScope.backbooks}" var="book" varStatus="stat">
            <li class="">
              <div class="cover">
                <a href="${ctx}/showbookdetail?id=${book.id}" target="_blank" title="${book.name}">
                  <img src="${ctx}/images/${book.coverfilename}" class="" alt="${book.name}" height="158px" width="106px">
                </a>
              </div>
              <div class="">
                <div class="title"><a class="" href="${ctx}/showbookdetail?id=${book.id}" target="_blank" title="${book.name}">${book.name}</a></div>
                <div class="author">${book.author}</div>
              </div>
            </li>
          </c:forEach>
          </ul>
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