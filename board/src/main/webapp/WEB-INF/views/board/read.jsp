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
			body {transform: scale(0.8); margin-top: -50px; overflow-x: hidden;}
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
						<p>게시글 상세보기</p>
					</header>
					<!-- Table -->
					<h3><a href="/board/list${criteria.getParams()}" class="button small">목록 보기</a></h3>
					<div class="content">
						<div class="form">
							<form action="/board/remove">
								<div class="fields">
									<div class="field">
										<h4>번호</h4>
										<input type="text" name="bno" value="${board.bno}" readonly>
									</div>
									<div class="field">
										<h4>제목</h4>
										<input type="text" name="title" value="${board.title}" readonly>
									</div>
									<div class="field">
										<h4>내용</h4>
										<textarea name="content" rows="6" style="resize:none;" readonly>${board.content}</textarea>
									</div>
									<div class="field">
										<h4>작성자</h4>
										<input type="text" name="writer" value="${board.writer}" readonly>
									</div>
								</div>
								<ul class="actions special">
									<li>
										<input type="button" class="button" value="수정" onclick="location.href='/board/modify${criteria.getParams()}&bno=${board.bno}'"/>
										<input type="submit" class="button" value="삭제"/>
									</li>
								</ul>
							</form>
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
	
<!-- ajax 부분은 분리를 해서 모듈화해줌 -->
	<script src="/resources/assets/js/reply.js"></script>
	
<!-- 여기서 script 부분에 적을 것은, ajax로 반환받은 값으로 화면에 어떻게 처리해줄지임 -->
	<script type="text/javascript">
// 		console.log("===JS TEST===");
		
// 		let bno = "${board.bno}";
		
// 		let reply = {bno: bno, reply: "모듈화 테스트", replier: "황정민"}; // 자바스크립트 객체 선언
	
// 		replyService.add(reply, function(result){
// 			console.log(result);
// 		});
		

// 		let param = {bno: bno, page: 2}; // page는 기본값으로 사용할 예정	
		
// 		replyService.getList(param, function(list){
// 			console.log(list);
// 		});

// 		let rno = 47;

// 		replyService.remove(rno, function(result){
// 			alert(result);
// 		});

// 		let reply = {rno: 45, reply: "수정테스트~", replier: "수정테스트~"};
		
// 		replyService.modify(reply, function(result){
// 			alert(result);
// 		});
		
// 		let rno = 45;
		
// 		replyService.getReply(rno, function(result){
// 			console.log(result);
// 		});
		
	</script>
</html>















