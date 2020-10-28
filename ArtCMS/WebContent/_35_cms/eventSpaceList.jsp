<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<meta charset="UTF-8">
<title>可租借場地清單</title>
</head>
<body>
<div class=title>
	<h1 align="center">可供租借的場地清單如下：</h1>
</div>
<div class=content>
	<c:set var="counter" value="0"/>
	<c:forEach var="list" items="${eventSpaceList}">
			<c:set var="counter" value="${counter+1}"/>
			<table style="margin-bottom: 0" class="table table-bordered table-hover table-blue">
				<tr class="">
					<th class="table-secondary">場地名稱</th>
					<th class="table-warning">場地所屬單位</th>
					<th class="table-light">地址</th>
					<th class="table-secondary">場地類型</th>
					<th class="table-success">鄰近的商圈</th>
					<th class="table-danger">鄰近的大眾運輸工具</th>
					<th class="table-primary">場地容納人數上限</th>
					<th class="table-info">每坪租金</th>
					<th class="table-danger">場地面積</th>
					<th class="table-primary">可供租借時段</th>
					<th class="table-info">鄰近活動資訊</th>
					<th class="table-success">聯絡資訊</th>
				</tr>
				<tr>
					<td class="">${list.name}</td>
					<td class="">${list.owner}</td>
					<td class="">${list.address}</td>
					<td class="">${list.type}</td>
					<td class="">${list.shoppingArea}</td>
					<td class="">${list.transportation}</td>
					<td class="">${list.capacity}</td>
					<td class="">${list.unitPrice}</td>
					<td class="">${list.area}</td>
					<td class="">${list.rentalTime}</td>
					<td class="">${list.activityInfo}</td>
					<td class="">${list.contactInfo}</td>
				</tr>
			</table>
	</c:forEach>
</div>
<div class="end">
	<form action="<c:url value='cmsIndex.jsp'/> " method="get">
		<div class="submitButton">
			<input type="submit" class="" name="submit" value="返回租借場地管理頁面"> 
		</div>
	</form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</div>

</body>
</html>