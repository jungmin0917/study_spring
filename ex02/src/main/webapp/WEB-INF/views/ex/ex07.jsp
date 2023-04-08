<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ex07</title>
	<style type="text/css">
		table{
			text-align: center;
		}
	</style>
</head>
<body>
	<h1>EX07</h1>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>총점</th>
			<th>평균</th>
		</tr>
		
		<tr>
			<td>
				${studentVO.num}
			</td>
			<td>
				${studentVO.kor}
			</td>
			<td>
				${studentVO.eng}
			</td>
			<td>
				${studentVO.math}
			</td>
			
			<c:set var="total" value="${studentVO.kor + studentVO.eng + studentVO.math}"/>
			<c:set var="avg" value="${total / 3.0}"/>
			
			<td>
				${total}
			</td>
			<td>
				<fmt:formatNumber value="${avg}" pattern="#.##"></fmt:formatNumber>
			</td>
		</tr>
		
	</table>
</body>
</html>