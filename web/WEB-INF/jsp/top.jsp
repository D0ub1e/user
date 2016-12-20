<%@ page import="com.hkwy.model.User" %><%--
  Created by IntelliJ IDEA.
  User: double
  Date: 16-12-20
  Time: 下午5:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        * {
            margin: 0px;
            padding: 0px;
            font-size: 12px;
        }

        #up {
            height: 80px;
            background: #333;
        }

        #up span {
            font-size: 40px;
            position: relative;
            top: 14px;
            left: 50px;
            color: #fff;
        }

        #down {
            height: 20px;
            background: #aaa;
            text-align: right;
        }

        #down span {
            position: relative;
            top: 4px;
            right: 50px;
            color: #111;
        }

        #down span a:link,#down span a:VISITED {
            color: #fff;
            text-decoration: none;
            font-weight: bold;
        }

        #down span a:hover {
            color: #ddd;
            text-decoration: underline;
            font-weight: bold;
        }
    </style>
</head>

<body>
<%
    User loginUser = (User)session.getAttribute("loginUser");
%>
<div id="up">
    <span>欢迎登录后台管理系统</span>
</div>
<div id="down">
    <span>欢迎[<a href="#"><%=loginUser.getNickname() %></a>]<a href="<%=request.getContextPath()%>/user?method=logout" target="_top">退出</a>&nbsp;&nbsp;2016年12月6日</span>
</div>
</body>
</html>
