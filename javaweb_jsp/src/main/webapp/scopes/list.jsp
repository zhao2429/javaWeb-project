<%@ page import="java.util.List" %>
<%@ page import="ajax.jsp.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2023/5/5
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>学生信息</h1>
<%--request的值为：<%=request.getAttribute("students").toString()%> <br>--%>

<%
    List<Student> students = (List<Student>) request.getAttribute("students");
%>
<table>
    <tr>
        <td>姓名：</td>
        <td>操作</td>
    </tr>
<%--    遍历输出集合--%>
    <% for(Student stu : students){ %>
    <tr>
        <td><%= stu.getName()%></td>
        <td>
            <a href="#">删除</a>
            <a href="#">修改</a>
        </td>
    </tr>
    <%}%>
</table>
</body>
</html>
