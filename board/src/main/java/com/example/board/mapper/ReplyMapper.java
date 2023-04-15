package com.example.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;

@Mapper
public interface ReplyMapper {
	public int insert(ReplyVO replyVO);
	public ReplyVO select(Long rno);
	public int delete(Long rno);
	public int deleteAll(Long bno);
	public int update(ReplyVO replyVO);
	

	// 매개변수가 두 개인 경우가 드물다. (원래 둘 중 하나의 객체에 다 넣어서 넘김)
	// 그래서 각각의 매개변수에 @Param 어노테이션으로, 각각의 키값을 직접 대입해준다
	public List<ReplyVO> selectAll(@Param("cri") Criteria criteria, @Param("bno") Long bno);
}
