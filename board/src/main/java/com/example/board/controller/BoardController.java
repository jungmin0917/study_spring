package com.example.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.board.domain.vo.BoardVO;
import com.example.board.service.BoardService;

import lombok.extern.log4j.Log4j;

/**
 * Task		URL				Method		Parameter		result		Form				URL�̵�
 * 
 * ��ü ���	/board/list		GET							List		X					
 * ��� ó��	/board/register	POST		BoardVO			bno			�Է�ȭ�� �ʿ�(�۾���)	��ü �������
 * ��ȸ		/board/read		GET			bno				boardVO		X					
 * ���� ó��	/board/remove	GET			bno				boolean		�Է�ȭ�� �ʿ�(��P)		��ü �������
 * ���� ó��	/board/modify	POST		BoardVO			boolean		�Է�ȭ�� �ʿ�(�۾���)	�۾��� ��������
 * 
 */

@Log4j

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	// ��ü ���
	@GetMapping("/list")
	public void list(Model model) {
		log.info("/list");
		model.addAttribute("boardList", boardService.getList());
	}
	
	// ��� ó��
	@PostMapping("/register")
	public String register(BoardVO boardVO, RedirectAttributes rttr) {
		log.info("/register : " + boardVO); // boardVO ��ü�� �Ѿ�Դ����� Ȯ��
		
		boardService.register(boardVO);

//		Session�� Flash ������ �ְ�, redirect�� ������ �ϸ� request ������ �ʱ�ȭ�ȴ�.
//		�ʱ�ȭ�Ǳ� ���� Flash ������ �����͸� �����س���, �ʱ�ȭ�� �� Flash �������� �����͸� ������ �´�.
//		�����͸� �����Դٸ� Flash ������ �ִ� �����ʹ� �������.
		
//		model.addAttribute("bno", boardVO.getBno());
		rttr.addFlashAttribute("bno", boardVO.getBno());
		
//		redirect�� �̵��� ����, ��� �տ� "redirect:"�� �ٿ� �ش�
		return "redirect:/board/list"; // ��� �� /board/list�� �����̷�Ʈ (���� Request ���� ���)
	}
	
	// ��ȸ (�Խñ� ��ȸ�� ������ ����ϹǷ� ���� �޴´�)
	@GetMapping({"/read", "/modify"})
	public void read(Long bno, HttpServletRequest request, Model model) {
		
		// HttpServletRequest.getRequestURI �޼ҵ带 �̿��Ͽ� URI�� ���Ѵ�
		String url = request.getRequestURI();
		String subUrl = url.substring(url.lastIndexOf("/"));
		
		log.info(subUrl + " : " + bno);

		model.addAttribute("board", boardService.get(bno));
	}
	
	// ���� ó��
	@GetMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		log.info("/remove : " + bno);
		
		if(boardService.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
	}
	
	// ���� ó��
	@PostMapping("/modify")
	public String modify(BoardVO boardVO, RedirectAttributes rttr) {
		log.info("/modify : " + boardVO);
		
		if(boardService.modify(boardVO)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
	}
	
	// �Խñ� �ۼ� ������
	@GetMapping("/register") // ���� ��� ó���� URL�� ������ ��û ����� �ٸ�
	public void register() {;} // �̷��� �ϸ� �׳� ��û�� URL�� ���� JSP�� �̵��� (�� ��쿣 /board/register.jsp)
	
}











