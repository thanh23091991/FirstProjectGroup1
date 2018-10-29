<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link rel="stylesheet" type="text/css" media="screen" href="css/Login.css" />
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body id="LoginForm">
	<div class="container">
		<h1 class="form-heading">login Form</h1>
		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<h2>Đăng nhập</h2>
					<p>Nhập email và mật khẩu của bạn</p>
				</div>
				<form id="Login" action="LoginForm" method="POST">
					<div class="form-group">
						<input type="email" class="form-control" id="inputEmail"
							placeholder="Email Address" name="email" value="${cookie.email.value}">
							<p class ="errLogin">${errEmail}</p>
					</div>
					
					<div class="form-group">
						<input type="password" class="form-control" id="inputPassword"
							placeholder="Password" name="password" value="${cookie.password.value}">
							<p class ="errLogin">${errPassword}</p>
					</div>
					
					<div class="forgot">
						<input type="checkbox" value="1" name="remember"> <span> Remember me?</span>
					</div>
							<p class ="errLogin">${errLogin}</p>
					<button type="submit" class="btn btn-primary">Login</button>
				</form>
			</div>
			<p class="botto-text">Designed by ThanhIT</p>
		</div>
	</div>
</body>
</html>