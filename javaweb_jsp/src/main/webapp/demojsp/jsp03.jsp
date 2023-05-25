<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2023/5/5
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
  List list = new ArrayList<>();
%>
<%--表达式脚本--%>
<%=12%>
<%=12.99%>
<%="我是字符串"%>
<%=list%>
<%--输出java代码存储的域对象数据--%>
<%= request.getParameter("username")%>
</body>
</html>
