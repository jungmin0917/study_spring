<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ex04</title>
	<style type="text/css">
		table{
			text-align: center;
		}
	</style>
</head>
<body>
	<h1>EX04</h1>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<tr>
			<td>
				<c:out value="${dto.name}"></c:out>
			</td>
			<td>
				<c:out value="${dto.age}"></c:out>
			</td>
		</tr>
	</table>
</body>
</html>