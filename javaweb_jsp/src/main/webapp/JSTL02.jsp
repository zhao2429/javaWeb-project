<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="ajax.jsp.entity.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2023/5/8
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--遍历1-10并且输出信息
begin:设置开始的索引
end:设置结束的索引
var:表示循环的变量，也就是循环的数据
for（int i ; i<=10;i++）
--%>
<table>
    <c:forEach  begin="1" end="10" var="i">
        <tr>
            <td>${i}</td>
        </tr>
    </c:forEach>
</table>
<hr>
<%--遍历数组--%>
<%
    request.setAttribute("arr",new String[]{"111","456","789"});
%>
<%--items:表示要遍历的数据源（集合）--%>
<c:forEach items="${requestScope.arr}" var="item">
    ${item}
</c:forEach>
<hr>
<%--遍历map集合--%>
<%
    Map<String,Object> map = new HashMap<>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key3","value3");

    request.setAttribute("map",map);
//    for(Map.Entry<String,Object> entry : map.entrySet()){
//
//    }

//    for(String key:map.keySet()){
//        Object o = map.get(key);
//        System.out.println("o = " + o);
//    }
%>
<c:forEach items="${requestScope.map}" var="entry">
    <h2>${entry.key} - ${entry.value}</h2>
</c:forEach>

<br>
<%--存储10个对象的信息使用c:forEach遍历出信息--%>
<%
    List<Student> students = new ArrayList<>();
    for (int i=1;i<=10;i++){
        students.add(new Student("name"+i));
    }
    request.setAttribute("stu",students);
%>
<%--遍历--%>
<table>
    <tr>
        <td>姓名</td>
        <td>状态</td>
    </tr>
    <c:forEach items="${requestScope.stu}" var="student" varStatus="status" step="1">
        <tr>
            <td>${student.name}</td>
            <td>${status.step}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
