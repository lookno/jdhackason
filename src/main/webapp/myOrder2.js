$(function(){
	var aa=0;
	var bb=0;
	var cc=0;
	var dd=0;
	

  $("#myBody .star_1_1").click(function(e){
	  var clickX=e.pageX; 
	  if(670<clickX && clickX<688){
		  aa=1;
		  $(this).attr("src","myOrder2Image/star_2.png");  
	  }else if(690<clickX && clickX<710){
		  aa=2;
		  $(this).attr("src","myOrder2Image/star_3.png");  
	  }else if(712<clickX && clickX<740){
		  aa=3;
		   $(this).attr("src","myOrder2Image/star_4.png");  
	  }else if(743<clickX && clickX<765){
		  aa=4;
		   $(this).attr("src","myOrder2Image/star_5.png");  
	  }else if(765<clickX && clickX<784){
		  aa=5;
		  $(this).attr("src","myOrder2Image/star_6.png");  
	  }
	  
  });
  $("#myBody .star_1_2").click(function(e){
	  var clickX=e.pageX; 
	  if(856<clickX && clickX<873){
		  bb=1;
		  $(this).attr("src","myOrder2Image/star_2.png");  
	  }else if(880<clickX && clickX<900){
		  bb=2;
		   $(this).attr("src","myOrder2Image/star_3.png");  
	  }else if(904<clickX && clickX<924){
		  bb=3;
		   $(this).attr("src","myOrder2Image/star_4.png");  
	  }else if(926<clickX && clickX<950){
		  bb=4;
		   $(this).attr("src","myOrder2Image/star_5.png");  
	  }else if(952<clickX && clickX<970){
		  bb=5;
		   $(this).attr("src","myOrder2Image/star_6.png");  
	  }
	  
  });
  
   $("#myBody .star_1_3").click(function(e){
	  var clickX=e.pageX; 
	  if(1043<clickX && clickX<1061){
		  cc=1;
		  $(this).attr("src","myOrder2Image/star_2.png");  
	  }else if(1062<clickX && clickX<1086){
		  cc=2;
		   $(this).attr("src","myOrder2Image/star_3.png");  
	  }else if(1088<clickX && clickX<1112){
		  cc=3;
		   $(this).attr("src","myOrder2Image/star_4.png");  
	  }else if(1114<clickX && clickX<1135){
		  cc=4;
		   $(this).attr("src","myOrder2Image/star_5.png");  
	  }else if(1137<clickX && clickX<1158){
		  cc=5;
		   $(this).attr("src","myOrder2Image/star_6.png");  
	  }
	  
  });
  
    $("#rightBottom .star_1").click(function(e){
	  var clickX=e.pageX;	  
	  if(698<clickX && clickX<715){
		  dd=1;
		  $(this).attr("src","myOrder2Image/star_2.png");  
	  }else if(720<clickX && clickX<740){
		  dd=2;
		   $(this).attr("src","myOrder2Image/star_3.png");  
	  }else if(742<clickX && clickX<765){
		  dd=3;
		   $(this).attr("src","myOrder2Image/star_4.png");  
	  }else if(767<clickX && clickX<789){
		  dd=4;
		   $(this).attr("src","myOrder2Image/star_5.png");  
	  }else if(790<clickX && clickX<815){
		  dd=5;
		   $(this).attr("src","myOrder2Image/star_6.png");  
	  }
	  
  });
  var ee=0;
  var arraySle=[];
$("#rightBottom .button").toggle(function(){
	
	$(this).css("background","red");
	arraySle[ee]=$(this).val();
	ee++;
},function(){
	
	$(this).css("background","#666");
});
  
 $(".picButton").click(function(){
	 $("#file").click();
 });
	 var arraySle=[];
	 var arraySleect=[];
	 var myContent=$(".myContent").val();
 $(".btn_1").click(function(){
	 
	var  buttonValue=arraySle;
	var datas= {
			"pack_star":aa,
			"express_star":bb,
			"attitude_star":cc,
			"star":dd,
			"content":myContent,
			"label_names" : buttonValue,
			"image":""
		};
		$.ajax({
		type:"post",
		url:"procomment/add.action",
		dataType:"json",
		contentType:"application/json",
		data:JSON.stringify(datas),
		success:function(result){
			if(result==200){
				alert("success");	
			}else{
				alert("登陆失败");
			}	
		}

	});
	 //alert(arraySle);
	//alert("aa="+aa+"bb="+bb+"cc="+cc+"dd="+dd);
 });
  
})























