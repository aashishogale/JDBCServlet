<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<form method="get" action="SessionServlet" style="border: 1px solid #ccc">
		<div class="container">
			<label><b>Email</b></label> <input type="text"
				placeholder="Enter Name" name="Name" required> <label><b>Password</b></label>
			<input type="password" placeholder="Enter Password" name="psw"
				required> 
				<a href="welcome.jsp"></a><input type="submit" name="button" value="enter">
		</div>

	</form>
</body>
</html>