package com.example.board.domain.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;
import com.example.board.mapper.ReplyMapper;

import lombok.RequiredArgsConstructor;

// BoardDAO와 다르게 바로 Class로 만들어준다.

@Repository
@RequiredArgsConstructor // 생성자 주입
public class ReplyDAO {
	
	@Autowired
	private final ReplyMapper replyMapper;
	
	// 댓글 생성
	public boolean register(ReplyVO replyVO) {
		return replyMapper.insert(replyVO) == 1; // 성공했을 때 true 반환
	}
	
	// 댓글 1개 조회
	public ReplyVO findByRNO(Long rno) {
		return replyMapper.select(rno);
	}
	
	// 댓글 삭제
	public boolean remove(Long rno) {
		return replyMapper.delete(rno) == 1; // 성공했을 때 true 반환
	}
	
	// 댓글 전체 삭제 (게시글 번호로 삭제)
	public boolean removeAllByBNO(long bno){
		return replyMapper.deleteAll(bno) != 0; // 1개라도 삭제됐을 시 true 반환
	}

	// 댓글 수정
	public boolean modify(ReplyVO replyVO) {
		return replyMapper.update(replyVO) == 1; // 성공했을 때 true 반환
	}

	// 댓글 전체 조회 (게시글 번호로 조회)
	public List<ReplyVO> findAllByBNO(Criteria criteria, Long bno){
		return replyMapper.selectAll(criteria, bno);
	}
}










