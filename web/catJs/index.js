
let que = window.location.search.substring(1);
let arr = que.split("=");
if(arr[1]=="error"){
  $('#sp').show();
  $('#sp1').show();
}
function loginIf() {
  $('#sp').hide();
  if($('#username').val()==""){
    alert("用户名输入不能为空！");
    return false;
  }else if($('#password').val()==""){
    alert("密码输入不能为空！");
    return false;
  }
  return true;
}
function zc_re() {
  $('#sp1').hide();
  if($('#insert_username').val()==""){
    alert("用户名输入不能为空！");
    return false;
  }else if($('#insert_password').val()==""){
    alert("密码输入不能为空！");
    return false;
  }else if($('#insert_email').val()==""){
    alert("邮箱输入不能为空！");
    return false;
  }else if($('#insert_photo').val()==""){
    alert("电话号码输入不能为空！");
    return false;
  }
  return true;
}
function reYzmImg() {
  $.ajax({
    url: "index/yzm_if",
    data:{
    },
    type:"GET",
    success:function (data) {
      // console.log(data.yzm)
    },
    dataType : "json"
  })
  location.replace("http://localhost:8080/carTest/");
}
const app = new Vue({
  el: '#big',
  data:{
    fl: true
  },
  methods:{
    updAFl:function () {
      this.fl = !this.fl;
    }
  }
})