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
	href="/css/bootstrap.min.css" />
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/main.js"></script>
<script src="js/ajax.js"></script>
</head>

<body>
	<center>
		<div class="container">
			<form action="${pageContext.request.contextPath}/sinhVienUpdate" method="post" class="form">
			<h3>Cập nhật thông tin sinh viên</h3>
			
			Mã SV <input name="maSV" class="form-control" type=text value=<c:out value="${sinhVien.maSV}" /> readonly="true" required> 
			Tên SV <input name="tenSV" class="form-control" type=text value=<c:out value="${sinhVien.tenSV}" /> required> 
			Giới tính <select class="form-control"  name="gioiTinh">
					<option name="true" value="true" ${selectedGender == true ? 'selected="selected"' : ''} >Nam</option>
					<option name="false" value="false" ${selectedGender == false ? 'selected="selected"' : ''}>Nữ</option>
				</select> 
			Ngày sinh <input name="ngaySinh" class="form-control" type=date value=<c:out value="${sinhVien.ngaySinh}" /> required> 
			Quê quán <input name="queQuan" class="form-control" type=text value=<c:out value="${sinhVien.queQuan}" /> required> 
	        Mã lớp <input name="maLop" class="form-control" type=text value=<c:out value="${sinhVien.maLop}" /> required> 
	        <input type="submit" value= "Cập nhật" class= "btn btn-success">
			</form>
		</div>
	</center>
</body>
</html>