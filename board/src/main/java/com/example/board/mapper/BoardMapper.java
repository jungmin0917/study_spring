package com.example.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.domain.vo.BoardDTO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.FileVO;

@Mapper
public interface BoardMapper {
	public List<BoardVO> getList(Criteria criteria); // 게시글 가져오기
	public void insert(BoardDTO board); // 게시글 추가
	public BoardVO read(Long bno); // 게시글 1개 가져오기
	public int delete(Long bno); // 게시글 삭제
	public int update(BoardVO board); // 게시글 수정
	public int getTotal(Criteria criteria); // 게시글 전체 개수 가져오기
	public List<FileVO> getFiles(Long bno); // 게시글 파일 목록 가져오기
}
