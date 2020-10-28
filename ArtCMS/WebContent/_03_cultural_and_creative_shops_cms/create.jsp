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
<title>文創商店 後台管理系統 建立新商店資料</title>
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<h2>文創商店 後台管理系統</h2>
	<h3>建立新商店資料</h3>
		<form method="post" action="<c:url value = "/CreateShopBeanAction"/>">
	
		<label>商店名稱:</label> <input type="text" placeholder="請輸入商店名稱 "
			name="name"> <span id=idsp class="colorGray"></span> <br />
		<p class="colorGray">店名不可空白</p>

		<label>代表圖像連結網址:</label> <input type="text" placeholder="請輸入圖片網址"
			name="representImage"> <span id=idsp class="colorGray"></span>
		<br />
		<p class="colorGray">連結網址不可空白</p>

		<label>商店簡介:</label>
		<textarea placeholder="請輸入簡介內容" name="intro"
			style="width: 500px; height: 80px;"></textarea>
		<span id=idsp class="colorGray"></span> <br />
		<p class="colorGray">簡介內容不可空白</p>

		<label>商店所在的縣市名:</label> <input type="text" placeholder="請輸入縣市名"
			name="cityName"> <span id=idsp class="colorGray"></span> <br />
		<p class="colorGray">範例: 臺北市 信義區 (中間需空2格)</p>

		<!-- ====================================================== -->

		<label>商店地址:</label> <input type="text" placeholder="請輸入商店地址"
			name="address"> <span id=idsp class="colorGray"></span> <br />
		<p class="colorGray">範例: 市府路45號</p>


		<label>經度:</label> <input type="text" placeholder="請輸入經度"
			name="longitude"> <span id=idsp class="colorGray"></span> <br />
		<p class="colorGray">可空白</p>

		<label>緯度:</label> <input type="text" placeholder="請輸入緯度"
			name="latitude"> <span id=idsp class="colorGray"></span> <br />
		<p class="colorGray">可空白</p>

		<label>營業時間:</label> <input type="text" placeholder="請輸入營業時間"
			name="openTime"> <span id=idsp class="colorGray"></span> <br />
		<p class="colorGray">無格式要求</p>

		<label>連絡電話:</label> <input type="text" placeholder="請輸入連絡電話"
			name="phone"> <span id=idsp class="colorGray"></span> <br />
		<p class="colorGray">不可空白、無格式要求</p>

		<!-- ====================================================== -->

		<label>傳真號碼:</label> <input type="text" placeholder="請輸入傳真號碼"
			name="fax"> <span id=idsp class="colorGray"></span> <br />
		<p class="colorGray">可空白、無格式要求</p>

		<label>電子郵件:</label> <input type="text" placeholder="請輸入電子郵件"
			name="email"> <span id=idsp class="colorGray"></span> <br />
		<p class="colorGray">可空白</p>

		<label>Facebook網址:</label> <input type="text"
			placeholder="請輸入facebook 網址" name="facebook"> <span id=idsp
			class="colorGray"></span> <br />
		<p class="colorGray">可空白</p>

		<label>商店網站網址:</label> <input type="text" placeholder="請輸入網址"
			name="website"> <span id=idsp class="colorGray"></span> <br />
		<p class="colorGray">可空白</p>


		<label>點擊次數:</label> <input type="text" placeholder="請輸入"
			name="clicks"> <span id=idsp class="colorGray"></span> <br />
		<p class="colorGray">不可空白</p>

		<button type="submit">資料送出</button>
		<!-- ====================================================== -->

	</form>
	<div align='center'>
		<a
			href="<c:url value='/_03_cultural_and_creative_shops_cms/index.jsp' />">返回系統首頁</a>
	</div>

</body>
</html>
