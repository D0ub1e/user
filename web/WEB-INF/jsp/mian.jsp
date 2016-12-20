<%--
  Created by IntelliJ IDEA.
  User: double
  Date: 16-12-20
  Time: 下午5:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<frameset rows="100,*">
    <frame src="<%=request.getContextPath() %>/user?method=top" scrolling="no">
    <frameset cols="250,*">
        <frame src="<%=request.getContextPath() %>/user?method=left" noresize="noresize">
        <frame src="<%=request.getContextPath() %>/user?method=welcome" noresize="noresize" name="content">
    </frameset>
</frameset>

</body>
</html>
