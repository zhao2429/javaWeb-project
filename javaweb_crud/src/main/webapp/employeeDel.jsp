<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2023/5/8
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>修改页面</h1>
<%--将查询出来的原始数据显示在表单中--%>
<form action="${pageContext.request.contextPath}/updateEmployee" method="post">
<%--  因为修改数据时，底层需要id作为条件但是id又不能修改或展示，可以使用隐藏域--%>
  <input type="hidden" name="id" value="${employee.id}"><br>
  用户名：<input type="text" name="username" value="${employee.userName}"><br>
  密码：<input type="password" name="password" value="${employee.passWord}"><br>
  年龄：<input type="number" name="age" value="${employee.age}"><br>
  电话：<input type="text" name="phone" value="${employee.phone}"><br>
<%--  根据状态来显示不同的内容--%>
  状态：
  <c:if test="${employee.status == 1}">
  <input type="radio" value="1" name="status" checked>启用
  <input type="radio" value="0" name="status">禁用<br>
  </c:if>
  <c:if test="${employee.status == 0}">
    <input type="radio" value="1" name="status" >启用
    <input type="radio" value="0" name="status" checked>禁用<br>
  </c:if>



  <input type="submit" value="修改">
  <input type="reset" value="重置">
  <span style="color: red">${msg}</span>
</form>
</body>
</html>
