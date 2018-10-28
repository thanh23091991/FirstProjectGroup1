<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Page Title</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" media="screen"
	href="/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="/css/main.css" />
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/main.js"></script>
<script src="js/ajax.js"></script>
</head>

<body>
	<div class="alert "
		style="width: 180px; float: right; margin-bottom: 15px; padding-left: 20px; height: 100px">
		<span class="text-success"> <c:out value="${welcomeMsg}" /></span> <a
			href="${pageContext.request.contextPath}/logout"><button
				class="btn btn-outline-danger" value="Logout" style="">Logout</button></a>
	</div>
	<center>

		<div class="container">
			<h3>Danh sách sinh viên</h3>
			<h4 style="color:red" >
				<c:out value="${deletedMsg}" />
			</h4>
			<h4>
				<c:out value="${updatedMsg}" />
			</h4>
			<h4>
				<c:out value="${insertedMsg}" />
			</h4>
			<a href="${pageContext.request.contextPath}/insertInfoSinhVien"><button
					class="btn btn-outline-primary" value="Insert"
					style="float: left; margin-bottom: 5px">Thêm mới</button></a>
			<table class="table table-hover table-bordered"
				style="text-align: center">
		
				<thead>
					<tr>
						<th scope="col">Mã SV</th>
						<th scope="col">Tên SV</th>
						<th scope="col">Giới tính</th>
						<th scope="col">Ngày sinh</th>
						<th scope="col">Quê quán</th>
						<th scope="col">Mã lớp</th>
						<th scope="col">Cập nhật</th>
						<th scope="col">Xóa</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listSinhVien}" var="sinhVien">
						<tr>
							<td><c:out value="${sinhVien.maSV}" /></td>
							<td><c:out value="${sinhVien.tenSV}" /></td>
							<td><c:choose>
									<c:when test="${sinhVien.gioiTinh}">Nam</c:when>
									<c:otherwise>Nữ</c:otherwise>
								</c:choose></td>
							<td><c:out value="${sinhVien.ngaySinh}" /></td>
							<td><c:out value="${sinhVien.queQuan}" /></td>
							<td><c:out value="${sinhVien.maLop}" /></td>
							<td><a
								href="${pageContext.request.contextPath}/sinhVienUpdate/${sinhVien.maSV}"><button
										class="btn btn-success" value="Update">Cập nhật</button></a></td>
							<td><a
								href="${pageContext.request.contextPath}/sinhVienDelete/${sinhVien.maSV}"><button
										class="btn btn-danger" value="Delete" onclick="return confirm('Bạn có chắc chắn muốn xoá ?')">Xóa</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</center>
</body>
</html>