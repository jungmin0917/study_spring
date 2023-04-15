package com.example.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.domain.vo.ReplyVO;
import com.example.board.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j

@RestController
@RequiredArgsConstructor
@RequestMapping("/replies/*")
public class ReplyController {
	private final ReplyService replyService;
	
	// 댓글 등록
	@PostMapping(value = "/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO replyVO) {
		log.info("create ....... " + replyVO);
		return replyService.register(replyVO) ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 게시글 댓글 전체 조회
	@GetMapping(value = "/{bno}/{page}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("bno") Long bno, @PathVariable("page") int page) { // URL경로의 bno값을 파라미터 bno와 매핑시켜줌
		log.info("getList ...... " + bno);

		return new ResponseEntity<List<ReplyVO>>(replyService.findAllByBNO(bno), HttpStatus.OK);
	}
	
	// 댓글 1개 조회
	@GetMapping(value = "/{rno}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVO> getReply(@PathVariable("rno") Long rno){
		log.info("getReply ....... " + rno);
		
		return new ResponseEntity<ReplyVO>(replyService.findByRNO(rno), HttpStatus.OK);
	}
	
	// 댓글 삭제
	@DeleteMapping(value = "/{rno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno) {
		log.info("remove ....... " + rno);
		return replyService.remove(rno) ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 댓글 수정
	// PUT : 자원의 전체 수정. 자원 내 모든 필드를 전달해야 함
	// PATCH : 자원의 일부 수정. 수정할 필드만 전송하면 됨
	
	// PATCH를 쓴다고 하면 나머지는 정해놓은 DEFAULT값으로 넣는다는 것이다.
	// 실무에서는 그냥 수정의 경우 POST 매핑을 많이 쓴다.
	
	@PutMapping(value = "/{rno}", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@PathVariable("rno") Long rno, @RequestBody ReplyVO replyVO){
		log.info("modify ..... " + rno + replyVO);
		
		replyVO.setRno(rno);
		
		return replyService.modify(replyVO) ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}














