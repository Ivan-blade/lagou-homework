<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>账户列表</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
  <div class="row">
      <h3 style="text-align: center">员工信息列表</h3>
      <div class="col-lg-2"></div>
      <div class="col-lg-8">

          <form>
          <table border="1" class="table table-bordered table-hover">
              <tr class="success">
                  <th>员工id</th>
                  <th>员工姓名</th>
                  <th>员工部门id</th>
                  <th>岗位</th>
                  <th>入职日期</th>
                  <th>联系方式</th>
                  <th>操作</th>
              </tr>

              <c:forEach items="${list}" var="employee">

              <tr>
                  <td>${employee.emp_id}</td>
                  <td>${employee.emp_name}</td>
                  <td>${employee.dept_id}</td>
                  <td>${employee.job_name}</td>
                  <td>${employee.join_date}</td>
                  <td>${employee.telephone}</td>
                  <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/employee/findById?emp_id=${employee.emp_id}">修改</a>&nbsp;</td>
              </tr>
              </c:forEach>


              <tr>
                  <td colspan="9" align="center">
                      <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加员工</a>
                  </td>
              </tr>
          </table>
      </div>
      <div class="col-lg-2"></div>
  </div>
</div>
</body>


</html>

