<%@ page import="ajax.jsp.entity.Person" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2023/5/6
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--EL表达式搜索四个域对象数据的顺序--%>
<%
    pageContext.setAttribute("key","pageContext");
    request.setAttribute("key","request");
    session.setAttribute("key","session");
    application.setAttribute("key","application");
%>
<%--当四个域对象都是一个key的时候，优先获取到范围较小的那个--%>
取到的值：${key}

<hr>
<%--    EL输出对象的属性--%>
<%
    Person person = new Person();
    person.setName("张三");
    person.setPhones(new String[]{"110","111","119"});
    List<String> city = new ArrayList<>();
    city.add("云南");
    city.add("北京");
    city.add("上海");
    person.setCitys(city);

    Map<String, Object> map = new HashMap<>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key3","value3");
    person.setMap(map);
    request.setAttribute("person",person);
%>
<%--对象需要存储在域对象中才能输出--%>
输出person对象：${person}<br>
输出person对象的name属性：${person.name} <br>
输出person对象的phones(数组)属性：${person.phones[0]}<br>
输出person对象的citys（集合）属性：${person.citys}<br>
输出person对象的citys属性中的某个元素：${person.citys[1]}<br>
输出person对象的map（集合）属性：${person.map}<br>
输出person对象的map属性中的某个属性：${person.map.key1}<br>
</body>
</html>
