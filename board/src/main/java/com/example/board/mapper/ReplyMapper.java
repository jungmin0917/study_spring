package com.example.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.domain.vo.ReplyVO;

@Mapper
public interface ReplyMapper {
	public int insert(ReplyVO replyVO);
	public ReplyVO select(Long rno);
}
