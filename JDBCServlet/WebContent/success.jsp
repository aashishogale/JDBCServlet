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
<h1>success</h1>

  <%@page import="com.bridgelabz.dao.UserDao,com.bridgelabz.model.User,java.util.*"%>  
 
<h1>Users List</h1>  
  
<%  
UserDao userdao=new UserDao();
List<User> list=userdao.getAllRecords();  
request.setAttribute("list",list);  
%>  
  
<table border="1" width="90%">  
<tr><th>Name</th><th>Password</th><th>Email</th>  
 
<c:forEach items="${list}" var="u">  
<tr><td>${u.getName()}</td><td>${u.getPassword()}</td>  
<td>${u.getEmail()}</td> 
 </tr>
</c:forEach>  
</table>   
</body>
</html>