package com.example.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;

@Service
public interface BoardService {
	// ���� ���� �������̽����� ������ ���������� ����� ����
	// �����ϴ� ���̴ϱ� ���� ���񽺿� ���õ� �ܾ�� �޼ҵ���� ������
	
	// �Խñ� ���
	public void register(BoardVO board);
	
	// Ư�� �Խñ� ��������
	public BoardVO get(Long bno);
	
	// �Խñ� ����
	public boolean modify(BoardVO board);
	
	// �Խñ� ����
	public boolean remove(Long bno);
	
	// ��ü �Խñ� ��������
	public List<BoardVO> getList(Criteria criteria);
	
	// ��ü �Խñ� ���� ��������
	public int getTotal();
}
