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
			h4.reply-h4{
				margin-bottom: 0;
			}
			.reply_top{
			    display: flex;
			    justify-content: space-between;
			}
			
			.replies li{
				margin-bottom: 10px;
			}
			
			.reply_buttons .remove{
				margin-left: 10px;
			}
			
			.reply_buttons .modify-cancel{
				margin-left: 10px;
			}
			
			.uploadResult{
				width: 100%;
			}
			
			.uploadResult ul{
				display: flex;
				justify-content: center;
    			flex-wrap: wrap;
			}
			
			.uploadResult ul li{
				list-style: none;
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
									
<!-- 								첨부파일 보여주기 -->
									<div class="field">
										<h4>첨부파일</h4>
										<div class="uploadResult">
											<ul></ul>
										</div>
									</div>
								</div>
								<ul class="actions special">
									<li>
										<input type="button" class="button" value="수정" onclick="location.href='/board/modify${criteria.getParams()}&bno=${board.bno}'"/>
										<input type="submit" class="button" value="삭제"/>
									</li>
								</ul>
								
								<ul class="icons" style="margin: 0; margin-bottom: 10px;">
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
								
								<%-- 댓글 등록 누르면 나오게 하고 취소하면 없앨 거임 (댓글 div를) --%>
								<a href="javascript:;" class="button primary small register" style="display: block; margin-bottom: 50px">댓글 등록</a>
								<div class="fields register-form" style="display: none;">
									<div class="field">
										<h4 class="reply-h4">작성자</h4>
										<input type="text" name="replier" placeholder="replier">
									</div>
									<div class="field">
										<h4 class="reply-h4">댓글</h4>
										<textarea name="reply" rows="6" placeholder="reply" style="resize: none;"></textarea>
									</div>
									<div class="field registerButtons" style="text-align: right;">
										<a href="javascript:;" class="button primary small finish">등록</a>
										<a href="javascript:;" class="button primary small cancel">취소</a>
									</div>
								</div>
								
								<%-- 자바스크립트 쪽에서 만들어둔 ajax로 DOM을 여기다 뿌리자 --%>
								<ul class="replies"></ul>
							</form>
							
							<div class="paging" style="text-align:center;"></div>
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
		let modifyCheck = false; // 현재 수정 중인지 체크
		
		const repliesUL = $("ul.replies");
		
// 		replyService.getList({bno: bno, page: page}, function(list){
// 			console.log(list);
// 		});
		
		showList(page); // 아래의 showList를 DOM이 로드되면 바로 실행한다.
		
		function showReplyPage(total){
			// 기존 pageDTO에서 하던 연산을 여기서 할 것 
			let endNum; // 현재 페이지 구간 마지막 페이지
			let startNum; // 현재 페이지 구간 시작 페이지
			let prev; // 이전 페이지 구간 존재 여부
			let next = false; // 다음 페이지 구간 존재 여부
			
			endNum = Math.ceil(page / 10.0) * 10;
			startNum = endNum - 9;
			prev = startNum != 1; // 시작 페이지가 1이 아닐 때 true
			
			if(endNum * 10 >= total){
				endNum = Math.ceil(total / 10.0);
			}
			
			if(endNum * 10 < total){
				next = true;
			}
			
			str = "";
			
			if(prev){
				str += `<a class="changePage" href=` + (startNum - 1) + `>
							<code>&lt;</code>
						</a>`
			}
			
			for (let i = startNum; i <= endNum; i++) {
				if(page == i){
					str += `<code>` + i + `</code>`;
				}else{
					str += `<a class="changePage" href=` + i + `>
								<code>` + i + `</code>
							</a>`
				}
			}
			
			if(next){
				str += `<a class="changePage" href=` + (endNum + 1) + `>
							<code>&gt;</code>
						</a>`
			}
			
			$("div.paging").html(str);
		}
		
		function showList(page){
			let param = {bno: bno, page: page};
			replyService.getList(param, function(result){
				// 댓글 목록을 받아옴.
				// 반복을 돌리면서 DOM에 넣어준다
				
				// 댓글 작성 후 24시간이 지났으면 년월일
				// 지나지 않았으면 시분초로 표현하기
				// 자바스크립트 Date 객체로 시간을 정제하자
				
				let list = result.list;
				let total = result.total;
				let str = ""; // DOM에 넣을 텍스트
				let date = "";
				for(i=0; i < list.length; i++){

					// 수정한 댓글이면 updateDate 쓰고, 아니면 replyDate 사용함
					date = (list[i].replyDate == list[i].updateDate) ? list[i].replyDate : list[i].updateDate;
					
					str += `<li id=` + list[i].rno + ` style="display: block;">
							<div class="reply_top">
								<strong class="replier">` + list[i].replier + `</strong>
								<div class="reply_buttons">
									<a href=` + list[i].rno + ` class="modify-ready">수정</a>
									<a href=` + list[i].rno + ` class="modify-finish" style="display: none;">수정완료</a>
									<a href=` + list[i].rno + ` class="remove">삭제</a>
								</div>
							</div>
							<p class=` + list[i].rno + `>` + list[i].reply + `</p>
							<strong style="display: block; text-align: right; margin-bottom: 10px;">` + ((list[i].replyDate != list[i].updateDate) ? "* " : "") + replyService.displayTime(date) + `</strong>
							<div class="line"></div>
							</li>`;
				}
				
				repliesUL.html(str); // 댓글 ul에 DOM 채우기
				showReplyPage(total); // 댓글 페이징 보여주기
			});
		}
		
		$("body").on("click", "a.changePage", function(e){
			e.preventDefault();
			page = $(this).attr("href");
			showList(page);
			modifyCheck = false;
		});
		
		// 댓글 최종 등록 눌렀을 때
		$("body").on("click", "a.finish", function(){
			// reply 객체를 넘겨야 함
			let reply = {
				bno: bno, 
				reply: $(".register-form textarea[name='reply']").val(), 
				replier: $(".register-form input[name='replier']").val()
			};
		
			replyService.add(reply, function(){
				// 성공했으면 showList 메소드를 호출해준다
				$(".register-form textarea[name='reply']").val("");
				$(".register-form input[name='replier']").val("");
				showList(page);
			});
		});
		
		// 댓글 등록 버튼 눌렀을 때
		$("body").on("click", "a.register", function(){
			$("div.register-form").show();
			$(this).hide();
		});
		
		// 댓글 취소 버튼 눌렀을 때
		$("body").on("click", "a.cancel", function(){
			$("div.register-form").hide();
			$("a.register").show();
		});
		
		// 댓글 수정 버튼 눌렀을 때
		$("body").on("click", "a.modify-ready", function(e){
			e.preventDefault();
			
			if(modifyCheck){
				alert("이미 수정 중인 댓글이 있습니다");
				return;
			}else{
				modifyCheck = true;
			}

			const remove = $(this).closest("li").find(".remove");
			
			remove.attr("class", "modify-cancel");
			remove.text("취소");
			
			$(this).hide();
			$(this).closest("li").find("a.modify-finish").show();

			let rno = $(this).attr("href");
			const p = $(".replies li#" + rno).find("p." + rno); // 기존 댓글 내용
			
			p.html("<textarea class=" + rno + " style='resize: none;'>" + p.text() + "</textarea>");
		});
		
		// 댓글 수정 완료 버튼 눌렀을 때
		$("body").on("click", "a.modify-finish", function(e){
			e.preventDefault();
			
			let rno = $(this).attr("href");
			
			let reply = {
				rno: rno,
				reply: $("textarea." + rno).val()
			};
			
			replyService.modify(reply, function(){
				console.log("수정 완료");
				showList(page);
			});
			
			modifyCheck = false;
		});
		
		// 댓글 수정 취소 버튼 눌렀을 때
		$("body").on("click", "a.modify-cancel", function(e){
			e.preventDefault();

			modifyCheck = false;
			showList(page);
		});
		
		// 댓글 삭제 버튼 눌렀을 때
		$("body").on("click", "a.remove", function(e){
			e.preventDefault();
			
			let conf = confirm("정말 삭제하시겠습니까?");
			
			if(!conf){
				return;
			}
			
			let rno = $(this).attr("href");
			
			replyService.remove(rno, function(){
				console.log("삭제 완료");
				showList(page);
			});
			
			modifyCheck = false;
		});
	
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

		/* 첨부파일 관련 */
		$(document).ready(function(){
			// 해당 게시글의 첨부파일 목록을 받아와야 함
			// ajax로 해당 게시글 첨부파일 목록 받아와서 해당 files 객체로 showUploadResult를 호출하면 됨
			
			var $uploadResult = $(".uploadResult ul");
			var contextPath = "${pageContext.request.contextPath}";
			
			let bno = "${board.bno}";

			// 게시글 첨부파일 목록 받아오기
			$.ajax({
				url: contextPath + "/board/files",
				type: "GET",
				data: {
					bno: bno
				},
				success: function(res){
					showUploadResult(res);
				},
				error: function(err){
					console.error(err);
				}
			});
			
			function showUploadResult(files){
				var str = "";
				$(files).each(function(i, file){
					
					if(file.fileType){ // 해당 파일이 이미지라면
						// 파일명을 만들어놓는다
						var fileName = file.uploadPath + "\\t_" + file.uuid + "_" + file.fileName;
						fileName = encodeURIComponent(fileName);
						// 이미지 파일은 아니라도 파일명을 화면에 노출하기 위함인 듯.
						
						// uploadResult의 ul 태그 안에 넣을 html 작성
						str += `<li data-filename="` + file.fileName + `" data-uuid="` + file.uuid + `" data-uploadpath="` + file.uploadPath + `" data-filetype="` + file.fileType + `">
						<div>
							<img src = "` + contextPath + `/display?fileName=` + fileName + `" width='100'>
						</div>
						<span>` + file.fileName + `</span>
						</li>`;
						
					}else{ // 이미지가 아니라면
						str += `<li data-filename="` + file.fileName + `" data-uuid="` + file.uuid + `" data-uploadpath="` + file.uploadPath + `" data-filetype="` + file.fileType + `">
						<div>
							<img src = "` + contextPath + `/resources/images/attach.png" width='100'>
						</div>
						<span>` + file.fileName + `</span>
						</li>`;
					}
				});
				
				$('.uploadResult ul').html(str);
			}
			
		});
		
	</script>
</html>















