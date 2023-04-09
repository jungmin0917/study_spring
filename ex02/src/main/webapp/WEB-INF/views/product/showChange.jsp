<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>할인율 적용</title>
	
	<style type="text/css">
		table{
			table{
				margin-top: 10px;
				
				text-align: center;
			}
		}
		
		.discSubmit{
			display: block;
			margin: 0 auto;
		}
	</style>
	
</head>

<body>
	<h1>할인이 적용되었습니다</h1>
	
	${productVO.productName} 상품이
	${productVO.productPrice} 원에서
	${productVO.productRate}% 할인되어
	${salePrice} 원이 되었습니다!!
	
	<table border="1">
		<tr>
			<th>상품 번호</th>
			<th>상품명</th>
			<th>상품 원가</th>
			<th>상품 가격</th>
			<th>할인률</th>
		</tr>
		
		<tr>
			<td>${productVO.productNumber}</td>
			<td>${productVO.productName}</td>
			<td>${productVO.productPrice}원</td>
			<td>${salePrice}원</td>
			<td>${productVO.productRate}%</td>
		</tr>
	</table>
	
	<form action="/usePoint" method="POST" name="discountForm" id="discountForm">
		<input type="hidden" name="productNumber" value="${productVO.productNumber}">
		<input type="hidden" name="productName" value="${productVO.productName}">
		<input type="hidden" name="productPrice" value="${salePrice}">
		<input type="submit" value="포인트 사용하여 상품 구매하기" class="discSubmit">
	</form>
	
	<br>
	
	<input type="button" onclick="location.href='/sale'" value="상품 및 할인률 변경하기" class="discSubmit">
		
</body>
</html>









