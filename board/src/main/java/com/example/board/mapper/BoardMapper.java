package com.example.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.domain.vo.BoardVO;

@Mapper
public interface BoardMapper {
	public List<BoardVO> getList(); // 게시글 가져오기
	public void insert(BoardVO board); // 게시글 추가
	public BoardVO read(Long bno); // 게시글 1개 가져오기
	public int delete(Long bno); // 게시글 삭제
	public int update(BoardVO board); // 게시글 수정
}
