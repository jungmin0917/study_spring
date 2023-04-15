/**
 * Javascript 모듈화
 * 
 * 부품화하겠다는 뜻임
 * ajax 관련 함수를 모듈화하겠다는 것
 *
 * 함수들을 하나의 모듈처럼 묶음으로 구성하는 것을 의미한다.
 * 화면 내에서 Javascript를 처리하다 보면, 이벤트 처리, DOM, Ajax 처리 등
 * 복잡하게 섞여서 유지보수가 힘들다. 따라서 Javascript 코드를 여러 부품으로 분리하여 조립하는 형식으로 설계한다.
 *
 */

console.log("reply Module ...... ");

// 아래 개발 방식은, 댓글에 대한 각 ajax를 캡슐화하여 replyService라는 자바스크립트 객체에 키-값 형태로 메소드들을 담는 것이다.
// 그리고 그 메소드에 넣은 값도 객체화 (reply라는 변수, callback이라는 이후 실행할 함수)하여 최대한 이후 유지보수가 편하도록 개발한 것이다.

// 즉시 실행 함수 (IIFE, Immediately-Invoked Function Expression)을 사용하여
// replyService라는 변수에 모듈을 담는 코드
let replyService = (function(){
	// 추가하기
	function add(reply, callback){ // callback 함수는 이제 뭐냐면 ajax가 성공했을 때 이후에 할 일을 또 따로 모듈화하는 것이다.
		console.log("add reply......");
		
		$.ajax({
			url: "/replies/new",
			type: "POST", // HTTP 요청 방식
			data: JSON.stringify(reply),
			contentType: "application/json; charset=utf-8", // 보낼 데이터 유형
			dataType: "text", // 받을 데이터 유형
			success: function(res){
				if(callback){ // 받은 콜백함수가 존재할 때
					callback(res);
				}
			},
			error: function(err){
				console.error(err);
			}
		
		});
	}
	
	// 키값: 값 형태
	return {add: add};
})();

let testService = (function(){return "ABC";})();

