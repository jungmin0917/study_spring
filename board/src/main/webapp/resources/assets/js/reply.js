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
	
	// 목록 보기
	// param은 게시글 번호와 요청한 페이지를 받아올 수 있는 객체이다.
	function getList(param, callback, error){ // bno(게시글 번호)와 page(페이징 처리 할 것임)가 필요한데 이걸 한 번에 객체로 받을 것임
		console.log("getList......");
	
		let bno = param.bno;
		// let variable = a || b; ---> a가 값이 없거나 false인 경우, variable에 b가 할당된다.
		let page = param.page || 1;  
		
		// 좀 더 편한 문법으로 가져오자
		// 주의 : get은 가져온다는 뜻이 아니고 GET 방식으로 요청한다는 뜻의 get이다! (그렇다고 $.postJSON이 존재하지는 않는다..)
		// $.getJSON(url, [data], [success]); 이렇게 쓴다.
		// .json을 붙이는 이유는, XML, JSON 두 방식으로 매핑해놨는데 XML이 디폴트이기 때문.
		$.getJSON("/replies/" + bno + "/" + page + ".json", function(list){
			if(callback){
				callback(list);
			}
		}).fail(function(xhr, status, err){
			if(error){
				error(err);
			}
		});
	}
	
	// 키값: 값 형태
	return {add: add, getList: getList};
})();

let testService = (function(){return "ABC";})();

