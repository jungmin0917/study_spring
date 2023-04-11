package com.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.domain.dao.BoardDAO;
import com.example.board.domain.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void register(BoardVO board) {
		boardDAO.register(board);
	}

	@Override
	public BoardVO get(Long bno) {
		return boardDAO.get(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		return boardDAO.modify(board); // ���� ���� ���ڵ尡 0���� �ƴ� �� true ��ȯ
	}

	@Override
	public boolean remove(Long bno) {
		return boardDAO.remove(bno);
	}

	@Override
	public List<BoardVO> getList() {
		return boardDAO.getList();
	}

}
