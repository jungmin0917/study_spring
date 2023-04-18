package com.example.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.domain.vo.BoardDTO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.FileVO;

@Mapper
public interface BoardMapper {
	public List<BoardVO> getList(Criteria criteria); // �Խñ� ��������
	public void insert(BoardDTO board); // �Խñ� �߰�
	public BoardVO read(Long bno); // �Խñ� 1�� ��������
	public int delete(Long bno); // �Խñ� ����
	public int update(BoardVO board); // �Խñ� ����
	public int getTotal(Criteria criteria); // �Խñ� ��ü ���� ��������
	public List<FileVO> getFiles(Long bno); // �Խñ� ���� ��� ��������
}
