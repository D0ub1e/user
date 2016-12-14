<%@page import="com.hkwy.model.User"%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'list.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<%
    List<User> users = (List<User>)request.getAttribute("users");
%>
<h1 align="center">用户列表</h1>
<hr>
<table align="center" border="1" width="700px">
    <tr>
        <td>ID</td>
        <td>用户名</td>
        <td>昵称</td>
        <td>操作</td>
    </tr>
    <%
        for(User user:users) {
    %>
    <tr>
        <td><%=user.getId() %></td>
        <td><%=user.getUsername() %></td>
        <td><%=user.getNickname() %></td>
        <td>
            <a href="<%=request.getContextPath()%>/user?method=updateInput&id=<%=user.getId()%>">修改</a>
            <a href="<%=request.getContextPath()%>/user?method=delete&id=<%=user.getId()%>">删除</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>

