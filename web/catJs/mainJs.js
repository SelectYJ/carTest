console.log("嗨")

const app = new Vue({
  el: '#app',
  data: {
    spAm: [
        '基础管理',
        '业务管理',
        '系统管理',
        '统计分析'
    ],
    spAm2: [
        ['../html/index1','../html/index2'],
      ['../html/index3','../html/index4'],
      ['../html/index5','../html/index6'],
      ['../html/index7','../html/index8'],
      ['../html/index9','../html/index10']
    ],
    spAm3: [
        ['个人信息','车辆管理'],
        ['业务管理','车辆管理1'],
        ['客户管理2','车辆管理2'],
        ['客户管理3','车辆管理3']
    ],
    count: [0,1,2,3],
    fal: true,
    spanTop: 'spanTop',
    spanBom: 'spanBom',
    liTop: 'liTop',
    disDiv: 'disDiv',
    su: -1,
    ht: 50,
    tP: 45,
    lMain: '后台首页',
    upDa: true,
	bkColor: '0',
    booLer: false,
  },
  methods:{
    liClick:function(e){
      this.upDa = true;
      this.fal = true;
	  this.bkColor = '0';
      if(this.su === e){
        this.su = -1;
        this.lMain = '后台首页';
        // this.ht = 50;
        // this.tP = 45;
      }else {
        this.su = e;
        this.ht = 145;
        this.tP = 10;
        this.lMain = this.spAm[e];
      }
    },
    aClick:function(index){
      this.fal = false;
      if(index===0){
        this.upDa = false;
      }else {
        this.upDa = true;
      }
    },
    backColor:function (index) {
		this.bkColor = index;
    },
    deleteUser:function () {
      if(confirm('确定注销吗？')==true){
        this.booLer = true;
      }
    }
  }
})