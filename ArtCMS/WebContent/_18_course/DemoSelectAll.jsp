<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SelectAll</title>
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
<table>
        <tr>
            <th>編號</th>
            <th>名稱</th>
            <th>價格</th>
        </tr>
      
 	<c:forEach var="selectAllLN" varStatus="stat" items="${cbeanselectAllList}">
 	
        <tr>
            <td>${selectAllLN.id}</td>
            <td>${selectAllLN.title}</td>
            <td>${selectAllLN.price}</td>
        </tr>
 	
 	</c:forEach>
    </table>
</body>
</html>