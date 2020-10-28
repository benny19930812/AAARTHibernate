<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginSystem</title>
</head>
<body>
<h2>LoginSystem</h2>
<form action="login.controller" method="POST">
   <p>
   User:<input type="text" name="userName"/><br/><br/> 
   Password:<input type="password" name="userPwd"/><br/> 
   </p>
   <input type="submit" value="Login">
</form>
</body>
</html>