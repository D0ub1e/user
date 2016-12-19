<%--
  Created by IntelliJ IDEA.
  User: double
  Date: 16-12-19
  Time: 下午7:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        if (window != top){
            top.location.href=location.href;
        }
    </script>
</head>
<body>
<h1 align="center">用户登录</h1>
<br><br><br><br><br><br>
<form action="<%=request.getContextPath()%>/user?method=login" method="post">
    <table align="center" border="1" width="500px">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
            <td><input type="reset" value="重输"></td>
        </tr>
    </table>
</form>

</body>
</html>
