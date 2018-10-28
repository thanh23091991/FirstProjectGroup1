/**
 * 
 */
function comfirmDeletePoint() {
	return window.confirm("Do you really want to delete?");
}

// Validates that the input string is a valid date formatted as "dd/mm/yyyy"
function isValidDate(dateString) {

	// First check for the pattern
	var dateRegEx = /^(0[1-9]|1\d|2\d|3[01])(0[1-9]|1[0-2])(19|20)\d{2}$/;
	
	if (!(dateRegEx.test(dateString))) {
		alert("Vui lòng nhập ngày tháng năm hợp lệ theo đúng định dạng!");
		document.getElementById("ngaySinh").style.backgroundColor = "#FA8072";
		document.getElementById("ngaySinh").focus();	
		return false;
	}

	// Parse the date parts to integers
	var parts = dateString.split("/");
	var day = parseInt(parts[0], 10);
	var month = parseInt(parts[1], 10);
	var year = parseInt(parts[2], 10);

	// Check the ranges of month and year
	if (year < 1900 || year > 2018 || month == 0 || month > 12) {
		alert("Vui lòng nhập 1 trong 12 tháng trong khoảng 1900-2018!");
		document.getElementById("ngaySinh").focus();
		return false;
	}
	var monthLength = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];

	// Adjust for leap years
	if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
		monthLength[1] = 29;

	// Check the range of the day
	return day > 0 && day <= monthLength[month - 1];
};