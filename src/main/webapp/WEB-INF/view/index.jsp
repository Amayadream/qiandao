<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
    <title>首页 | 叮叮签到</title>
    <jsp:include page="include/header.jsp"/>
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
                <c:if test="${isLogin == true}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            ${user.email} <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><span class="glyphicon glyphicon-user"></span> 个人中心</a></li>
                            <li><a href="#"><span class="glyphicon glyphicon-tasks"></span> 签到任务</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#" onclick="window.location = '${ctx}/auth/logout'"><span class="glyphicon glyphicon-off"></span> 退出</a></li>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${empty isLogin}">
                    <li><a href="${ctx}/auth/login">登录</a></li>
                    <li><a href="${ctx}/auth/register">注册</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>

<div class="col-lg-2 col-lg-offset-5">
    <h1 style="text-align: center">签到<sup>alpha</sup></h1>
    <form>
        <div class="form-group">
            <label for="webId">Email address</label>
            <select class="form-control" name="webId" id="webId">
                <option>V2ex</option>
            </select>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Cookies</label>
            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-default">立即签到</button>
        <button type="button" class="btn btn-default">创建任务</button>
    </form>
</div>

</body>
</html>
