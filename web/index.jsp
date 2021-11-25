<%--
  Created by IntelliJ IDEA.
  User: 1301808700
  Date: 2021/11/13
  Time: 1:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<link rel="stylesheet" href="catCss/index.css">
<div id="big">
    <img src="img/2.jpg">
    <div class="medium_div">
        <div class="medium_div_1">
            <div class="small_left_div">
                <button class="left_button" @click="updAFl()" :style="{display:(fl?'none':'block')}">登录</button>
                <form class="left_form" action="html/hello"
                      :style="{display:(!fl?'none':'block')}"
                      onsubmit="return loginIf()"
                      method="post">
                    <table>
                        <tr>
                            <td><h2>登&nbsp;&nbsp;录</h2></td>
                        </tr>
                        <tr>
                            <td><input type="text" placeholder="  用户名" title="用户名" id="username" name="username"></td>
                        </tr>
                        <tr>
                            <td><input type="password" placeholder="  密码" title="密码" id="password" name="password"></td>
                        </tr>
                        <tr>
                            <td>
                                <img onclick="reYzmImg()" class="img_yzm" src="img/yzm.png">
                                <input type="text" placeholder="验证码" title="验证码" style="width: 100px;height: 30px;float: left;margin-left: 68px">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <span style="display: none;color: red;" id="sp">用户名或密码错误!</span>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <button class="bottom_button" type="submit">登录</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="small_right_div">
                <button class="right_button" @click="updAFl()" :style="{display:(!fl?'none':'block')}">注册</button>
                <form class="right_form" action="index/insertUser"
                      :style="{display:(fl?'none':'block')}"
                      onsubmit="return zc_re()"
                      method="post">
                    <table>
                        <tr>
                            <td><h2>注&nbsp;&nbsp;册</h2></td>
                        </tr>
                        <tr>
                            <td><input type="text" placeholder="  用户名" title="用户名" id="insert_username" name="us_username"></td>
                        </tr>
                        <tr>
                            <td><input type="password" placeholder="  密码" title="密码" id="insert_password" name="us_pass"></td>
                        </tr>
                        <tr>
                            <td><input type="email" placeholder="  邮箱" title="邮箱" id="insert_email" name="us_email"></td>
                        </tr>
                        <tr>
                            <td><input type="number" placeholder="  电话号码" title="电话号码" id="insert_photo" name="us_photo"></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <span style="display: none;color: red;" id="sp1">用户名或密码错误!</span>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <button class="bottom_button" type="submit">注册</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
<%--<script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>--%>
<script src="catJs/jquery.js"></script>
<script src="catJs/vue.js"></script>
<script src="catJs/index.js"></script>
</body>
</html>
