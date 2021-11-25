<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="zh_CN">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
    <script type="text/javascript" src="../catJs/vue.js"></script>
</head>
<style>
    html,body{
        margin: 0;
        padding: 0;
        width: 100%;
        height: 100%;
    }
</style>
<body>
<link rel="stylesheet" href="../catCss/main.css">
<link rel="stylesheet" href="../catCss/topDiv.css">
<link rel="stylesheet" href="../catCss/leftDiv.css">
<link rel="stylesheet" href="../catCss/rightDiv.css">
<div class="onDiv" id="app">
  <div class="onDiv-top">
    <div>
        <a style="float: left" @click="deleteUser()" :href="booLer?'../html/deleteUser':'../html/hello'">注销账号</a>
        <a style="float: left" @click="deleteUser()" :href="booLer?'../':'../html/hello'">退出登录</a>
    </div>
  </div>
  <div class="onDiv-left">
    <div>
      <div class="photo">
        <img class="img" src="" alt="">
      </div>
      <p>${msg}</p>
    </div>
    <ul>
      <li class="oneLi">
        <a class="oneA" href="javascript:;" >后台首页</a>
      </li>
      <li class="sLi" v-for="(item,index) in spAm" :class="index==su?liTop:''" :style="{height:(index==su?ht+'px':'')}">
<!--        <a :href="spAm2[index]" @click="liClick(index)" target="aIframe">-->
        <a class="sA" @click="liClick(index)">
          {{item}}
          <span :class="index==su?spanTop:spanBom" :style="{top:(index==su?tP+'%':'')}"></span>
        </a>
      </li>
      <div v-for="(i,index) in count" class="divLi" :class="index!=su?disDiv:''">
          <li class="liA" :class="(bkColor==(index+''+0))?'bacColor':''" @click="backColor((index+''+0))" :style="{position:'absolute',top:298+(i*50)+'px'}">
            <a :href="spAm2[index][0]" @click="aClick(index)" target="aIframe">{{spAm3[index][0]}}</a>
          </li>
          <li class="liA" :class="(bkColor==(index+''+1))?'bacColor':''" @click="backColor((index+''+1))" :style="{position:'absolute',top:346+(i*50)+'px'}">
            <a :href="spAm2[index][1]" @click="aClick(index+1)" target="aIframe" >{{spAm3[index][1]}}</a>
          </li>
      </div>
    </ul>
  </div>
  <div class="onDiv-right">
    <ul>
<%--      <li>后台首页</li>--%>
      <li>{{lMain}}</li>
    </ul>
<%--    <div :style="{display:fal?'block':'none'}">后台首页</div>--%>
    <iframe frameborder="no" :style="{display:(fal?'none':'block')}" name="aIframe"></iframe>
      <div :style="{display:(upDa?'none':'block')}" class="upData">
          <form action="upDataIndex1" onsubmit="return onSubIf()" method="post">
              <table border="1">
                  <tr>
                      <td><input type="hidden" name="us_id" id="us_id" value="${msg1}" ></td>
                  </tr>
                  <tr>
                      <td>姓名</td>
                      <td><input type="text" name="us_username" id="us_username"></td>
                  </tr>
                  <tr>
                      <td>密码</td>
                      <td><input type="text" name="us_pass" id="us_pass"></td>
                  </tr>
                  <tr>
                      <td>邮箱</td>
                      <td><input type="text" name="us_email" id="us_email"></td>
                  </tr>
                  <tr>
                      <td>电话</td>
                      <td><input type="text" name="us_photo" id="us_photo"></td>
                  </tr>
                  <tr>
                      <td colspan="2">
                          <button type="submit">修改个人信息</button>
                      </td>
                  </tr>
              </table>
          </form>
      </div>
  </div>
</div>
<script type="text/javascript" src="../catJs/fire.js"></script>
<script type="text/javascript" src="../catJs/jquery.js"></script>
<script type="text/javascript" src="../catJs/mainJs.js"></script>
<script>
  function onSubIf(){
    if(
        ($('#us_username').val()!="")&& ($('#us_pass').val()!="") &&
        ($('#us_email').val()!="")&& ($('#us_photo').val()!=""))
    {
      return true;
    }else {
      return false;
    }
  }
  $('.img').prop('src','${msg2}');
  app.ifUserName(${msg});
</script>
</body>
</html>