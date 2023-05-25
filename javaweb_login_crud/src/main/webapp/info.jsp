<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2023/5/9
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>学生信息展示页面</h1>
<center>
  <table border="1" cellpadding="1" cellspacing="0" width="900px" style="text-align: center">
    <tr>
      <td>学生id</td>
      <td>学生姓名</td>
      <td>学生年龄</td>
      <td>学生性别</td>
      <td>学生年级编号</td>
      <td>学生年级名称</td>
      <td>操作</td>
    </tr>
    <%--  取出查询集合后的数据--%>
    <c:forEach items="${requestScope.student}" var="emp">
      <tr>
        <td>${emp.id}</td>
        <td>${emp.name}</td>
        <td>${emp.borntime}</td>
        <td>${emp.sex}</td>
        <td>${emp.grade.gradeId}</td>
        <td>${emp.grade.gradeName}</td>
        <td>
            <%--   点击编辑需要根据id查询原始数据   --%>
            <%--      <a href="${pageContext.request.contextPath}/selectById?id=${emp.id}">编辑</a>--%>
          <a href="#" onclick="update(${emp.id}); return false;" style="text-decoration-line: none">编辑</a>

            <%--      点击删除时，应该携带id请求servlet然后删除数据--%>
            <%--      <a href="${pageContext.request.contextPath}/deletaById?id=${emp.id}">删除</a>--%>
          <a href="#" onclick="del(${emp.id}); return false;" style="text-decoration-line: none">删除</a>
            <%--
            return false：为什么要写这个呢？因为在“删除”这个功能中，有两个超链接：一个是a href="#"，
            还要一个是onclick在调用js脚本时写的一个超链接${pageContext.request.contextPath}/deletaById?id。
            重点来了！！！！虽然onclick执行的优先级大于href，但是在经过我多次实践之后，执行完onclick后，
            还是会去执行href的事件。因此，为了只执行到onclick的事件，加上return false以后，
            就是在执行完当前事件后，下一个事件将不触发。
            --%>
        </td>
      </tr>
    </c:forEach>
  </table>
</center>
<a href="add.jsp">点击新增数据</a>
</body>
<script type="text/javascript">
  function  del(id){
    var flag = confirm("请再次确认是否删除！")
    if(flag){
      window.location.href="${pageContext.request.contextPath}/delete?id="+id;
      //   window.location.href=“URL路径”：从当前页面跳转到指定的URL中，这写的是Servlet
    }
  }
  function  update(id){
    var flag = confirm("请再次确认是否进行编辑！")
    if(flag){
      window.location.href="${pageContext.request.contextPath}/selectById?id="+id;
      //   window.location.href=“URL路径”：从当前页面跳转到指定的URL中，这写的是Servlet
    }
  }
</script>
</html>
