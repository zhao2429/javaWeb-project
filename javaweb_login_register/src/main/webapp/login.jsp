<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">
</head>

<body>
<%
//    Cookie[] cookies = request.getCookies();
//    for (){
//
//    }
%>
<div id="loginDiv" style="height: 350px">
<%--    服务器提交地址--%>
    <form action="${pageContext.request.contextPath}/user/login" id="form">
        <h1 id="loginMsg">登录</h1>
        <div id="errorMsg">${login_msg}</div>
        <p>用户名:<input id="username" name="username" type="text" value="${cookie.username.value}"></p>

        <p>密&nbsp;&nbsp;&nbsp码:<input id="password" name="password" type="password" value="${cookie.password.value}"></p>
        <p><input id="remember" name="remember" type="checkbox" value="1">&nbsp;&nbsp;记住我</p>
        <div id="subDiv">
            <input type="submit" class="button" value="登录">
            <input type="reset" class="button" value="重置">&nbsp;&nbsp;&nbsp;
            <a href="register.jsp">没有账号？</a>
        </div>
    </form>
</div>

</body>
</html>