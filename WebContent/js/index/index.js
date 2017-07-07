
$(document).ready(function(){
});
function register(){
	var date=$(form).serialize();
	$.ajax({
		   type: 'POST',
		   url: "UserControll/register" ,
		  data: date ,
		  //dataType: "application/json",
		  success: function(date){
           if(date==1){
        var path="UserControll/login?username="+$("#form input[name='username']").val()+"&passowrd="+$("#form input[name='username']").val();  	
           window.location.href=path;}
           else{
        	   alert("系统问题");
           }
		  } ,
		  error:function(date){
			  alert("网络错误");
		  }
		});
}

function logIn(){
	var date=$(form).serialize();
	$.ajax({
		   type: 'POST',
		   url: "UserControll/register" ,
		   data: date ,
		  //dataType: "application/json",
		  success: function(date){
     	   	window.reload(true);
		  } ,
		  error:function(date){
			  
		  }
		});	
}
function quit(){
	$(real).css("display","none");
	$(mask).css("display","none");
}

function showRegister(){
	$(real).css("display","block");
	$(mask).css("display","block");
	$(".coupleButtonLeftLogin").css("display","none");
	$(".coupleButtonLeftRegister").css("display","inline-block");
}
function showlogin(){
	$(real).css("display","block");
	$(mask).css("display","block");
	$(".coupleButtonLeftLogin").css("display","inline-block");
	$(".coupleButtonLeftRegister").css("display","none");
}
