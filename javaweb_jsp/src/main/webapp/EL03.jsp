<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2023/5/6
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  pageContext.setAttribute("key","pageContext");
  request.setAttribute("key","request");
  session.setAttribute("key","session");
  application.setAttribute("key","application");
%>

${pageScope.key}
${requestScope.key}
${sessionScope.key}
${applicationScope.key}

<%--pageContext，可以获取内置对象，通过内置对象可以获取很多信息--%>
${pageContext.request.serverName}//主机名
${pageContext.request.serverPort}//端口号
${pageContext.request.contextPath}//项目名或者项目路径
<a href="${pageContext.request.contextPath}"></a>
</body>
</html>
