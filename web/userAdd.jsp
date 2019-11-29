<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/add" method="get">
    账号：<input type="text" name="account" value=""><br><br>
    姓名：<input type="text" name="name" value=""><br><br>
    年龄：<input type="text" name="age" value=""><br><br>
    性别：<input type="radio" name="sex" value="1">男
    <input type="radio" name="sex" value="0">女<br><br>
    出生日期：<input type="text" name="birthDate" value=""><br><br>
    <input type="submit" value="保存">
</form>
</body>
</html>
