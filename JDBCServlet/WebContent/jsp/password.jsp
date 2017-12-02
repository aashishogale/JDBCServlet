<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/password.css">
</head>
<body>
<form onsubmit="return checkpassword()" action="AuthenticateServlet" method="post" >
	<div class="base" align="center">

		<div id="form1">



			<img src="index.png" height=55 width=90 />
			<h2 class="text1">Welcome</h2>
			<input type="password" name="password" placeholder="Enter password here" />

		<p class="text2">
				<a href="Login.html"> <b>Forgot email</b>
				</a>
			</p>
			
			<p class="text2">
					<a href="forgotpassword.html"> <b>Forgot password</b>
					</a>
				</p>
		<input type="submit" id="button"
				value="Next" class="button" style="float: right" />
		</div>

	</div>
		</form>
</body>
</html>