<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2022/3/29
  Time: 下午9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<!--
    1.准备表单
    2.设置表单的提交类型 method="post"
    3.设置表单类型为文件上传表单 enctype="multipart/form-data"
    4.设置文件提交的地址 action="upload"
    5.准备表单元素 1.普通表单项 type="text" 2.文件项 type="file"
    6.设置表单元素的name属性值，否则后台无法接收数据
    -->
<form method="post" action="upload" enctype="multipart/form-data">
    姓名：<input type="text" name="uname"><br/>
    文件：<input type="file" name="myfile"><br/>
    <!-- button 默认的 type 属性是 submit，做提交按钮可以不设置 type -->
    <button type="submit"> 提交 </button>
</form>
</body>
</html>
