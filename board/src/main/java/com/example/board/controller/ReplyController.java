package com.example.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.board.domain.vo.ReplyVO;
import com.example.board.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j

@Controller
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
	@GetMapping(value = "/{bno}", produces = {MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("bno") Long bno) { // URL����� bno���� �Ķ���� bno�� ���ν�����
		log.info("getList ...... " + bno);

		return new ResponseEntity<List<ReplyVO>>(replyService.findAllByBNO(bno), HttpStatus.OK);
	}
}














