$(function(){
	var buttonValue=[];
	var aa=0;
	var star_num =0;
	$("#header_3 .button").css("background","#FEFEFE");
	$("#header_3 .star_1").click(function(e){
		aa=0;
		buttonValue=[];
		$("#header_3 .myTable").css("border","0px");
		$("#header_3 .button").css("background","#999");
		var zuoX=parseInt(e.pageX);
		if(1005<zuoX && zuoX<1030){
			changeGood();
			star_num=5;
			$("#header_3 .star_1").attr("src","myOrderImage/star_6.png");
			
		}else if(980<zuoX && zuoX<1005){
			star_num=4;
			$("#header_3 .star_1").attr("src","myOrderImage/star_5.png");
			changeGood();			
		}else if(957<zuoX && zuoX<980){
			star_num=3;
			$("#header_3 .star_1").attr("src","myOrderImage/star_4.png");
           changeCenter();			
		}else if(932<zuoX && zuoX<957){
			star_num=2;
			$("#header_3 .star_1").attr("src","myOrderImage/star_3.png");
			changeCenter();
		}else if(910<zuoX && zuoX<932){
			star_num=1;
			$("#header_3 .star_1").attr("src","myOrderImage/star_2.png");	
			changeBad();
		}

	});
	function changeGood(){
		$("#button1").val("外观漂亮");
		$("#button2").val("系统流畅");
		$("#button3").val("分辨率高");
		$("#button4").val("功能齐全");
		$("#button5").val("使用方便");
	}
	function changeCenter(){
		$("#button1").val("速度还行");
		$("#button2").val("外观普通");
		$("#button3").val("可以购买");
		$("#button4").val("系统良好");
		$("#button5").val("功能一般");
	}
	function changeBad(){
		$("#button1").val("经常闪退");
		$("#button2").val("反应迟钝");
		$("#button3").val("像素太低");
		$("#button4").val("色差严重");
		$("#button5").val("黑屏死机");
	}
	
	$(".button").click(function(){
	 $(this).css("background","red");
	 
	 buttonValue[aa]=$(this).val();//这里是用点击button的value值；应该用beackground==red的值
	aa++;
	
	
	});
	 
    $("#header_3 .btn_18").click(function(){
		
		var datas= {
			"star": star_num,
			"label_names" : buttonValue
		};
		$.ajax({
		type:"post",
		url:"orders/submit_comment.action",
		dataType:"json",
		data:JSON.stringify(datas),
		contentType:"application/json",
		success:function(result){
		//跳转
		},
		error:function(){
			alert("服务器错误");
		}
	});
		 //var arr = [];
		// data :JSON.stringify(arr)
		  //alert(buttonValue);
	 });
	
  });
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  