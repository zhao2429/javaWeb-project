<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2023/5/6
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--1：if判断
test 表示判断条件，值为el表达式
--%>
<c:if test="${99 ==99}">
    <h1>您好</h1>
</c:if>

<c:if test="${99 ==100}">
    <h1>您不好</h1>
</c:if>


<hr>
<%--获取servlet传过来的数据--%>
<c:if test="${age >=18}">
    <h1>成年了</h1>
</c:if>

<c:if test="${age < 18}">
    <h1>未成年</h1>
</c:if>

</body>
</html>
