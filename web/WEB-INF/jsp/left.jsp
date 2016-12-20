<%--
  Created by IntelliJ IDEA.
  User: double
  Date: 16-12-20
  Time: 下午5:14
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
            background: #aaa;
        }

        div {
            border: 1px #ddd dotted;
        }

        div h3 {
            height: 30px;
            cursor: pointer;
        }

        div h3.h {
            border-top: 1px #666 solid;
        }

        div h3 span {
            font-size: 18px;
            position: relative;
            top: 6px;
            left: 30px;
        }

        div ul.b {
            display: none;
        }

        div ul li{
            height: 30px;
            list-style: none;
        }

        div ul li a {
            position: relative;
            top: 10px;
            left: 40px;
        }

        div ul li a:link,div ul li a:visited {
            color: #333;
            text-decoration: none;
        }

        div ul li a:hover {
            color: #222;
            text-decoration: underline;
            font-weight: bold;
        }
    </style>
</head>

<body>
<div>
    <h3><span>用户管理</span></h3>
    <ul>
        <li><a href="<%=request.getContextPath() %>/user?method=addInput" target="content">添加用户</a></li>
        <li><a href="<%=request.getContextPath() %>/user?method=list" target="content">用户列表</a></li>
    </ul>
    <h3 class="h"><span>商品管理</span></h3>
    <ul class="b">
        <li><a href="#">添加用户</a></li>
        <li><a href="#">用户列表</a></li>
        <li><a href="#">用户权限</a></li>
        <li><a href="#">管理角色</a></li>
    </ul>
    <h3 class="h"><span>订单管理</span></h3>
    <ul class="b">
        <li><a href="#">添加用户</a></li>
        <li><a href="#">用户列表</a></li>
        <li><a href="#">用户权限</a></li>
        <li><a href="#">管理角色</a></li>
    </ul>
    <h3 class="h"><span>物流管理</span></h3>
    <ul class="b">
        <li><a href="#">添加用户</a></li>
        <li><a href="#">用户列表</a></li>
        <li><a href="#">用户权限</a></li>
        <li><a href="#">管理角色</a></li>
    </ul>
</div>
</body>
</html>
