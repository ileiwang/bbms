<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户登录</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="author" content="图书借阅管理平台">
    <meta name="description" content="图书借阅管理平台，是一个专注于图书借阅的平台">
    <meta name="keywords" content="读书,阅读,小说,文学">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="js/jquery-1.11.3.min.js"></script>   
    <link rel="stylesheet" href="css/bootstrap.min.css">  
    <link rel="stylesheet" href="css/uslogin.css">
</head>
<body>
    <header class="header">
        <a href="${ctx}"><div class="bg"></div></a>
    </header>
    <section id="mainSection" class="content">
        <div class="login-wrap">
            <div class="w">
                <div class="login-form">
                    <div class="login-box">
                        <div class="mt">
                            <h1>用户登录</h1>
                            <div class="extra-r">
                                <div class="regist-link">
                                    <a href="${ctx}/register?flag=1">用户注册</a>
                                </div>
                            </div>
                        </div>
                        <div id="checkAlert">
                            <div class="u-tips u-tips-err">
                                <span></span>
                            </div>
                        </div>
                        <form id="login" name="login" action="${ctx}/login" method="post">
                            <div class="mc">
                                <div class="m-ipt">
                                    <div class="u-ipt">
                                        <div class="iptctn">
                                            <input class="form-control" placeholder="帐号" name="num" id="num" value="" type="text">
                                        </div>
                                    </div>
                                </div>
                                <div class="m-ipt">
                                    <div class="u-ipt">
                                        <div class="iptctn">
                                            <input class="form-control" placeholder="密码" name="password" id="password" value="" type="password">
                                        </div>
                                    </div>
                                </div>


                                <div class="m-ipt">
                                    <div class="u-ipt">
                                        <div class="iptctn">
                                            <select name="type" id="type" class="form-control input-lg" placeholder="选择类型">
                                                <option value="student">学生</option>
                                                <option value="admin">管理员</option>
                                            </select> 
                                        </div>
                                    </div>
                                </div>
                                
                                  <div class="m-ipt">
                                    <div class="u-ipt">                              
                                        <div class="iptctn">
                                            <input class="form-control" placeholder="请输入正确结果：${requestScope.numa}+${requestScope.numb}=?" name="myresult" id="myresult" value="" type="text">
                                        </div>
                                    </div>
                                </div>
                                
                                <input type="hidden" name="result" value="${requestScope.result}">
                                
                                
                                <button type="submit" class="btn btn-success btn-lg">登录</button>
                                &nbsp;&nbsp;
                                <button type="reset" class="btn btn-warning btn-lg">重置</button>
                            </div>
                            <br>
                            <font color="red">${requestScope.message}</font>
                        </form>
                    </div>
                    <div class="blank"></div>
                    <div class="loginLinks">
                        <a href="${ctx}/forgetpasswd">忘记密码？</a>
                    </div>
                </div>
            </div>
            <div class="login-banner uslogin-color"></div>
            <div class="w">
                <div id="banner-bg" class="i-inner uslogin-banner"></div>
            </div>
        </div>
    </section>
    <footer class="footer">图书借阅管理系统</footer>
</body>
</html>