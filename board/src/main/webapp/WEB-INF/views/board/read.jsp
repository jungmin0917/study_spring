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
			div.line{
				border-bottom: 1px solid #ff8b77;
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
								
								<ul class="icons">
									<li>
										<span class="icon solid fa-envelope"></span>
										<strong>댓글</strong>
									</li>
<!-- 									<li style="display: block;"> -->
<!-- 										<strong>작성자</strong> -->
<!-- 										<p>댓글 내용</p> -->
<!-- 										<strong>작성 시간</strong> -->
<!-- 										<div class="line"></div> -->
<!-- 									</li> -->
								</ul>
								
								<%-- 자바스크립트 쪽에서 만들어둔 ajax로 DOM을 여기다 뿌리자 --%>
								<ul class="replies"></ul>
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

		let bno = "${board.bno}";
		let page = 1;
		
		const repliesUL = $("ul.replies");
		
// 		replyService.getList({bno: bno, page: page}, function(list){
// 			console.log(list);
// 		});
		
		showList(page); // 아래의 showList를 DOM이 로드되면 바로 실행한다.
		
		function showList(){
			let param = {bno: bno, page: page};
			replyService.getList(param, function(list){
				// 댓글 목록을 받아옴.
				// 반복을 돌리면서 DOM에 넣어준다
				
				console.log(list);
				
				// 댓글 작성 후 24시간이 지났으면 년월일
				// 지나지 않았으면 시분초로 표현하기
				// 자바스크립트 Date 객체로 시간을 정제하자
				
				let str = ""; // DOM에 넣을 텍스트
				let date = "";
				for(i=0; i < list.length; i++){

					// 수정한 댓글이면 updateDate 쓰고, 아니면 replyDate 사용함
					date = (list[i].replyDate == list[i].updateDate) ? list[i].replyDate : list[i].updateDate;
					
					str += `<li style="display: block;">
							<strong>` + list[i].replier + `</strong>
							<p>` + list[i].reply + `</p>
							<strong style="display: block; text-align: right">` + ((list[i].replyDate != list[i].updateDate) ? "* " : "") + replyService.displayTime(date) + `</strong>
							<div class="line"></div>
							</li>`;
				}
				
				repliesUL.html(str);
			});
		}
	
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















