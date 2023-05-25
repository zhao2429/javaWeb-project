<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2023/5/10
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增</title>
</head>
<body>
<h1>数据新增页面</h1>
<form action="${pageContext.request.contextPath}/addstu" method="post">
    学生姓名：<input type="text" name="name"> <br>
    学生出生日期：<input type="date" name="borntime"> <br>
    学生性别：<input type="text" name="sex"> <br>
    学生年级编号：<input type="text" name="grade.gradeId"> <br>
    学生年级名称：<input type="text" name="grade.gradeName"> <br>
    <input type="submit" value="提交">
    <input type="reset" value="重置">
    <span style="color: red">${msg}</span>
</form>
</body>
</html>
