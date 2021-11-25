javascript:
!(function(){
	var canvas = document.createElement("canvas");//创建指定文本为canvas的按钮
	document.body.appendChild(canvas);
	
	canvas.style.position="fixed";
	canvas.style.left = "0";
	canvas.style.top = "0";
	canvas.style.zIndex = -1;
	
	var context = canvas.getContext("2d");
	function resizeCanvas(){
		canvas.width = window.innerWidth;
		canvas.height = window.innerHeight;
		clearCanvas();
	}
	function clearCanvas () {
		context.fillStyle = "#000000";
		context.fillRect(0,0,canvas.width,canvas.height);
	}
	resizeCanvas();
	
	window.addEventListener("resize",resizeCanvas);
	
	function mouseDownHandler(e){//鼠标点击事件
		var x=e.clientX;//获取鼠标的X轴坐标
		var y=e.clientY;//获取鼠标的Y轴坐标
		// console.log(x+"  "+y);
		createFireworks(x,y);
		// createFireworks(x-100,y,-360);
		// createFireworks(x+100,y,-360);
		// createFireworks(x,y+100,360);
	}
	document.addEventListener("mousedown",mouseDownHandler);

	// document.onmousemove = function(e){
	// 	// console.log(e);
	// 	timer=setInterval(function(){
	// 		var x=e.clientX;
	// 		var y=e.clientY;
	// 		console.log(x);
	// 		createFireworks(x,y);
	// 	},100);
	// 	timer.clear();
	// }
	
	// setInterval(function(){
	// 	createFireworks(540,201);
	// 	createFireworks(394,140);
	// 	createFireworks(253,102);
	// 	createFireworks(148,231);
	// 	createFireworks(186,406);
	// 	createFireworks(359,535);
	// 	createFireworks(540,650);
		
	// 	createFireworks(394,140);
	// 	createFireworks(253,102);
	// 	createFireworks(148,231);
	// 	createFireworks(186,406);
	// 	createFireworks(359,535);
		
	// },1500);
	
	// setInterval(function(){
	// 	createFireworks(Math.random()*canvas.width,Math.random()*canvas.height);
	// },1000);
	
	var particles = [];
	function createFireworks(x,y){//把烟花数据存储到一个数组里面
		var count = 50;
		var radius = 0;
		
		var hue = Math.floor(Math.random()*51)+150;
		var hueVariance = Math.floor(Math.random()*361);
		
			for(var i=0;i<count;i++){
				 var angle = 360/count * i;
				 var radians = angle * Math.PI/180;
				 // var radians=4;
				 // var radians=5.5;
				 // var radians=0;
				 // console.log(radians);
				 
				 var p={};
				 p.x = x;
				 p.y = y;
				 p.radians = radians;
				 p.size = 2;
				 
				 p.speed = (Math.random()*5)+.4;
				 
				 p.radius = p.speed;
				 
				 p.hue = Math.floor(Math.random()*((hue+hueVariance)-(hue-hueVariance)))+(hue-hueVariance);//调颜色
				 p.brightness = Math.floor(Math.random()*31)+50;
				 p.alpha = (Math.floor(Math.random()*61)+40)/100;
				 
				 particles.push(p);
			}
	}
	function drawFireworks(){//绘制烟花
		clearCanvas();
		
		for(var i=0;i<particles.length;i++){
			var p = particles[i];
			
			var vx = Math.cos(p.radians)*p.radius;
			// var vx = Math.cos(p.radians)*p.radius;
			var vy = Math.sin(p.radians)*p.radius +0.4;
			
			p.x += vx;
			p.y += vy;
			
			p.radius *= 1-p.speed/100;
			
			p.alpha -= 0.005;
			
			if(p.alpha<=0){
				particles.splice(i,1);
				continue;
			}
			
			context.beginPath();
			context.arc(p.x,p.y,p.size,0,Math.PI*2,false);
			context.closePath();
			
			
			context.fillStyle = 'hsla('+p.hue+',100%,'+p.brightness+'%,'+p.alpha+')';
			context.fill();
		}
		
	}
	function tick() {
		//{//拖尾特效
		context.globalCompositeOperation = 'destination-out';
		context.fillStyle = 'rgba(0,0,0,'+10/100+')';
		context.fillRect(0,0,canvas.width,canvas.height);
		context.globalCompositeOperation = 'lighter';
		//}
		drawFireworks();
		
		requestAnimationFrame(tick);
	}
	tick();
})();