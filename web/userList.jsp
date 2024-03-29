<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <script src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="container-fluid">
        <form action="/list" method="get">
            账号：<input type="text" name="account" value="${account}">
            <input type="submit" value="查询">
        </form>

        <a href="/userAdd.jsp" class="btn btn-success">添加</a>

        <table class="table table-bordered text-center">
            <tr>
                <td>序号</td>
                <td>账号</td>
                <td>真实姓名</td>
                <td>年龄</td>
                <td>性别</td>
                <td>出生日期</td>
                <td>创建时间</td>
                <td>操作</td>
            </tr>

            <c:forEach var="user" items="${list}" varStatus="status">
                <tr>
                    <td>${status.index+1}</td>
                    <td>${user.account}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>
                        <c:if test="${user.sex==1}">男</c:if>
                        <c:if test="${user.sex==0}">女</c:if>
                    </td>
                    <td>
                        <fmt:parseDate var="birthDate" value="${user.birthDate}" pattern="yyyy-MM-dd"></fmt:parseDate>
                        <fmt:formatDate value="${birthDate}" pattern="yyyy年MM月dd日"></fmt:formatDate>
                    </td>
                    <td>
                        <fmt:parseDate var="createTime" value="${user.createTime}"
                                       pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
                        <fmt:formatDate value="${createTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                    </td>
                    <td>
                        <a href="/delete?id=${user.id}">删除</a>
                        <a href="/toUpdate?id=${user.id}">修改</a>
                    </td>
                </tr>
            </c:forEach>

        </table>
        <a href="/list?page=1&account=${account}" class="btn btn-primary">首页</a>
        <a href="/list?page=${(page.page-1)<=0?1:(page.page-1)}&account=${account}" class="btn btn-info">上一页</a>
        <a href="/list?page=${(page.page+1) >page.pageTotal ? page.pageTotal :(page.page+1)}&account=${account}"
           class="btn btn-info">下一页</a>
        <a href="/list?page=${page.pageTotal}&account=${account}" class="btn btn-primary">尾页</a>
        <br>
        当前页：${page.page}，总页数：${page.pageTotal},总记录数：${page.count},每页显示记录数：${page.pageSize}
    </div>
</div>
</body>
</html>
