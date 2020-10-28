<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>租借場地管理</title>
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
<a href="<c:url value='addData.jsp'/>">新增資料</a>
<h1 align="center">管理員您好，選擇您想執行的功能</h1>
	<form action="<c:url value='addData.jsp'/> " method="get">
		<div class="submitButton">
			<input type="submit" class="" name="submit" value="新增"> 
		</div>
	</form>
	<form action="<c:url value='Update'/> " method="get">
		<div class="submitButton">
			<input type="submit" class="" name="submit" value="修改"> 
		</div>
	</form>
	<form action="<c:url value='Delete'/> " method="get">
		<div class="submitButton">
			<input type="submit" class="" name="submit" value="刪除"> 
		</div>
	</form>
	<form action="<c:url value='Select'/> " method="get">
		<div class="submitButton">
			<input type="submit" class="" name="submit" value="查詢單筆"> 
		</div>
	</form>
	<form action="<c:url value='SelectAll'/> " method="get">
		<div class="submitButton">
			<input type="submit" class="" name="submit" value="查詢全部"> 
		</div>
	</form>

</body>
</html>