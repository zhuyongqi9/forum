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
        <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/topic?method=replyByTopicId&topic_id=${param.topic_id}" method="post">


            <div class="form-group" >
                <label  class="col-sm-2 control-label">内容</label>
                <div class="col-lg-8">
                    <textarea class="form-control" name="content" placeholder="请输入内容">

                    </textarea>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn-default">发布主题</button>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    ${msg}
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
