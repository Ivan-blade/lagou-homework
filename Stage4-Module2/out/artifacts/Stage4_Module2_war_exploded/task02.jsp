<%@ page import="com.lagou.demo03.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lagou.demo03.bean.User" %>
<%@ page import="com.lagou.demo03.bean.StuClass" %>
<%@ page contentType="text/html; charset=utf-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ivan</title>
    <link rel="stylesheet" href="./public/css/bootstrap.min.css">
    <link rel="stylesheet" href="./public/css/common.css">
    <script src="./public/js/jquery-1.9.1.min.js"></script>
    <script src="./public/js/bootstrap.min.js"></script>
    <style>
        .first{
            width: 50%;
            margin: 0 auto;
        }
        .first > button {
            margin-right: 5px;
        }
        .first > input {
            margin-right: 5px;
        }
    </style>
    <script>

        // 判断勾选数量，只有勾选数量等于1才允许操作
        function edit() {
            let list = $("input[type='checkbox']:checked")
            if(list.length != 1) {
                window.alert("由于勾选数量不为一，自动跳转用户添加功能！")
            } else {
                showUpdateForm(list[0].value)
            }
        }

        // 更新时回显方法
        function showUpdateForm(id){

            // 获取所有行数据（只有表示数据的行才会加上.data的样式，别问为什么不用id，因为id唯一，不能加给多个标签）
            let $base = $(".data")

            // 吐了，不能用filter，遍历到id对应的数据，将这组数据复制给模态框
            for(let i = 0; i < $base.length; i++) {
                if($base[i].children[1].textContent === id) {
                    $("#id").val($base[i].children[1].textContent)
                    $("#name").val($base[i].children[2].textContent)
                    $("#level").val($base[i].children[3].textContent)
                    $("#masterName").val($base[i].children[4].textContent)
                    $("#location").val($base[i].children[5].textContent)
                    $("#note").val($base[i].children[6].textContent)
                }
            }
        }

        // 清空此模态框中的数据
        function clearIngo(){
            $("#name").val("")
            $("#level").val("")
            $("#masterName").val("")
            $("#location").val("")
            $("#note").val("")
        }
        // 关闭窗口的方法
        function close(){
            // 关闭窗口
            $('#myModal').modal('hide');
            // 清空此div中的数据
            clearPerson();
        }


    </script>
</head>
<body>
    <div class="flex-row first">

        <button class="btn btn-primary"><a href="task.jsp">切换视图</a></button>
        <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">新增</button>

        <button class='btn btn-primary' onclick="edit()"><span data-toggle='modal' data-target='#myModal'>选中序号编辑</span></button>
        <form action="/Stage4_Module2/classSelectAll" method="get" style="margin-right: 20px;">
            <input class="btn btn-primary" type="submit" value="查询全部">
        </form>
        <form action="/Stage4_Module2/classSelectById" method="get" style="margin-right: 20px;">
            <input class="btn btn-primary" type="submit" value="查询">
            <input style="margin-left: 5px;" type="text" name="id" placeholder="按id查询" required>
        </form>
        <form action="/Stage4_Module2/classDelete" method="get">
            <input class="btn btn-primary" type="submit" value="删除">
            <input style="margin-left: 5px;" type="text" name="id" placeholder="按id删除" required>
        </form>
    </div>
    <!-- 显示列表的table -->
    <div>
        <%--  渲染初始化渲染数据，每次数据变更后台都会更新list值  --%>
        <%
            List<StuClass> list = (List<StuClass>) request.getAttribute("list");
        %>

        <table class="table table-hover" id="tb1">
            <tr class='info'><td>序号</td><td>工号</td><td>班级名</td><td>年级</td><td>班主任名</td><td>地址</td><td>班级口号</td></tr>
            <%
                if(list != null) {
                for(int i = 0; i < list.size(); i++) {
                    String str = "<tr class='data'><td><input type='checkbox' value='"+ list.get(i).getId() +"'>"
                            +"</td><td>"+list.get(i).getId()
                            +"</td><td>"+list.get(i).getName()
                            +"</td><td>"+list.get(i).getLevel()
                            +"</td><td>"+list.get(i).getMasterName()
                            +"</td><td>"+list.get(i).getLocation()
                            +"</td><td>"+list.get(i).getNote()
                            +"</tr>";
            %>
                <%= str %>
            <%
                    }
                }
            %>
        </table>
    </div>
    <!-- 添加用户信息的  模态框 -->
    <div class="modal fade" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- 模态框头部 -->
                <div class="modal-header">
                    <h4 class="modal-title">添加班级信息</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- 模态框主体 -->
                <div class="modal-body">
                    <form action="/Stage4_Module2/classInsert" method="post">
                        <input id="id" name="id" hidden="hidden" />
                        <!--required="required" 提交前必须填写-->
                        请输入班级姓名：<input class="form-control" id="name" name="name" type="text" /><br />
                        请输入班级等级：
                        <select class="form-control" id="level" name="level">
                            <option value="">--请选择--</option>
                            <option value="大一">大一</option>
                            <option value="大二">大二</option>
                            <option value="大三">大三</option>
                            <option value="大四">大四</option>
                        </select><br />
                        请输入班主任名：<input class="form-control" id="masterName" name="masterName" type="text" /><br />
                        请输入班级地址：<input class="form-control" id="location" name="location" required="required" /><br />
                        请输入班级口号：<input class="form-control" id="note" name="note" type="text" ><br />
                        <button class="btn btn-success btn-lg" type="submit">保存</button>
                        <button type="button" class="btn btn-danger btn-lg" data-dismiss="modal" onclick="clearInfo()">关闭</button>
                    </form>
                </div>

            </div>
        </div>
    </div>
</body>
</html>