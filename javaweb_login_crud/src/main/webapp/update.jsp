<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2023/5/10
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改页面</title>
</head>
<body>
<h1>修改学生信息</h1>
<h1>修改页面</h1>
<%--将查询出来的原始数据显示在表单中--%>
<form action="${pageContext.request.contextPath}/update" method="post">
  <%--  因为修改数据时，底层需要id作为条件但是id又不能修改或展示，可以使用隐藏域--%>
  <input type="hidden" name="id" value="${stu.id}"><br>
  学生姓名：<input type="text" name="name" value="${stu.name}"><br>
  学生出生日期：<input type="date" name="borntime" value="${stu.borntime}"><br>
  学生性别：<input type="text" name="sex" value="${stu.sex}"><br>
  学生年级编号：<input type="text" name="grade.gradeId" value="${stu.gradeId}"><br>
  学生年级名称：<input type="text" name="grade.gradeName" value="${stu.grade.gradeName}"><br>
  <input type="submit" value="修改">
  <input type="reset" value="重置">
  <span style="color: red">${msg}</span>
</form>

</body>
</html>
