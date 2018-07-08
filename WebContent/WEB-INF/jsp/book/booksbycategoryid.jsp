<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>书籍分类--${requestScope.category.name}</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="author" content="图书借阅管理平台">
    <meta name="description" content="图书借阅管理平台，是一个专注于图书借阅的平台">
    <meta name="keywords" content="读书,阅读,小说,文学">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/css/yds.css">
    <script src="${ctx}/js/jquery-1.11.3.min.js"></script>
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
<div class="docs-wrapper container">

    <article>
        <div class="tags">
            <h1><font color="green" size="6">${requestScope.category.name}</font>分类下所有图书</h1>
        </div>
        <div class="mod book-list">
                <c:forEach items="${requestScope.books}" var="book" varStatus="stat">
                 <dl>
                <dt>
                    <a href="${ctx}/showbookdetail?id=${book.id}" target="_blank">
                        <img src="${ctx }/images/${book.coverfilename}">
                    </a>
                </dt>
                <dd>
                    <a href="${ctx}/showbookdetail?id=${book.id}" class="title" target="_blank">${book.name} </a>
                    <div class="desc">
                        ${book.author} / 
                        
                        ${book.publisher}  / 
                    ${book.year}  /            99.00元            </div>
                    <div class="rating">
                        <span class="allstar"></span>
                        <span class="rating_nums">阅读：0</span>
                    </div>
                  <c:if test="${sessionScope.admin!=null}">
                    <hr>
                    <div>
<%--                         <form class="" name="reading" id="reading" action="deletebook?id=${book.id} " method="post">
        				<div class="dialog-foot">
            			<div class="save"><span class="ms-reading"></span><button type="submit" class="btn btn-warning btn-sm" id="savebutton-reading">删除</button> <button type="submit" class="btn btn-success btn-sm" id="savebutton-reading">修改</button></div></div>
    					</form> --%>
    					 <a href="showmodifybook?id=${book.id}"><button class="btn btn-success btn-lg">修改</button></a>
    					<a href="deletebook?id=${book.id}"><button class="btn btn-warning btn-lg">删除</button></a>
                    </div>
                    </c:if>
                </dd>
            </dl>
                </c:forEach>
        </div>
    </article>

    <section class="sidebar">
        <div class="fenlei">
            <h2>书籍分类</h2>
            <ul class="unstyled">

           	<c:forEach items="${sessionScope.categorys}" var="category" varStatus="stat">
                <li><a href="${ctx}/showbooksbycategoryid?category_id=${category.id}"> ${category.name} </a></li>
            </c:forEach>
        </ul>
    </div>
</section>
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