<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>포인트 결제</title>
	
	<style type="text/css">
		table{
			margin: 0 auto;
			margin-bottom: 20px;
		}
		
		.buttons{
			margin: 0 auto;
			text-align: center;
			width: 30%;
		}
		
		.buttons .applyButton{
			display: block;
			margin: 10px 0;
			width: 100%;
		}
		
		.buttons .rate.on{
			background-color: black;
			color: white;
			font-weight: bold;
		}
		
	</style>
</head>

<body>
	<form action="/change" method="POST" id="saleForm">
		
		<input type="hidden" name="productName">
		<input type="hidden" name="productPrice">
		
		<table border="1">
			<tr>
				<th>선택</th>
				<th>상품명</th>
				<th>가격</th>
			</tr>
			
			<tr>
				<td>
					<input type="radio" name="productNumber" value="1">
				</td>
				<td>
					 오징어 땅콩
				</td>
				<td>
					3500
				</td>
			</tr>
			<tr>
				<td>
					<input type="radio" name="productNumber" value="2">
				</td>
				<td>
					 초코 우유
				</td>
				<td>
					1500
				</td>
			</tr>
			<tr>
				<td>
					<input type="radio" name="productNumber" value="3">
				</td>
				<td>
					 벌꿀 피자
				</td>
				<td>
					2800
				</td>
			</tr>
			<tr>
				<td>
					<input type="radio" name="productNumber" value="4">
				</td>
				<td>
					 샌드위치
				</td>
				<td>
					4500
				</td>
			</tr>
		</table>
		
		<div>
			<input type="text" name="point" placeholder="사용하실 포인트를 입력하세요">
			<input type="submit" value="구매">
		</div>
		
	</form>
</body>

<script
  src="https://code.jquery.com/jquery-3.6.4.min.js"
  integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8="
  crossorigin="anonymous"></script>

<script type="text/javascript">

	let productNumber = "${product.productNumber}";
	let productPrice = "${product.productPrice}";

	$("body").on("click", "input[name='productNumber']", function(){
		$("input[name='productName']").val($(this).closest("tr").find("td:nth-of-type(2)").html().trim());
		$("input[name='productPrice']").val($(this).closest("tr").find("td:nth-of-type(3)").html().trim());
	});
	
	$(document).ready(function(){
		$("input[name='productNumber']").each(function(i, input){
			if($(input).val() == productNumber){
				
			}
		});
	});
	
</script>

</html>