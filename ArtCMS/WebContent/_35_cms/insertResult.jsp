<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增資料結果</title>
</head>
<body>
	<h1 align="center">${result}</h1>
	<c:if test="${result.equals('新增成功')}">
		<c:forEach var="list" items="${eventSpace}">
		${list.name}
		${list.owner}
		${list.address}
		${list.type}
		${list.shoppingArea}
		${list.transportation}
		${list.capacity}
		${list.unitPrice}
		${list.area}
		${list.unitPrice}
		</c:forEach>
	</c:if>
</body>
</html>