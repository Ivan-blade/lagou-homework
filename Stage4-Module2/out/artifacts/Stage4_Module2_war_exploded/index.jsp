<%@ page import="com.lagou.demo03.bean.Student" %><%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页面</title>
</head>
<body>
<%
    request.getRequestDispatcher("task.jsp").forward(request,response);
%>
</body>
</html>
