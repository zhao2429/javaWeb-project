<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link href="${pageContext.request.contextPath}/css/register.css" rel="stylesheet">
</head>
<body>

<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="login.jsp">登录</a>
    </div>
    <form id="reg-form" action="${pageContext.request.contextPath}/user/reg" method="post">

        <table>
            <tr>
                <td>用户名</td>
                <td class="inputs" onblur="sendAjax()">
                    <input name="username" type="text" id="username">
                    <br>
                    <span id="username_err" class="err_msg" ></span>
                    <br>
                    <span id="context" style="color: red"></span>
                </td>

            </tr>

            <tr>
                <td>密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">
                    <br>
                    <span id="password_err" class="err_msg" ></span>
                </td>
            </tr>


            <tr>
                <td>验证码</td>
                <td class="inputs">
                    <input name="checkCode" type="text" id="checkCode"/>
                    <img id="img" src="${pageContext.request.contextPath}/code.jpg"/>
                    <a href="#" id="changeImg">看不清？</a>
                    <br>
                    <span style="color: red">${yzm_msg}</span>
                </td>
            </tr>

        </table>

        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>

</div>
</body>
<script>
    document.querySelector("#changeImg").onclick=function (event){
        event.preventDefault();//阻止超链接的默认行为
        //切换图片；加上一个时间控制是的图片响应完成
        document.querySelector("#img").src="${pageContext.request.contextPath}/code.jpg?date="+new Date();
    }


    //用户名密码验证

    window.onload = function() {
        //当点击提交时触发表单验证
        document.querySelector("#reg-form").onsubmit = function () {
            //返回值 false不提交  ，TRUE提交
            //当用户名，密码，邮箱，验证通过，提交TRUE
            return checkUserName && checkPassWord;
        }
        //1：获取元素
        var username = document.querySelector("#username");
        var password = document.querySelector("#password");

        //为用户名 ，密码。 绑定失去光标事件
        username.onblur = checkUserName;
        password.onblur = checkPassWord;

        function checkUserName() {
                //1：表达式
                var name= /^[\u4e00-\u9fa5]{2,6}$/;
                var usernameval = username.value.trim();
                //定义用户名需要满足的正则表达式
                var flag = name.test(usernameval);  //通过返回TRUE ，不通过返回FALSE
                var msg = document.querySelector("#username_err");
                //判断用户名是否合理
                if (flag) {
                    //符合条件
                    msg.innerHTML = "用户名验证通过";
                    msg.style.color = "green";
                } else {
                    //不符合条件
                    msg.innerHTML = "用户名必须2到6位汉字";
                    msg.style.color = "red";
                }
                return flag;

        }


        //验证密码的函数
        function checkPassWord() {

                var pwd = /^(?![a-zA-Z]+$)(?!\d+$)(?![^\da-zA-Z\s]+$).{3,9}$/;
                var passwordval = password.value.trim();
                var flag = pwd.test(passwordval);
                var msg = document.querySelector("#password_err");
                if (flag) {
                    //符合条件
                    msg.innerHTML = "密码验证通过";
                    msg.style.color = "green";

                } else {
                    //不符合条件
                    msg.innerHTML = "密码最少3位，由字母、数字、特殊字符，任意2种组成，3-9位";
                    msg.style.color = "red";
                }
                return flag;


        }

        username.onblur = function (){

            var xhttp;
            if (window.XMLHttpRequest){
                //新的浏览器
                xhttp = new XMLHttpRequest();
            }else {
                //老的浏览器
                xhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            //2:设置请求信息,参数：请求方式，请求路径，是否异步
            //xhttp.open("GET","http://localhost:8080/javaweb_login_register/user/exists?username="+eval(document.getElementById('username')).value,true);
            xhttp.open("GET","http://localhost:8080/javaweb_login_register/user/exists?username="+this.value);
            //3:发送请求到服务器中
            xhttp.send();
            //4：处理请求后的响应内容
            //4.1:判断响应的状态码和响应的状态是否是成功执行的
            xhttp.onreadystatechange = function (){
                //判断状态码是200 且状态返回4，表示整个请求就绪
                if(xhttp.readyState == 4 && xhttp.status ==200){

                    //document.querySelector("#context").innerHTML = xhttp.responseText;
                    //响应成功后需要判断是否在数据库中存在该username
                    // if(this.responseText == "true"){
                    //     //存在则提示用户名已存在
                    //     document.querySelector("#context").innerHTML ="用户名已经存在，请重新输入";
                    // }else {
                    //     //不存在则注册
                    //     document.querySelector("#context").innerHTML ="用户名可以进行注册！";
                    // }
                }
                    document.querySelector("#context").innerHTML = xhttp.responseText;
            }

        }

    }


</script>
</html>