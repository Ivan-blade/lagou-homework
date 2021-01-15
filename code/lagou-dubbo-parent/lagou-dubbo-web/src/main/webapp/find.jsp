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
    <title>select</title>
</head>
<body>
    <form>
        <p>查询角色id: <input id="uid" name="uid"></p>
        <p><input type="button" id="btn" value="select"></p>
        <p><a href="delete.jsp">删除</a></p>
        <p><a href="update.jsp">修改</a></p>
        <p><a href="index.jsp">主页</a></p>
    </form>
    <script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $("#btn").click(function(){
            $.ajax("select/"+$("#uid").val(),function(data,status){
                alert("数据: " + data + "\n状态: " + status);
            });
        });



    </script>
</body>
</html>
