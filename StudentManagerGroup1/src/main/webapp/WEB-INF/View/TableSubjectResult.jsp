<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
 <link rel="stylesheet" type = "text/css" href = "css/main.css" />

</head>
<body>
	<h3 style="margin-top: 5%; text-align: center">Table Subjects</h3>
			
			 <div style="text-align: center;"><a href="insSubInfo">
			 <button class="btn btn-outline-primary" value="Insert">Insert</button></a></div>
			 
			 
			<div class="contentbody" style="width: 600px; margin-left: 27%; margin-top: 15px" >
			   
				<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th scope="col">MaMH</th>
						<th scope="col">TenMH</th>
						<th scope="col">SoTrinh</th>
						<th scope="col">Update</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
					<tbody>
					<c:forEach items="${subjectlist}" var="subject">
						<tr>
							<td><c:out value="${subject.maMH}" /></td>
							<td><c:out value="${subject.tenMH}" /></td>
							<td><c:out value="${subject.soTrinh}" /></td>
							<td><a
								href="updateSubInfo/${subject.maMH}"><button
										class="btn btn-success" value="Update">Update</button></a></td>
							<td><a
								href="subjectDelete/${subject.maMH}"><button
										class="btn btn-danger" value="Delete" onclick="return confirm('Bạn có chắc chắn muốn xóa ?')">Delete</button></a></td>
						</tr>
					</c:forEach>
					<p name="alert" style="color: red; text-align: center;">
					<c:out value="${mess}" />
				    </p>
					</tbody>
				</table>
				
			</div>
		<a href="/subject-show"><button class="btn btn-success" value="Continue" style="margin-left: 27%">Continue</button></a>	
			
</body>
</html>