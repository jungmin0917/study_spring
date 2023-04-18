package com.example.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.board.domain.vo.BoardDTO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.FileVO;

@Service
public interface BoardService {
	// ���� ���� �������̽����� ������ ���������� ����� ����
	// �����ϴ� ���̴ϱ� ���� ���񽺿� ���õ� �ܾ�� �޼ҵ���� ������
	
	// �Խñ� ���
	public void register(BoardDTO boardDTO);
	
	// Ư�� �Խñ� ��������
	public BoardVO get(Long bno);
	
	// �Խñ� ����
	public boolean modify(BoardVO board);
	
	// �Խñ� ����
	public boolean remove(Long bno);
	
	// ��ü �Խñ� ��������
	public List<BoardVO> getList(Criteria criteria);
	
	// ��ü �Խñ� ���� ��������
	public int getTotal(Criteria criteria);
	
	// �Խñ� ���� ��� �ҷ�����
	public List<FileVO> getFiles(Long bno);
}
