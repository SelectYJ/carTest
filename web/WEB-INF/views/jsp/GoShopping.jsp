<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<link rel="stylesheet" href="../bts/css/bootstrap.min.css" />
<style>
  html,body{
    background-color: #537272;
  }
  #search{
    width: 600px;
    margin: 30px auto;
  }
  #shopping{
    width: 1200px;
    margin: 20px auto;
  }
  span{
    text-align: center;
  }
  #ull{
    height: 310px;
  }
  #imgIe{
    width: 268px;
    height: 268px;
  }
</style>
<body>
  <div id="search">
    <div class="input-group">
      <input type="text" class="form-control" id="selectCar" />
      <span class="input-group-addon">
        <a href="#">
          <i class="glyphicon glyphicon-search">
            <button onclick="selectC()">搜索</button>
          </i>
        </a>
      </span>
    </div>
  </div>
  <div class="center-block" id="shopping">
    <ul class="list-group" id="ull">
    </ul>
    <div id="pagination"></div>
    <button id="re" onclick="re()">返回</button>
  </div>
  <script src="../catJs/jquery.js"></script>
  <script src="../catJs/vue.js"></script>
  <script src="../catJs/Pagination.js"></script>
  <script src="../catJs/GoShopping.js"></script>
</body>
</html>