<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>填寫新增的資料</title>
</head>
<body>
<h1 align="center">請填滿這些空格</h1>
	<form action="<c:url value='InsertInto'/> " method="get" id="addData">
		<div class="submitButton">
			<label>場地名稱</label>
			<input type="text" class="" name="name" value=""><br>
			<label>場地所屬單位</label>
			<input type="text" class="" name="owner" value=""><br>
			<label>地址</label> 
			<input type="text" class="" name="address" value=""><br>
			<label>場地類型</label> 
			<input type="text" class="" name="type" value=""><br>
			<label>鄰近的商圈</label> 
			<input type="text" class="" name="shoppingArea" value=""><br>
			<label>鄰近的大眾運輸工具</label> 
			<input type="text" class="" name="transportation" value=""><br>
			<label>場地容納人數上限</label> 
			<input type="text" class="" name="capacity" value=""><br> 
			<label>每坪租金</label> 
			<input type="text" class="" name="unitPrice" value=""><br> 
			<label>場地面積</label> 
			<input type="text" class="" name="area" value=""><br> 
			<label>可供租借時段</label> 
			<input type="text" class="" name="rentalTime" value=""><br> 
			<label>鄰近活動資訊</label> 
			<input type="text" class="" name="activityInfo" value=""><br> 
			<label>聯絡資訊</label> 
			<input type="text" class="" name="contactInfo" value=""><br> 
		</div>
		<div id="btnArea" align="center">
        	<input type="submit" class="btn btn-info" name="submit" id="submit" value="儲存"/>
        	<input type="reset" class="btn btn-info" name="cancel" id="cancel" value="重填">
       	</div>
	</form>

</body>
</html>