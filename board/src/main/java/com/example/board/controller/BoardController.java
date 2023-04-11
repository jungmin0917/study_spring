package com.example.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.board.service.BoardService;

import lombok.extern.log4j.Log4j;

/**
 * Task		URL				Method		Parameter		Form				URL이동
 * 
 * 전체 목록	/board/list		GET							X					
 * 등록 처리	/board/register	POST		BoardVO			입력화면 필요(글쓰기)	전체 목록으로
 * 조회		/board/read		GET			bno				X					상세페이지로
 * 삭제 처리	/board/remove	GET			bno				입력화면 필요(상세P)		전체 목록으로
 * 수정 처리	/board/modify	POST		BoardVO			입력화면 필요(글쓰기)	글쓰기 페이지로
 * 
 */

@Log4j

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("/list");
		model.addAttribute("boardList", boardService.getList());
	}
}











