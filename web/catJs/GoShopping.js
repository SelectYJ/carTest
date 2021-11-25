$('#re').hide();
$(function () {
  $.ajax({
    url:"reToIndex2",
    data:{
      action:"jQueryAjax"
    },
    type:"GET",
    success:function (data) {
      //分页调用方法
      const Api=new pageNation({
        el:"#pagination",//分页器位置
        page:1,//当前页
        size:4,//默认5,10,15,20
        total:data.length,//数据总条数
        styUrl:'../catCss/page.css',//样式地址（可修改）
        IsShowBtn: {//设置需要显示的按钮
          choosePageSize: false,//是否显示下拉选项
          IsShowPrevOrNextBtn: true,//是否显示上一页下一页按钮
          IsShowEnterBtn: true,//是否显示跳转输入
          IsShowTotalPage:true,//是否显示总页数
        },
        callback:function(page,size,total){
          $('#ull').html('');
          // console.log(page,size,total);
          let firstIndex = (page-1)*size;
          let lastIndex = 0;
          if((firstIndex+size)>data.length){
            lastIndex = data.length;
          }else{
            lastIndex = firstIndex+size;
          }
          // console.log(firstIndex+"-"+lastIndex)
          let addR = data.slice(firstIndex,lastIndex);
          // console.log(addR);
          for (let i=0;i<addR.length;i++){
            let line =
                "<li id='lii' class='list-group-item col-xs-6 col-sm-4 col-md-3 col-lg-3'>\n" +
                "        <img id='imgIe' class='img-responsive' src='"+addR[i].carImg+"'>\n" +
                "        <span class='col-xs-4 col-sm-4 col-md-4 col-lg-4'>"+addR[i].carName+"</span>\n" +
                "        <span class='col-xs-4 col-sm-4 col-md-4 col-lg-4'>￥"+addR[i].carPrice+"w</span>\n" +
                "        <span class='col-xs-4 col-sm-4 col-md-4 col-lg-4'>"+addR[i].carQuantity+"辆</span>\n" +
                "      </li>";
            $('#ull').append(line);
          }

        }
      });
    },
    dataType : "json"
  })
})
function selectC() {
  // console.log($('#selectCar').val())
  $.ajax({
    url:"selectCar",
    data:{
      action: $('#selectCar').val()
    },
    type:"GET",
    success:function (data) {
      if(data.length!=0){
        $('#pagination').hide();
        $('#ull>li').hide();
        let line =
            "<li id='li2' class='list-group-item col-xs-6 col-sm-4 col-md-3 col-lg-3'>\n" +
            "        <img id='imgIe' class='img-responsive' src='"+data[0].carImg+"'>\n" +
            "        <span class='col-xs-4 col-sm-4 col-md-4 col-lg-4'>"+data[0].carName+"</span>\n" +
            "        <span class='col-xs-4 col-sm-4 col-md-4 col-lg-4'>￥"+data[0].carPrice+"w</span>\n" +
            "        <span class='col-xs-4 col-sm-4 col-md-4 col-lg-4'>"+data[0].carQuantity+"辆</span>\n" +
            "      </li>";
        $('#ull').append(line);
        $('#re').show();
      }else {
        alert("没有该商品");
      }
    },
    dataType : "json"
  })
}
function re() {
  $('#re').hide();
  $('#pagination').show();
  $('#ull>li').show();
  $('#li2').remove();
}