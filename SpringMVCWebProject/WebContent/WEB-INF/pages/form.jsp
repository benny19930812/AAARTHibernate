<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
</head>
<body>
<h2>Form</h2>
<!-- <form action="hello.controller" method="get"> -->
<form action='<c:url value="/hello.controller"/>' method="get">
  <table>
    <tr>
      <td>UserName</td>
      <td><input type="text" name="user"></td>
      <td><font color="red">${errors.msg}</font></td>
    </tr>
    <tr>
      <td><input type="submit" value="Send"></td>
    </tr>
  </table>
</form>
</body>
</html>