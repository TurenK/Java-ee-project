<%--
  Created by IntelliJ IDEA.
  User: 11877
  Date: 2017/12/28
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/regist.do" id="registForm" class="form-group" name="registForm" method="post">
    <label for="userName">用户名:</label>
    <input type="text" class="form-control" id="userName" name="userName">
    <br/>
    <label for="userPass">密码:</label>
    <input type="password" class="form-control" id="userPass" name="userPass">
    <br/>
    <input id="register" name="register" type="submit" class="button" value="注册"/>
    &nbsp;&nbsp;&nbsp;&nbsp;
</form>
<button id="login" name="login" class="button" value="登录" onclick="window.location.href='${pageContext.request.contextPath}/login.jsp'">登录</button>
</body>
</html>
