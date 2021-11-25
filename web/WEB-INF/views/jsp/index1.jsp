<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<style>
  td{
    text-align: center;
  }
</style>
<table border="1">
  <tr>
    <th>ID</th>
    <th>姓名</th>
    <th>密码</th>
    <th>邮箱</th>
    <th>电话</th>
  </tr>
  <tr id="tr"></tr>
</table>
</body>
<%--<script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>--%>
<script src="../catJs/jquery.js"></script>
<script>
    $.ajax({
      url:"reToIndex1",
      data:{
        action:"jQueryAjax"
      },
      type:"GET",
      success:function (data) {
        let line =
                "<td>"+data.userId+ "</td>" +
                "<td>"+data.userName+ "</td>" +
                "<td>"+data.userPass+ "</td>"+
                "<td>"+data.userEmail+ "</td>"+
                "<td>"+data.userPhoto+ "</td>";
        $('#tr').append(line);
        $('#us_id').val(data.userId);
        // alert(" 服务器返回的数据是： " + data.userId);
        // var jsonObj = JSON.parse(data.userId);
        // console.log(jsonObj);
        // $("#msg").html(" 编号：" + data.id + " , 姓名：" + data.name);
      },
      dataType : "json"
  })
</script>
</html>