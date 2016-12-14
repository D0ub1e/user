<%@ page import="java.util.List" %>
<%@ page import="com.hkwy.model.User" %><%--
  Created by IntelliJ IDEA.
  User: double
  Date: 16-12-14
  Time: 下午5:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% 
    String path = request.getAttribute();

%>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<%
    List<User> users = (List<User>)request.getA
%>
<h1 align="cennter">
    用户代表
</h1>
    <table align="center" border="1" width="700px">
        <tr>
            <td>ID</td>
            <td>用户名</td>
            <td>昵称</td>
            <td>操作</td>
        </tr>
        <%
            for (User user:users){
        %>
        <tr>
            <td><%= user.getId()%></td>
            <td><%= user.getUsername()%>></td>
            <td><%= user.getNickname()%></td>
            <td>
                <a href="<%%>">修改</a>
                <a href="<%%>">删除</a>
            </td>
        </tr>
        <%
            }
        %>

    </table>

</body>
</html>
