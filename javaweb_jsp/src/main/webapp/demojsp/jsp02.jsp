<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2023/5/5
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
jsp头部配置指令：
contentType属性：表示jsp返回的数据是什么相当于response.setContentType("text/html;charset=UTF-8");
language属性：表示jsp翻译后是什么语言的文件，暂时只支持java
isELIgnored:是否忽略识别el表达式
import属性：跟java源码一样适用于导包
errorpage：设置当前jsp页面出错自动跳转到其他的页面；

--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--声明脚本--%>
<%!
   //1:声明类的属性
   private  Integer id;
   private  String name;
   private static Map<String,Object> map;
%>
<%--声明静态代码块--%>
<%!
    static {
        map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
    }
%>
<%--3：声明方法--%>
<%!
    public int abc(){
     return  999;
    }
%>
<%--4：声明内部类--%>
<%!
    public static Class A{
        private Integer id = 12;
        private String abc = "abc";
}
%>
</body>
</html>
