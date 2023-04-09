<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>직원 근태 처리</title>
</head>
<body>
	<h1>직원 근태 처리</h1>
	
	<form action="ex1/action" id="ex1Form" method="POST">
		<label for="name">이름</label>
		<input type="text" name="name" id="name" placeholder="이름을 입력해주세요">
		<input type="hidden" name="type">
		
		<button type="button" data-type="getTo">출근</button>
		<button type="button" data-type="leave">퇴근</button>
	</form>
</body>

<script
  src="https://code.jquery.com/jquery-3.6.4.min.js"
  integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8="
  crossorigin="anonymous"></script>
<script type="text/javascript">
	$("body").on("click", "#ex1Form button", function(){
		
		if(!($("#name").val())){
			alert("이름을 입력해주세요");
			return;
		}
		
		let type = $(this).data("type");
		
		$("input[name='type']").val(type);
		
		$(this).closest("form").submit();
	});
</script>

</html>








