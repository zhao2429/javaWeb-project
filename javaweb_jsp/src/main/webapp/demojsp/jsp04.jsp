<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2023/5/5
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        h1{
            color: red;
        }
    </style>
</head>
<body>
<%--定义一个变量age  判断age的值，如果大于18用h1输出成年，否则输出未成年，要求红色字体--%>
<%
    int age = 16;
    if (age>=18){
%>
        <h1>成年了</h1>
<%
    }else {
%>
       <h1>未成年</h1>
<% }  %>

<%--使用for循环输出一个表格，表格中列输出是第几行第几列--%>
<table border="1">
<% for (int i = 0 ; i <10 ;i++ ){ %>
    <tr>
    <% for (int j = 0 ; j <10 ;j++ ){ %>
        <td><p>我是第<%= i+1%>行</p><p>我是第<%= j+1%>列</p></td>
     <%
        }
     %>
    </tr>
<%
    }
%>

</table>
<%--像servlet获取值--%>
<%
    String username = request.getParameter("username");
    System.out.println("username = " + username);
%>
<!--html注释-->
<%--jsp注释--%>
//单行注释
/*多行注释*/
/**文档注释*/


</body>
</html>
