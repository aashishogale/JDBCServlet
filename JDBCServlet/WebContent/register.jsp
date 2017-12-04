<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/login.js"></script>

<link rel="stylesheet" type="text/css" href="css/register.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form onsubmit="return checkvalid()" action="RegisterServlet"
		method="post">
		<img src="index.png" alt="google" class="google"> <a
			href="login"><input type="button" value="Sign in"></a>
		<div class="box">
			<p class="title">Create your Google Account
			<p>
			<div class="container">
				<div class="name">
					<p class="heading">Name</p>
					<input type="text" placeholder="First" id="fname" name="fname">
					<input type="text" placeholder="Last" id="lname">
					<p id="pname"></p>

				</div>
				<div class="email">
					<p class="heading">Choose your username</p>
					<input type="email" id="email" name="email"> <span
						class="atgmail">@gmail.com</span>
					<p id="pemail"></p>
				</div>

				<div>
					<p class="heading">Create a password</p>
					<input type="password" id="psw" name="pass">
					<p id="ppass"></p>
				</div>
				<div>
					<p class="heading">Confirm your password</p>
					<input type="password" id="psw-repeat">
					<p id="prpass"></p>
				</div>
				<div>
					<p class="heading">Birthday</p>
					<input type="date" placeholder="day" class="day" id="day">
					<p id="pday"></p>

				</div>
				<p class="heading">Gender</p>
				<div class="space">
					<select name="gender">
						<option value="gender"></option>
						<option value="Female">Female</option>
						<option value="Male">Male</option>
						<option value="Others">Others</option>
					</select>
				</div>
				<div>
					<p class="heading">Mobile Phone</p>
					<input type="text" maxlength="10" name="mobile" id="mobile">
					<p id="pmobile"></p>
				</div>
				<div>
					<p class="heading">Your current email address</p>
					<input type="text">
				</div>
				<div Class="space">
					<p class="heading">Location</p>
					<select name="location">
						<option value=""></option>
						<option value="India">India</option>
						<option value="China">China</option>
						<option value="Australia">Australia</option>
						<option value="USA">USA</option>
						<option value="Germany">Germany</option>
						<option value="Hong-Kong">Hong-Kong</option>
						<option value="Uk">UK</option>
					</select>
				</div>
				<div>
					<input type="submit" value="Enter" class="button">
				</div>
			</div>
		</div>
	</form>
</body>
</html>