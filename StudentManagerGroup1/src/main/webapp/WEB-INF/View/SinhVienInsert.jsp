<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Page Title</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" media="screen" href="main.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="css/bootstrap.min.css" />
<script src="js/jquery-3.3.1.min.js"></script>
	<script src="/js/main.js"></script>
<script src="js/ajax.js"></script>
</head>

<body>
	<center>
		<div class="container">
			<form action="${pageContext.request.contextPath}/sinhVienInsert"
				method="post" class="form" >
				<h3>Thêm Sinh Viên</h3>
				Mã SV <input name="maSV" class="form-control" type=text required>
				Tên SV <input name="tenSV" class="form-control" type=text required> 
				Giới tính<select class="form-control" selected="selected" name="gioiTinh">
					<option value="true">Nam</option>
					<option value="false">Nữ</option>
				</select> 
				Ngày sinh <input name="ngaySinh" class="form-control" type=date required id="ngaySinh" max='2018-01-01' min='1899-01-01'>
				Quê quán <input name="queQuan" class="form-control" type=text required>
				Mã lớp <input name="maLop" class="form-control" type=text required> 
				<input type="submit" value="Thêm" class="btn btn-success" >
			</form>
		</div>
	</center>

</body>
</html>