<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/7/22
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>光明顶开发者论坛</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <ul class="nav nav-tabs">
        <c:forEach items="${categoryList}" var="category">
            <li>
                <a href="${pageContext.request.contextPath}/topic?message=list&c_id=${categoryList}">${category.name}</a>
            </li>
        </c:forEach>
    </ul>
</div>

<div style="margin-top: 100px" >
    <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/user?method=login" method="post">
        <div class="form-group" >
            <label  class="col-sm-2 control-label">手机号</label>
            <div class="col-lg-3">
                <input type="text" class="form-control" name="phone" placeholder="手机号">
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-2 control-label">密码</label>
            <div class="col-lg-3">
                <input type="password" class="form-control" name="pwd" placeholder="密码">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn-default">登录</button>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                ${msg}
            </div>
        </div>
    </form>
</div>

</body>
</body>
</html>
