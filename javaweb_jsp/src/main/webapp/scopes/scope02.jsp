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
<h1>scope02页面</h1>
<%--使用四大域对象，分别往里面存值--%>

pageContext的值为：<%=pageContext.getAttribute("key")%>
request的值为：<%=request.getAttribute("key")%>
session的值为：<%=session.getAttribute("key")%>
application的值为：<%=application.getAttribute("key")%>
</body>
</html>
