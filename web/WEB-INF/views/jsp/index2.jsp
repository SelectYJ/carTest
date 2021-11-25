<%--
  Created by IntelliJ IDEA.
  User: 1301808700
  Date: 2021/11/16
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
    td{
        text-align: center;
    }
</style>
<table border="1" id="tab">
    <tr>
        <th>ID</th>
        <th>车辆名称</th>
        <th>车辆价格（辆/万）</th>
        <th>剩余（辆）</th>
        <th>更新时间</th>
    </tr>
</table>
</body>
<%--<script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>--%>
<script src="../catJs/jquery.js"></script>
<script>
  $.ajax({
    url:"reToIndex2",
    data:{
      action:"jQueryAjax"
    },
    type:"GET",
    success:function (data) {
      for (let i=0;i<data.length;i++){
        let line =
            "<tr>"+
            "<td>"+data[i].carId+ "</td>" +
            "<td>"+data[i].carName+ "</td>" +
            "<td>"+data[i].carPrice+ "</td>" +
            "<td>"+data[i].carQuantity+ "</td>"+
            "<td>"+data[i].carProductionTime+ "</td>"+
            "</tr>";
        $('#tab').append(line);
      }
    },
    dataType : "json"
  })
</script>
</html>
