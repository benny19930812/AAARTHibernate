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
	padding: 20px;
}

.colorGray {
	color: #9D9D9D;
	font-size: 12px;
}
</style>
<meta charset="UTF-8">
<title>文創商店 後台管理系統 查詢商店資料</title>
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<h2>文創商店 後台管理系統</h2>
	<h3>查詢商店資料</h3>
<body>
	<div align='center'>
		<table border='1'>
			<tr>
				<td>商店編號</td>
				<td>商店名稱</td>
				<td>代表圖像連結網址</td>
				<td>商店簡介</td>
				<td>商店所在的縣市名</td>

				<td>商店地址</td>
				<td>經度</td>
				<td>緯度</td>
				<td>營業時間</td>
				<td>連絡電話</td>

				<td>傳真號碼</td>
				<td>電子郵件</td>
				<td>Facebook網址</td>
				<td>商店網站網址</td>
				<td>點擊次數</td>
			</tr>
			<c:forEach items="${ccShopsList}" var="ccShopsList" varStatus="vs">
				<tr>
					<td>${ccShopsList.shopId}</td>
					<td>${ccShopsList.name}</td>
					<td>${ccShopsList.representImage}</td>
					<td>${ccShopsList.intro}</td>
					<td>${ccShopsList.cityName}</td>

					<td>${ccShopsList.address}</td>
					<td>${ccShopsList.longitude}</td>
					<td>${ccShopsList.latitude}</td>
					<td>${ccShopsList.openTime}</td>
					<td>${ccShopsList.phone}</td>

					<td>${ccShopsList.fax}</td>
					<td>${ccShopsList.email}</td>
					<td>${ccShopsList.facebook}</td>
					<td>${ccShopsList.website}</td>
					<td>${ccShopsList.clicks}</td>
				</tr>
			</c:forEach>
		</table>
		<table>
			<tr>
				<td>${ccShopsSerachMsg}</td>
			</tr>
			<tr>
				<td><a
					href="<c:url value='/_03_cultural_and_creative_shops_cms/index.jsp' />">返回系統首頁</a></td>
			</tr>
		</table>
	</div>
</body>
</html>