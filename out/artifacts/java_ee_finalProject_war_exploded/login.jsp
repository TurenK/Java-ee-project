<%--
  Created by IntelliJ IDEA.
  User: 11877
  Date: 2017/12/25
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/user/login.do" id="loginForm" class="form-group" name="loginForm" method="post">
    <label for="userName">用户名:</label>
    <input type="text" class="form-control" id="userName" name="userName">
    <br/>
    <label for="userPass">密码:</label>
    <input type="password" class="form-control" id="userPass" name="userPass">
      <br/>
      <input id="login" name="login" type="submit" class="button" value="登录"/>
      &nbsp;&nbsp;&nbsp;&nbsp;
     </form>
  <button id="register" name="register" class="button" value="注册"
          onclick="window.location.href='${pageContext.request.contextPath}/jsp/Register.jsp'">注册</button>
  </body>
</html>
