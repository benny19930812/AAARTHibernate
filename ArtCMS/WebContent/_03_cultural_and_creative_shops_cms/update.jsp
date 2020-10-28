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

form {
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
<title>文創商店 後台管理系統 更新商店資料</title>
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<h2>文創商店 後台管理系統</h2>
	<h3>更新商店資料</h3>
	
	<form method="post"
		action="<c:url value="/UpdateByNameDispatcherAction"/>">
		<h4>更新商店資料 (依商店名稱)</h4>
		<label>請輸入商店名稱: </label> <input type="text" placeholder="請輸入商店名稱 "
			name="name"> <span id=idsp class="colorGray">
			</span> <br />
	</form>
	
	<form method="post"
		action="<c:url value="/UpdateByIdDispatcherAction"/>">
		<h4>更新商店資料 (依商店代碼)</h4>
		<label>請輸入商店編號: </label> <input type="text" placeholder="請輸入商店編號 "
			name="shopId"> 
			<span id=idsp class="colorGray"></span> <br />
	</form>
	
	<div align='center'>
		<a
			href="<c:url value='/_03_cultural_and_creative_shops_cms/index.jsp' />">返回系統首頁</a>
	</div>
</body>
</html>