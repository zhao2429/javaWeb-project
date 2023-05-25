<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2023/5/8
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>新增页面</h1>
<%--定义表单收集新增的信息--%>
<form action="${pageContext.request.contextPath}/addemp" method="post">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    年龄：<input type="number" name="age"><br>
    电话：<input type="text" name="phone"><br>
    状态：
    <input type="radio" value="1" name="status" checked>启用
    <input type="radio" value="0" name="status">禁用<br>
    <input type="submit" value="提交">
    <input type="reset" value="重置">
    <span style="color: red">${msg}</span>
</form>
</body>
</html>
