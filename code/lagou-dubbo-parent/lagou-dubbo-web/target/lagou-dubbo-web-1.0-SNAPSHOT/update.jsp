<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2021/1/15
  Time: 下午1:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
    <form>
        <p>修改角色id:(必填) <input name="uid"></p>
        <p>username: <input name="username"></p>
        <p>password: <input name="password"></p>
        <p>phone: <input name="phone"></p>
        <p><input type="button" id="btn" value="update"></p>
        <p><a href="find.jsp">查询</a></p>
        <p><a href="delete.jsp.jsp">删除</a></p>
    </form>
    <script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $("#btn").on("click",function(){
            $.post("update", $("form").serialize() ,function( result ){ },"json" );
        });
    </script>
</body>
</html>
