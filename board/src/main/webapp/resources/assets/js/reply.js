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

// 즉시 실행 함수 (IIFE, Immediately-Invoked Function Expression)을 사용하여
// replyService라는 변수에 모듈을 담는 코드
let replyService = (function(){
	// 추가하기
	function register(){}
	
	return {register: register}
})();