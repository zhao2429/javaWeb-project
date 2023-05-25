<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2023/5/6
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--使用脚本在request域中存储一个值--%>
<%
    request.setAttribute("key","这个是值");
%>
<%--输出域对象中的值--%>
表达式输出：<%= request.getAttribute("key")%><br>

<%--输出域对象中的值，，如果为null输出空字符串，不为null输出值--%>
<%--三元运算符，条件 = = 值 ？ 第一个结果 ： 第二个结果--%>
表达式输出：<%= request.getAttribute("key") ==null?"":request.getAttribute("key")%><br>

EL表达式：${key}
</body>
</html>
