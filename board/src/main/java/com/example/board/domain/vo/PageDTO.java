package com.example.board.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

// 페이지 정보를 전송하기 위해 사용할 객체 (DTO)

@Data
@NoArgsConstructor // 매개변수 없는 기본 생성자 만듦 (매개변수 있는 생성자는 미리 적어놨음)
public class PageDTO {
	// 현재 구간을 기준으로 함 (구간 당 페이지도 여기서 정함)
	private int startPage; // 시작 페이지
	private int endPage; // 끝 페이지
	private int realEnd; // 진짜 마지막 페이지
	private boolean prev, next; // 이전 페이지, 다음 페이지 존재 여부
	
	// 현재 페이지 번호, 페이지당 개수를 갖고 있는 페이징용 객체
	private Criteria criteria;
	
	private int total;

	// 외부에서 Criteria랑 total값만 받아옴 
	public PageDTO(Criteria criteria, int total) {
		this.criteria = criteria;
		this.total = total;
		
		// ceil(실수 값) : 올림 처리, 페이지에 게시글이 한 개라도 있으면 올림을 해야 함 (페이지가 하나 더 필요)
		this.endPage = (int)(Math.ceil((double)total / criteria.getAmount())) * criteria.getAmount();
		
		// 만약 위에서 계산된 마지막 페이지가 진짜 마지막 페이지보다 크면
		if(endPage > realEnd) {
			this.endPage = realEnd;
		}
		
		this.startPage = endPage - criteria.getAmount() + 1;
	}
	
	// 나머지 startPage ~ prev, next는 현재 DTO에서 선언함
	
	// 외부 클래스(DB)에서 전체 개수를 구한 후 현재 DTO에 전달해주면 realEnd를 구할 수 있다
	
}
