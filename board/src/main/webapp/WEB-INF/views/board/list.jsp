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
			body {transform: scale(0.8); overflow-x: hidden;}
			.big-width {display: block;}
			.small-width {display: none;}
			
			code{
			    display: inline-flex;
			    height: 25px;
    			align-items: center;
			}
			
			@media(max-width: 918px){
				body {transform: scale(1);}
				.writer {display: none;}
				.regDate {display: none;}
				.updateDate {display: none;}
				.big-width {display: none;}
				.small-width {display: block;}
			}
			
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
											<a href="/board/read${pageDTO.criteria.getParams()}&bno=${board.bno}">
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
						
						<%-- 여기에 페이지 정보 구현 --%>
						<div class="page_wrap big-width" style="text-align: center;">
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
						
						<div class="page_wrap small-width" style="text-align: center;">
							<c:if test="${pageDTO.criteria.pageNum > 1}">
								<a class="changePage" href="${pageDTO.criteria.pageNum - 1}">
									<code>
										&lt;
									</code>
								</a>
							</c:if>

							<code>
								<c:out value="${pageDTO.criteria.pageNum}"/>
							</code>
							
							<c:if test="${pageDTO.criteria.pageNum < pageDTO.realEnd}">
								<a class="changePage" href="${pageDTO.criteria.pageNum + 1}">
									<code>
										&gt;
									</code>
								</a>
							</c:if>
						</div>
						
						<%-- 위의 changePage a태그의 href 값을 가져와서 여기 hidden값에 넣어서 submit하겠다는 것 --%>
						<form name="pageForm" action="/board/list">
							<input type="hidden" name="pageNum" value="${pageDTO.criteria.pageNum}">
						</form>
						
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
		// 페이지 이동 스크립트
		$("body").on("click", "a.changePage", function(e){
			e.preventDefault(); // 기존 이벤트 막음
			
			let $form = $(document.pageForm);
			
			let href = $(this).attr("href");

			$form.find("input[name='pageNum']").val(href);
			
			$form.submit();
		});
		
		
		
		
	</script>
</html>










