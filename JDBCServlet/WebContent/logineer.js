function checkvalid1() {

	if (document.getElementById("fname").value == "") {

		//alert("Cannot leave firstname this field blank");
		document.getElementById("pname").innerHTML="cannot leave this blank";
		return false;
	}

	if (document.getElementById("fname").value.length < 4
			|| document.getElementById("fname").value.length > 20) {

		//alert("pls enter correct number of characterfor first name");
		document.getElementById("pname").innerHTML="cannot leave this blank";
		return false;
	}

	if (document.getElementById("lname").value == "") {
		//alert("Cannot leave lastname blank");
		document.getElementById("pname").innerHTML="cannot leave this blank";
		return false;
	}

	if (document.getElementById("lname").value.length < 4
			|| document.getElementById("lname").value.length > 20) {

		//alert("pls enter correct number of character for last name");
		document.getElementById("pname").innerHTML="cannot leave this blank";
		return false;
	}

	if (document.getElementById("email").value == "") {
		alert("Cannot leave email field blank");
		return false;
	}

	if (document.getElementById("email").value.length < 4
			|| document.getElementById("email").value.length > 40) {

		alert("pls enter correct number of characterfor email");
		return false;
	}

	if (document.getElementById("psw").value == "") {
		alert("Cannot leave password field blank");
		return false;
	}
	if (document.getElementById("psw").value.length < 4
			|| document.getElementById("psw").value.length > 20) {

		alert("pls enter correct number of character for password");
		return false;
	}
	if (document.getElementById("psw-repeat").value == "") {
		alert("Cannot leave password field blank");
		return false;
	}
	if (document.getElementById("psw-repeat").value.length < 4
			|| document.getElementById("psw-repeat").value.length > 20) {

		alert("pls enter correct number of character for repeat password");
		return false;
	}

	var psw = document.getElementById("psw").value;
	var pswrepeat = document.getElementById("psw-repeat").value;
	if (psw != pswrepeat) {
		alert("please enter correct paswords");
		return false;
	}
	var day = parseInt(document.geElementById("day").value);
	if (day > 31) {
		alert("please enter correct date");
		return false;
	}

	if (document.getElementById("mobile").value.length < 9) {
		alert("please enter correct 9 digit number");
		return false;
	}

	return true;
}