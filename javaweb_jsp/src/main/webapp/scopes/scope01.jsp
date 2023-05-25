<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2023/5/5
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>scope01页面</h1>
<%--使用四大域对象，分别往里面存值--%>
<%
    pageContext.setAttribute("key","pageContext");
    request.setAttribute("key","request");
    session.setAttribute("key","session");
    application.setAttribute("key","application");
%>
pageContext的值为：<%=pageContext.getAttribute("key")%> <br>
request的值为：<%=request.getAttribute("key")%> <br>
session的值为：<%=session.getAttribute("key")%> <br>
application的值为：<%=application.getAttribute("key")%> <br>


<% request.getRequestDispatcher("/scope02.jsp").forward(request,response);%>


<%--访问一个servlet；listservlet  在servlet中准备好10个学生的信息；存储到request域对象中，返回到jsp页面上读取展示出来--%>
</body>
</html>
