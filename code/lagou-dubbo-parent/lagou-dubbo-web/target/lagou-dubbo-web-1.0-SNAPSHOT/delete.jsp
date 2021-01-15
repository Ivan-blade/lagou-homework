<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2021/1/15
  Time: 下午1:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete</title>
</head>
<body>

    <form>
        <p>删除角色id: <input name="uid"></p>
        <p><input type="button" id="btn" value="delete"></p>
        <p><a href="find.jsp">查询</a></p>
        <p><a href="update.jsp">修改</a></p>
    </form>
    <script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $("#btn").on("click",function(){
            $.post("delete", $("form").serialize() ,function( result ){ },"json" );
        });
    </script>

</body>
</html>
