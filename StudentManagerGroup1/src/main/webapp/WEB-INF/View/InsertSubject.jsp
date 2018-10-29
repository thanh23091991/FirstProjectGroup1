<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Insert Point</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
 <link rel="stylesheet" type = "text/css" href = "css/main.css" />

</head>
<body>

<center>
	<div style="margin-top:8%; width: 600px">
		<div class="container">
			<form action="insertSubject" method="post" class="form" name="monhoc" onsubmit="return validateFormInsert()">
			<h3>Insert Subject</h3>
			<div style="margin: 10px 0px 10px 0px"></div>
			Mã Môn Học <input name="maMH" class="form-control" type=text/>
			<div style="margin: 10px 0px 15px 0px"></div>
			Tên Môn Học <input name="tenMH" class="form-control" type=text/>
			<div style="margin: 5px 0px 5px 0px"><p style="opacity: 0.3">* Tên môn học phải có định dạng chữ</p></div>
			Số trình <input name="soTrinh" class="form-control" type=text/>
			<div style="margin: 5px 0px 10px 0px"><p style="opacity: 0.3">* Số trình phải có định dạng số >0 và < 7 </p></div>
	        <div>
	        	<p name="alert" style="color: red">
					<c:out value="${insertMsg}" />
				</p>
	        </div>
	        <input type="submit" value= "Insert" class= "btn btn-success">
			</form>
		</div>
	</div>	
</center>

	<script type="text/javascript">
	function validateFormInsert() {
		var x = document.forms["monhoc"]["maMH"].value
	    var y = document.forms["monhoc"]["soTrinh"].value;
		var z = document.forms["monhoc"]["tenMH"].value;
		var regex_text = /^[a-zA-Z]+$/;
		if (x == "" || x == " "){
		    alert("Mã môn học không được để trống");
		    return false;
		}
		if (z == "" || z == " "){
		    alert("Tên môn học không được để trống");
		    return false;
		}
		if (y == "" || y == " "){
		    alert("Số trình không được để trống");
		    return false;
		}
		if(regex_text.test(z)== false){
		  alert("Vui lòng nhập đúng định dạng dữ liệu");
		  return false;
		}
	    if(isNaN(y))
	    {
	    	alert("Vui lòng nhập đúng định dạng dữ liệu ");
	    	return false ;
	    }
	}
		
	</script>

	

</body>
</html>