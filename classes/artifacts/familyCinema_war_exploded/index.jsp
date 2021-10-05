<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MyFiles Login</title>
<link rel="stylesheet"
	href="css/reset.min.css">

<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>

<link rel="stylesheet" href="css/style.css">
</head>

<body>
	<!-- Form Mixin-->
	<!-- Input Mixin-->
	<!-- Button Mixin-->
	<!-- Pen Title-->
	<div class="pen-title">
		<h3>用户登录</h3>
	</div>
	<!-- Form Module-->
	<div class="module form-module">
		<div class="toggle">
			<i class="fa fa-times fa-pencil"><</i>
			<div class="tooltip">点我注册</div>
		</div>
		<div class="form">
			<h2>登录你的账号</h2>
			<h3 style="color: red;">${message}</h3>
			<br>
			<form action="user_login" method="post">
				<input type="text" name="uname" placeholder="用户名" required /> <input
					type="password" name="upsw" placeholder="密码" required />
				<button type="submit">登录</button>
			</form>
		</div>
		<div class="form">
			<h2>注册一个新账号</h2>
			<form action="user_register" method="post">
				<input type="text" name="uname" placeholder="用户名" required /> <input
					type="password" name="upsw" placeholder="密码" required /><input
					type="text" name="urname" placeholder="真实姓名" required /> <input
					type="email" name="uemail" placeholder="邮箱" required />
				<button type="submit">注册</button>
			</form>
		</div>
		<div class="cta">
			<a href="#" onclick="alert('抱歉我也没办法。。。')">忘记你的密码？</a>
		</div>
	</div>
	<div style="margin-bottom: 10em"></div>
</body>
<script src="js/jquery.min.js"></script>
<script src='https://codepen.io/andytran/pen/vLmRVp.js'></script>
<script src="js/index.js"></script>

</html>
