<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button id="demo1">Demo 1</button>
	<button id="demo3">Demo 3</button>

	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
		document.getElementById("demo1").addEventListener("click", function() {
			swal("!", "You clicked the button!", "success");
		});
		
		document.getElementById("demo3").addEventListener("click",function(){
			  swal({
			    title: "確認刪除?",
			    icon: "warning",
			    buttons: true,
			    dangerMode: true
			  });
			});
	</script>

</body>
</html>