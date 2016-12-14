<%--
  Created by IntelliJ IDEA.
  User: double2
  Date: 2016/12/14
  Time: 下午11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>添加界面</title>
    <style type="text/css">
        td{
            text-align: center;
        }
    </style>
</head>
<body>
<h1 align="center">用户添加</h1>
<hr>
<form action="<%= request.getContextPath() %>/user?method=add" method =post >
    <table align="center" width="400px">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>昵称</td>
            <td><input type="text" name="nickname"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="确定">
            <input type="reset" value="清空">
            </td>
        </tr>
    </table>


</form>

</body>
</html>
