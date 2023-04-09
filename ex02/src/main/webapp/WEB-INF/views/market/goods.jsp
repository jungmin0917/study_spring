<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 바코드 입력</title>
</head>
<body>
	<h1>상품 바코드 입력</h1>
	
	<table border="1">
		<tr>
			<th>상품명</th>
			<th>바코드 번호</th>
		</tr>
		
		<tr>
			<td>오징어 땅콩</td>
			<td>4383927</td>
		</tr>
		<tr>
			<td>초코우유</td>
			<td>0832147</td>
		</tr>
		<tr>
			<td>벌꿀피자</td>
			<td>9841631</td>
		</tr>
		<tr>
			<td>샌드위치</td>
			<td>5587578</td>
		</tr>
		
	</table>
	
	<form action="/goods/action" method="POST" id="goodsForm">
		<label for="barcode">바코드</label>
		<input type="text" name="barcode" id="barcode" placeholder="바코드를 입력해주세요">
		<button type="button">전송</button>
	</form>
</body>

<script
  src="https://code.jquery.com/jquery-3.6.4.min.js"
  integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8="
  crossorigin="anonymous"></script>

<script type="text/javascript">
	$("body").on("click", "#goodsForm button", function(){
		if(!$("#barcode").val()){
			alert("바코드를 입력해주세요");
			return;
		}
		
		$("#goodsForm").submit();
	});
</script>

</html>










