package com.example.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.domain.vo.BoardVO;

@Mapper
public interface BoardMapper {
	public List<BoardVO> getList(); // �Խñ� ��������
	public void insert(BoardVO board); // �Խñ� �߰�
	public BoardVO read(Long bno); // �Խñ� 1�� ��������
	public int delete(Long bno); // �Խñ� ����
	public int update(BoardVO board); // �Խñ� ����
}
