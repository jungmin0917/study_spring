package com.example.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.domain.vo.BoardVO;

@Mapper
public interface BoardMapper {
	public List<BoardVO> getList(); // 게시글 가져오기
	public void insert(BoardVO board); // 게시글 추가
}
