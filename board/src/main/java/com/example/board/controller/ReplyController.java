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
	
	// ��� ���
	@PostMapping(value = "/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO replyVO) {
		log.info("create ....... " + replyVO);
		return replyService.register(replyVO) ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// �Խñ� ��� ��ü ��ȸ
	@GetMapping(value = "/{bno}/{page}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("bno") Long bno, @PathVariable("page") int page) { // URL����� bno���� �Ķ���� bno�� ���ν�����
		log.info("getList ...... " + bno);

		return new ResponseEntity<List<ReplyVO>>(replyService.findAllByBNO(bno), HttpStatus.OK);
	}
	
	// ��� 1�� ��ȸ
	@GetMapping(value = "/{rno}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVO> getReply(@PathVariable("rno") Long rno){
		log.info("getReply ....... " + rno);
		
		return new ResponseEntity<ReplyVO>(replyService.findByRNO(rno), HttpStatus.OK);
	}
	
	// ��� ����
	@DeleteMapping(value = "/{rno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno) {
		log.info("remove ....... " + rno);
		return replyService.remove(rno) ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// ��� ����
	// PUT : �ڿ��� ��ü ����. �ڿ� �� ��� �ʵ带 �����ؾ� ��
	// PATCH : �ڿ��� �Ϻ� ����. ������ �ʵ常 �����ϸ� ��
	
	// PATCH�� ���ٰ� �ϸ� �������� ���س��� DEFAULT������ �ִ´ٴ� ���̴�.
	// �ǹ������� �׳� ������ ��� POST ������ ���� ����.
	
	@PutMapping(value = "/{rno}", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@PathVariable("rno") Long rno, @RequestBody ReplyVO replyVO){
		log.info("modify ..... " + rno + replyVO);
		
		replyVO.setRno(rno);
		
		return replyService.modify(replyVO) ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}














