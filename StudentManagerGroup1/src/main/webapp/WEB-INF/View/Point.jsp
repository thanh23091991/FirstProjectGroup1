<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Point Manager</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" media="screen" href="css/main.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="css/bootstrap.min.css" />
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/main.js"></script>
</head>
<body>
<div class="alert "
                style="width: 180px; float: right; margin-bottom: 15px;padding-left:20px; height:100px">
                   <span class="text-success"> <c:out value="${welcomeMsg}" /></span> 

                <a href="${pageContext.request.contextPath}/logout"><button
                    class="btn btn-outline-danger" value="Logout"
                    style=" ">Logout</button></a>
            </div>
	<center>
		<!-- Header -->
		<div class="header">
			
		</div>
		
		<!-- END Header -->
		<div class="container">

			<h3>Point Manager</h3>
			<h4>
				<c:out value="${deletedMsg}" />
			</h4>
			<h4>
				<c:out value="${updatedMsg}" />
			</h4>
			<h4>
				<c:out value="${insertedMsg}" />
			</h4>
			<a href="insPoint"><button
					class="btn btn-outline-primary" value="Insert"
					style="float: left; margin-bottom: 5px">Insert</button></a>
					<p>Page: <c:forEach begin="1" end="${diemsSize}" varStatus="loop">
    <a href="point?page=${loop.index}">${loop.index}</a>
</c:forEach>  </p> 
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th scope="col">Student ID</th>
						<th scope="col">Subject ID</th>
						<th scope="col">Semester</th>
						<th scope="col">First Point</th>
						<th scope="col">Second Point</th>
						<th scope="col">Update</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pointList}" var="point">
						<tr>
							<td><c:out value="${point.maSV}" /></td>
							<td><c:out value="${point.maMH}" /></td>
							<td><c:out value="${point.hocKy}" /></td>
							<td><c:out value="${point.diemLan1}" /></td>
							<td><c:out value="${point.diemLan2}" /></td>
							<td><a
								href="udpPoint?masv=${point.maSV}&mamh=${point.maMH}&diem1=${point.diemLan1}&hocky=${point.hocKy}&diem2=${point.diemLan2}"><button
										class="btn btn-success" value="Update">Update</button></a></td>
							<td><a onclick="return comfirmDeletePoint()"
								href="deletePoint?masv=${point.maSV}&mamh=${point.maMH}&diem1=${point.diemLan1}&hocky=${point.hocKy}&diem2=${point.diemLan2}"><button
										class="btn btn-danger" value="Delete">Delete</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</center>
</body>
</html>