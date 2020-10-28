<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>藝文課程管理系統</title>
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<form action="<c:url value='CourseHibernateServletSelectAll'/> " method="get">
		<div class="submitButton">
			<input type="submit" class="" name="submit" value="查看所有藝文課程"> 
		</div>
	</form>
</body>
</html>