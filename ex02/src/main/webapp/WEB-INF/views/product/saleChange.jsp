<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>세일 항목 변경</title>
	
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
		
		<input type="hidden" name="productName">
		<input type="hidden" name="productPrice">
		<input type="hidden" name="productRate">
		
		<div class="buttons">
			<button class="rate" type="button" data-rate="10">10%</button>
			<button class="rate" type="button" data-rate="30">30%</button>
			<button class="rate" type="button" data-rate="60">60%</button>
			<button class="rate" type="button" data-rate="90">90%</button>
			
			<div>
				<button class="applyButton" type="button">적용</button>
			</div>
		</div>
	</form>
</body>

<script
  src="https://code.jquery.com/jquery-3.6.4.min.js"
  integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8="
  crossorigin="anonymous"></script>

<script type="text/javascript">
	$("body").on("click", "button.rate", function(){
		$("button.rate").removeClass("on");
		
		$(this).addClass("on");
	});
	
	$("body").on("click", ".applyButton", function(){
		// 선택한 상품이 있는지 확인
		let num = $("input[name='productNumber']:checked").val();
		
		if(!num){
			alert("할인할 상품을 선택해주세요");
			return;
		}
		
		// 선택한 할인율이 있는지 확인
		let rate = $("button.rate.on").data("rate");
		
		if(!rate){
			alert("할인율을 선택해주세요");
			return;
		}
		
		// 각 hidden 태그 넣기
		
		let name = $("input[name='productNumber']:checked").closest("tr").find("td:nth-of-type(2)").html().trim();
		let price = $("input[name='productNumber']:checked").closest("tr").find("td:nth-of-type(3)").html().trim();
		
		$("input[name='productName']").val(name);
		$("input[name='productPrice']").val(price);
		$("input[name='productRate']").val(rate);
		
		$("#saleForm").submit();
	});
	
</script>

</html>