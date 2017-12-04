function checkvalid() {
	if (document.getElementById("email").value == "") {
		alert("Cannot leave email field blank");
		return false;
	}

	if (document.getElementById("email").value.length < 4
			|| document.getElementById("email").value.length > 40) {

		alert("pls enter correct number of character");
		return false;
	}
	return true;
}
function checkpassword() {
	if (document.getElementById("password").value == "") {
		alert("Cannot leave email field blank");
		return false;
	}

	if (document.getElementById("password").value.length < 4
			|| document.getElementById("password").value.length > 40) {

		alert("pls enter correct number of character");
		return false;
	}
	return true;
}