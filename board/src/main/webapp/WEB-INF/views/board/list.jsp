<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Board</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="/resources/assets/css/main.css" />
		<style>
			body {transform: scale(0.8);}
		</style>
	</head>
	<body class="is-preload">
		<!-- Main -->
		<div id="main">
			<div class="wrapper">
				<div class="inner">
	
					<!-- Elements -->
					<header class="major">
						<h1>Board</h1>
						<p>게시판 목록</p>
					</header>
					<!-- Table -->
					<h3><a href="/board/register" class="button small">글 등록</a></h3>
					<div class="table-wrapper">
						<table>
							<thead>
								<tr class="tHead">
									<th class="bno">번호</th>
									<th class="title">제목</th>
									<th class="writer">작성자</th>
									<th class="regDate">작성일</th>
									<th class="updateDate">수정일</th>
								</tr>
							</thead>
							
							<tbody>
								<c:forEach var="board" items="${boardList}">
									<tr class="tBody">
										<td class="bno">${board.bno}</td>
										<td class="title">
											<a href="/board/read?bno=${board.bno}">
												${board.title}
											</a>
										</td>
										<td class="writer">${board.writer}</td>
										<td class="regDate">${board.regDate}</td>
										<td class="updateDate">${board.updateDate}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						
						<style>
							.page_wrap{
								display: flex;
    							justify-content: center;
							}	
						</style>
						
						<%-- 여기에 페이지 정보 구현1 --%>
						<div class="page_wrap">
							<c:if test="${pageDTO.prev}">
								<a class="changePage" href="${pageDTO.startPage - 1}">
									<code>
										&lt;
									</code>
								</a>
							</c:if>

							<c:forEach var="num" begin="${pageDTO.startPage}" end="${pageDTO.endPage}">
								<c:choose>
									<c:when test="${pageDTO.criteria.pageNum == num}">
										<code>
											<c:out value="${num}"/>
										</code>
									</c:when>
									<c:otherwise>
										<a class="changePage" href="${num}">
											<code>
												<c:out value="${num}"/>
											</code>
										</a>
									</c:otherwise>
								</c:choose>
							
							</c:forEach>
							
							<c:if test="${pageDTO.next}">
								<a class="changePage" href="${pageDTO.endPage + 1}">
									<code>
										&gt;
									</code>
								</a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div> 
	</body>
	<!-- Scripts -->
	<script src="/resources/assets/js/jquery.min.js"></script>
	<script src="/resources/assets/js/jquery.dropotron.min.js"></script>
	<script src="/resources/assets/js/browser.min.js"></script>
	<script src="/resources/assets/js/breakpoints.min.js"></script>
	<script src="/resources/assets/js/util.js"></script>
	<script src="/resources/assets/js/main.js"></script>
	
	<script type="text/javascript">
		$("body").on("click", "a.changePage", function(e){
			e.preventDefault(); // 기존 이벤트 막음
		});
	</script>
</html>