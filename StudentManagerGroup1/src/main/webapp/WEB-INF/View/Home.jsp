<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
 	<!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
		<div class="container">
			<a class="navbar-brand" href="#">Start Bootstrap</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="Home">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Student</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Subject</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="point">Point</a>
					</li>
					<%if(request.getAttribute("email") != "") {%>
					<li class="nav-item">
						<form action="/Logout" method="post">
						    <input type="submit" value="Logout" />
						</form>
					</li>
					<li class="nav-item">
						<p style="color: white;padding: 5px;">   Welcome : ${email}</p>
					</li>
					<%} else{ %>
					<li class="nav-item"><a class="nav-link" href="Login">Login</a>
					<%}%>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<img alt="anh nen" src="background.jpg">
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript -->
	<script src="jquery/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>