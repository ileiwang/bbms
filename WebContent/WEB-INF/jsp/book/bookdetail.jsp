<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>图书详细信息</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="author" content="图书借阅管理平台">
    <meta name="description" content="图书借阅管理平台，是一个专注于图书借阅的平台">
    <meta name="keywords" content="读书,阅读,小说,文学">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/css/yds.css">
    <link rel="stylesheet" href="${ctx}/css/dialog.css">
    <link rel="stylesheet" href="${ctx}/css/ucenter.css">
    <script src="${ctx}/js/jquery-1.11.3.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
    <script src="${ctx}/js/dialog.js"></script>
    <script src="${ctx}/js/reglgdialog.js"></script>
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


<c:if test="${requestScope.book!=null}">

<div class="docs-wrapper container">

  <div class="binfo">
      <div class="subjectwrap">
        <div class="infotitle"><h1>${requestScope.book.name}</h1></div>
        <div class="info clearfix">            
            <div class="indent">
                <a href="${ctx}/showbookdetail?id=${requestScope.book.id}" target="_blank">
                    <img src="${ctx}/images/${book.coverfilename}">
                </a>
            </div>
            <div class="info1">
                <span class="p1">作者:${requestScope.book.author}</span><br>
                <span class="p1">出版社:${requestScope.book.publisher}</span><br>
                <span class="p1">出版年:${requestScope.book.year}</span><br>
                <span class="p1">字数:${requestScope.book.words}</span><br>
                <span class="p1">定价:88.00</span><br>
                <span class="p1">装帧:平装</span><br>
                <span class="p1">ISBN:${requestScope.book.isbn}</span><br>                  
            </div>        
        </div>
    </div>
    
    <div class="interest_sect_level">
       <c:if test="${requestScope.isback==1&&sessionScope.student!=null}">
       <button type="button" class="btn btn-success btn-lg want">借阅</button>
       <button type="button" class="btn btn-danger btn-lg reading disabled">归还</button>
   </c:if>
   <c:if test="${requestScope.isback==0&&sessionScope.student!=null}">
   <button type="button" class="btn btn-danger btn-lg want disabled">借阅</button>
   <button type="button" class="btn btn-success btn-lg reading">归还</button>
</c:if>
</div>

<c:if test="${sessionScope.student!=null}">   
<div class="xsp">
    <span class="subject_menu">
        <img src="${ctx}/images/remark.gif">
        <a href="${ctx}/showaddremark?book_id=${book.id}">写书评</a>
    </span>
</div>
</c:if>


<div class="related_info">
    <div id="review">
      <div class="cp-head">
      <span class="p1">书评</span><span class="com">(<a href="${ctx}/showremarklist?book_id=${book.id}">全部 ${fn:length(book.remarks)}条</a>)</span>
    </div>
    <!-- <div class="liec"> -->
        <c:forEach items="${book.remarks}" var="remark" varStatus="stat">
        <div class="ctsh">
            <div class="tlst">
                <div class="ilst">
                    <a class="" href="${ctx}/showprofile?id=${remark.student.id}" title="${remark.student.name}">
                        <img src="${ctx}/images/face.jpg"></a>
                    </div>
                    <div class="">
                        <span class="cp-title"><a href="${ctx}/showremarkdetail?id=${remark.id}" title="${remark.title}">${remark.title}</a></span>
                        <span class="user-name"><a class="" href="${ctx}/showprofile?id=${remark.student.id}">${remark.student.name}</a></span><span class="rating allstar50"></span>
                    </div>
                </div>
                <div class="review-short">${remark.content}</div>
                <div class="uptime"><span class="wz"><fmt:formatDate value="${remark.time}" pattern="yyyy-MM-dd HH:mm:ss"/></span></div>
            </div>
        </c:forEach>
<!--     </div> -->
</div>       
</div>
</div>
</div>

<div class="dialog-popover dialog-want">
    <div class="dialog-poptit">
        <a title="关闭" class="close">×</a>
        <h3>我想读这本书</h3>
    </div>
    <c:if test="${requestScope.isback==1}">
    <form class="" name="read-want" id="read-want" action="${ctx}/borrow" method="post">
        <input type="hidden" name="student_id" value="${sessionScope.student.id}">
        <input type="hidden" name="book_id" value="${requestScope.book.id}">
        <div class="dialog-content">
            <center>确定借阅吗？</center>
        </div>
        <div class="dialog-foot">
            <div class="save"><button type="submit" class="btn btn-success btn-sm" id="">确定</button></div>
        </div>
    </form>
	</c:if>
    <c:if test="${requestScope.isback==0}">
    <form class="" name="read-want" id="read-want" action="" method="post">
    	<br>
		<center><h3>这本书已经被借走了</h3></center>
<!--         <div class="dialog-foot">
            <div class="save"><button type="submit" class="btn btn-success btn-sm" id="">关闭</button></div>
        </div> -->
        
        <div class="dialog-foot">
            <div class="save"><a class=""><button class="btn btn-success btn-sm" id="">关闭</button></a></div>
        </div>
        
    </form>
</c:if>
</div>


<div class="dialog-popover dialog-reading">
    <div class="dialog-poptit">
        <a title="关闭" class="close">×</a>
        <h3>我要归还这本书</h3>
    </div>
    <c:if test="${requestScope.isback==0}">
    <form class="" name="reading" id="reading" action="${ctx}/back" method="post">
        <input type="hidden" name="student_id" value="${sessionScope.student.id}">
        <input type="hidden" name="book_id" value="${requestScope.book.id}">
        <div class="dialog-content">
            <div class=""><center>请填写简短书评：</center></div>
            <br>
            <div class="">
            	<input class="form-control" type="text" name="title" id="tittle" placeholder="标题">
            	<br>
            	<br>
                <textarea id="content" class="form-control" name="content" maxlength="300" placeholder="内容"></textarea>
            </div>         
        </div>
        <div class="dialog-foot">
            <div class="save"><span class="ms-reading"></span><button type="submit" class="btn btn-success btn-sm" id="savebutton-reading">归还</button></div>
        </div>
    </form>
</c:if>
    <c:if test="${requestScope.isback==1}">
    <form class="" name="reading" id="reading" action="" method="post">
		<center><h3>图书已经归还</h3></center>
        <div class="dialog-foot">
            <div class="save"><span class="ms-reading"></span><button type="submit" class="btn btn-success btn-sm" id="savebutton-reading">关闭</button></div>
        </div>
    </form>
</c:if>
</div>


<div class="dialog-popover-mask"></div>

</c:if>


<c:if test="${requestScope.book==null}">
<div class="docs-wrapper container">
<br>
<center><h2>图书不存在！请重新搜索。</h2></center>
</div>
</c:if>

<footer class="main">
<ul>
    <li class="nav-docs"><a href="${ctx}/about" target="_blank">关于本系统</a></li>
</ul>
<p class="less-significant"><a href="${ctx}" target="_blank">图书借阅管理平台</a></p>
<p class="beianaa">Copyright(C) 2018 All Rights Reserved 版权所有</p>
</footer>

</body>
</html>