<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인 페이지</title>
</head>
<body>
	<form action="./login" method="POST">
		<label for="id">아이디</label>
		<input type="text" name="id" id="id" placeholder="아이디">
		<label for="pw">비밀번호</label>
		<input type="password" name="pw" id="pw" placeholder="비밀번호">
		<button type='submit'>로그인</button>
	</form>
</body>

<script
  src="https://code.jquery.com/jquery-3.6.4.min.js"
  integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8="
  crossorigin="anonymous"></script>
<script type="text/javascript">
	$('body').on('click', '.formButton', function(){
		if(!$("#id").val()){
			alert("아이디를 입력해주세요");
			return;
		}
		
		if(!$("#pw").val()){
			alert("비밀번호를 입력해주세요");
			return;
		}
		
		$(this).closest("form").submit();
	});
</script>
</html>







