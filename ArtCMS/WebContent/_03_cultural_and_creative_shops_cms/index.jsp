<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<style>
html, body {
	margin: 0;
	padding: 0;
	background: #FFFFFF;
	font-family: "Helvetica", "Arial", "微軟正黑體", sans-serif;
}

h2, h3 {
	text-indent: 80px;
	text-align: left;
	font-style: normal;
}

table {
	width: 1000px;
	margin: auto;
	padding: 20px;
	border-color: transparent;
	display: block;
	background-color: #F5F1E3;
	padding: 20px;
}

.colorGray {
	color: #9D9D9D;
	font-size: 12px;
}
</style>
<meta charset="UTF-8">
<title>文創商店 後台管理系統</title>
</head>

<body>
<jsp:include page="/fragment/top.jsp" />
	<h2>文創商店 後台管理系統</h2>
	<table>
		<tr>
			<td><a href="<c:url value='/_03_cultural_and_creative_shops_cms/create.jsp' />">建立新商店資料</a></td>
			<td><a href="<c:url value='/_03_cultural_and_creative_shops_cms/search.jsp' />">查詢商店資料</a></td>
			<td><a href="<c:url value='/_03_cultural_and_creative_shops_cms/update.jsp' />">更新商店資料</a></td>
			<td><a href="<c:url value='/_03_cultural_and_creative_shops_cms/delete.jsp' />">刪除商店資料</a></td>
		</tr>
	</table>
</body>
</html>