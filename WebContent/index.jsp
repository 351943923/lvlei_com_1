<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/index/index.css" rel="stylesheet" type="text/css" /> 
<script type="text/javascript" src="js/jquery-1.6.2.min.js"/></script>
<script type="text/javascript" src="js/index/index.js"/>
</script>
<title>Insert title here</title>
</head>
<body>
<div class="mostOld">
<div class="head">
<ul class="ulOld">
<li class="liDiv">
<img alt="logo" style="margin-top:0px;vertical-align:middle;"src="./imgs/head.png">
</li>
<li class="liDiv">
<span>欢迎
<%if(request.getParameter("user")==null){ %>
....
<%}else{
	%>
<%=request.getParameter("user.username")%>
<%} %>
</span>

</li>
<li class="liDiv">
<button class="registerButton"onclick="showRegister()">注册</button>
<button class="registerButton"onclick="showlogin()">登陆</button>
</li>
</ul>
</div>
</div>
<div id="mask"class="mask">
<div id="real" class="real">
<form  id="form" onsubmit="function(){return false}">
<span>用户注册</span>
<ul class="param">
<li>用户名</li>
<li><input name="username" type="text" class="formInput"></li>
<li>密码</li>
<li><input name="password" type="password" class="formInput"></li>
<li class="coupleButtonLeftRegister"><input type="button" value="注册"  onclick="register()"></li>
<li class="coupleButtonLeftLogin"><input type="button" value="登录"  onclick="login()"></li>
<li class="coupleButtonRight"><input type="button" value="取消" onclick="quit()"></li>
</ul>
</form>
</div>
</div>
</body>
</html>