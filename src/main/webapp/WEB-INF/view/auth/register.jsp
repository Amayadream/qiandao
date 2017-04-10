<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
    <title>注册 | 叮叮签到</title>
    <jsp:include page="../include/header.jsp"/>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${ctx}/index"><span class="glyphicon glyphicon-cloud"></span> 叮叮签到</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${ctx}/auth/login">登录</a></li>
                <li><a href="${ctx}/auth/register">注册</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        Amayadream <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span> 个人中心</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-tasks"></span> 签到任务</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#"><span class="glyphicon glyphicon-off"></span> 退出</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="col-lg-4 col-lg-offset-4">
    <form action="${ctx}/auth/register" method="post">
        <div class="form-group">
            <label for="email">邮箱</label>
            <input type="email" class="form-control" id="email" placeholder="请输入邮箱地址...">
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" id="password" placeholder="请输入密码...">
        </div>
        <button type="submit" class="btn btn-success">注册</button>
        <button type="button" class="btn btn-default">已有账号?</button>
    </form>
</div>

</body>
</html>
