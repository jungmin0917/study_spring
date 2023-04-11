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
 * Task		URL				Method		Parameter		result		Form				URL이동
 * 
 * 전체 목록	/board/list		GET							List		X					
 * 등록 처리	/board/register	POST		BoardVO			bno			입력화면 필요(글쓰기)	전체 목록으로
 * 조회		/board/read		GET			bno				boardVO		X					
 * 삭제 처리	/board/remove	GET			bno				boolean		입력화면 필요(상세P)		전체 목록으로
 * 수정 처리	/board/modify	POST		BoardVO			boolean		입력화면 필요(글쓰기)	글쓰기 페이지로
 * 
 */

@Log4j

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	// 전체 목록
	@GetMapping("/list")
	public void list(Model model) {
		log.info("/list");
		model.addAttribute("boardList", boardService.getList());
	}
	
	// 등록 처리
	@PostMapping("/register")
	public String register(BoardVO boardVO, RedirectAttributes rttr) {
		log.info("/register : " + boardVO); // boardVO 객체가 넘어왔는지도 확인
		
		boardService.register(boardVO);

//		Session에 Flash 영역이 있고, redirect로 전송을 하면 request 영역이 초기화된다.
//		초기화되기 전에 Flash 영역에 데이터를 저장해놓고, 초기화된 후 Flash 영역에서 데이터를 가지고 온다.
//		데이터를 가져왔다면 Flash 영역에 있던 데이터는 사라진다.
		
//		model.addAttribute("bno", boardVO.getBno());
		rttr.addFlashAttribute("bno", boardVO.getBno());
		
//		redirect로 이동할 때는, 경로 앞에 "redirect:"를 붙여 준다
		return "redirect:/board/list"; // 등록 후 /board/list로 리다이렉트 (이전 Request 내용 비움)
	}
	
	// 조회 (게시글 조회와 수정이 비슷하므로 같이 받는다)
	@GetMapping({"/read", "/modify"})
	public void read(Long bno, HttpServletRequest request, Model model) {
		
		// HttpServletRequest.getRequestURI 메소드를 이용하여 URI를 구한다
		String url = request.getRequestURI();
		String subUrl = url.substring(url.lastIndexOf("/"));
		
		log.info(subUrl + " : " + bno);

		model.addAttribute("board", boardService.get(bno));
	}
	
	// 삭제 처리
	@GetMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		log.info("/remove : " + bno);
		
		if(boardService.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
	}
	
	// 수정 처리
	@PostMapping("/modify")
	public String modify(BoardVO boardVO, RedirectAttributes rttr) {
		log.info("/modify : " + boardVO);
		
		if(boardService.modify(boardVO)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
	}
	
	// 게시글 작성 페이지
	@GetMapping("/register") // 위의 등록 처리와 URL은 같으나 요청 방식이 다름
	public void register() {;} // 이렇게 하면 그냥 요청한 URL과 같은 JSP로 이동함 (이 경우엔 /board/register.jsp)
	
}











