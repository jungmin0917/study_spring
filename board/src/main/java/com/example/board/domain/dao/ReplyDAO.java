package com.example.board.domain.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;
import com.example.board.mapper.ReplyMapper;

import lombok.RequiredArgsConstructor;

// BoardDAO�� �ٸ��� �ٷ� Class�� ������ش�.

@Repository
@RequiredArgsConstructor // ������ ����
public class ReplyDAO {
	
	@Autowired
	private final ReplyMapper replyMapper;
	
	// ��� ����
	public boolean register(ReplyVO replyVO) {
		return replyMapper.insert(replyVO) == 1; // �������� �� true ��ȯ
	}
	
	// ��� 1�� ��ȸ
	public ReplyVO findByRNO(Long rno) {
		return replyMapper.select(rno);
	}
	
	// ��� ����
	public boolean remove(Long rno) {
		return replyMapper.delete(rno) == 1; // �������� �� true ��ȯ
	}
	
	// ��� ��ü ���� (�Խñ� ��ȣ�� ����)
	public boolean removeAllByBNO(long bno){
		return replyMapper.deleteAll(bno) != 0; // 1���� �������� �� true ��ȯ
	}

	// ��� ����
	public boolean modify(ReplyVO replyVO) {
		return replyMapper.update(replyVO) == 1; // �������� �� true ��ȯ
	}

	// ��� ��ü ��ȸ (�Խñ� ��ȣ�� ��ȸ)
	public List<ReplyVO> findAllByBNO(Criteria criteria, Long bno){
		return replyMapper.selectAll(criteria, bno);
	}
}










