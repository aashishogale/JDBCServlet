function checkvalid() {

	if (document.getElementById("fname").value == "") {

		//alert("Cannot leave firstname this field blank");
		document.getElementById("fname").height="30%"
		document.getElementById("pname").innerHTML="cannot leave this blank";
		return false;
	}

	if (document.getElementById("fname").value.length < 4
			|| document.getElementById("fname").value.length > 20) {
		document.getElementById("pname").innerHTML="pls enter correct value";
		//alert("pls enter correct number of characterfor first name");
		return false;
	}

	if (document.getElementById("lname").value == "") {
		document.getElementById("pname").innerHTML="cannot leave this blank";
		//alert("Cannot leave lastname blank");
		return false;
	}

	if (document.getElementById("lname").value.length < 4
			|| document.getElementById("lname").value.length > 20) {
		document.getElementById("pname").innerHTML="pls enter correct value";
		//alert("pls enter correct number of character for last name");
		return false;
	}

	if (document.getElementById("email").value == "") {
		document.getElementById("pemail").innerHTML="pls enter correct value";
		//alert("Cannot leave email field blank");
		return false;
	}

	if (document.getElementById("email").value.length < 4
			|| document.getElementById("email").value.length > 40) {
		document.getElementById("pemail").innerHTML="pls enter correct length";
		//alert("pls enter correct number of characterfor email");
		return false;
	}

	if (document.getElementById("psw").value == "") {
		//alert("Cannot leave password field blank");
		document.getElementById("ppass").innerHTML="pls enter password";
		return false;
	}
	if (document.getElementById("psw").value.length < 4
			|| document.getElementById("psw").value.length > 20) {
		document.getElementById("ppass").innerHTML="pls enter password with correct length";
		//alert("pls enter correct number of character for password");
		return false;
	}
	if (document.getElementById("psw-repeat").value == "") {
		document.getElementById("ppass").innerHTML="pls enter password";
		
		//alert("Cannot leave password field blank");
		return false;
	}
	if (document.getElementById("psw-repeat").value.length < 4
			|| document.getElementById("psw-repeat").value.length > 20) {
		document.getElementById("ppass").innerHTML="pls enter password with correct length";
	//	alert("pls enter correct number of character for repeat password");
		return false;
	}

	var psw = document.getElementById("psw").value;
	var pswrepeat = document.getElementById("psw-repeat").value;
	if (psw != pswrepeat) {
		document.getElementById("prpass").innerHTML="pls enter same password";
		//alert("please enter correct paswords");
		return false;
	}
	var day = parseInt(document.geElementById("day").value);
	if (day > 31) {
		document.getElementById("pday").innerHTML="pls enter correct day";
		//alert("please enter correct date");
		return false;
	}

	if (document.getElementById("mobile").value.length < 9) {
		alert("please enter correct 9 digit number");
		return false;
	}

	return true;
}