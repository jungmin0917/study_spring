package com.example.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;

@Service
public interface BoardService {
	// 여기 서비스 인터페이스에서 쿼리를 직접적으로 사용할 것임
	// 서비스하는 곳이니까 실제 서비스에 관련된 단어로 메소드명을 짓겠음
	
	// 게시글 등록
	public void register(BoardVO board);
	
	// 특정 게시글 가져오기
	public BoardVO get(Long bno);
	
	// 게시글 수정
	public boolean modify(BoardVO board);
	
	// 게시글 삭제
	public boolean remove(Long bno);
	
	// 전체 게시글 가져오기
	public List<BoardVO> getList(Criteria criteria);
	
	// 전체 게시글 개수 가져오기
	public int getTotal();
}
