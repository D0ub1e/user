<%@ page import="com.hkwy.model.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><%--
  Created by IntelliJ IDEA.
  User: double2
  Date: 2016/12/14
  Time: 下午11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>">
<style type="text/css">
    td {
        text-align: center;
    }
</style>
</head>

<body>
<%
    User user = (User)request.getAttribute("user");
%>
<h1 align="center">用户修改</h1>
<hr>
<form action="<%=request.getContextPath() %>/user?method=update" method="post">
    <!-- 隐藏表单域,该表单域不会在页面上显示,但是会随着表单一起提交 -->
    <input type="hidden" name="id" value="<%=user.getId()%>">
    <table align="center" width="400px">
        <tr>
            <td>用户名</td>
            <td><%=user.getUsername() %></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>昵称</td>
            <td><input type="text" name="nickname" value="<%=user.getNickname()%>"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="确定"><input type="reset" value="清空"></td>
        </tr>
    </table>
</form>
</body>
</html>
