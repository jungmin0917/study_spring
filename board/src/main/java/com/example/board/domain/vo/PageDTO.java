package com.example.board.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

// 페이지 정보를 전송하기 위해 사용할 객체 (DTO)

@Data
@NoArgsConstructor // 매개변수 없는 기본 생성자 만듦 (매개변수 있는 생성자는 미리 적어놨음)
public class PageDTO {
	// 현재 구간을 기준으로 함 (구간 당 페이지도 여기서 정함)
	
	// 현재 페이지 구간 기준 시작 페이지
	private int startPage;
	// 현재 페이지 구간 기준 마지막 페이지
	private int endPage;
	// 실제 마지막 페이지
	private int realEnd;
	// 현재 페이지 구간에서 이전 버튼과 다음 버튼의 유무 검사
	private boolean prev, next;
	
	// 현재 페이지 번호, 페이지당 개수를 갖고 있는 페이징용 객체
	private Criteria criteria;
	
	// 전체 게시글 수
	private int total;

	// 외부에서 Criteria랑 total값만 받아옴 
	public PageDTO(Criteria criteria, int total) {
		this.criteria = criteria;
		this.total = total;
		
		// ceil(실수 값) : 올림 처리, 페이지에 게시글이 한 개라도 있으면 올림을 해야 함 (페이지가 하나 더 필요)
		this.endPage = (int)(Math.ceil((double)(criteria.getPageNum()) / criteria.getAmount())) * criteria.getAmount();
		
		// total을 DB에서 조회해서 받아왔다고 가정하고 계산
		// (전체 페이지 개수 / amount)을 하여 올림을 한다
		this.realEnd = (int)(Math.ceil((double)total / criteria.getAmount()));
		
		// 만약 위에서 계산된 마지막 페이지가 진짜 마지막 페이지보다 크면
		if(endPage > realEnd) {
			this.endPage = realEnd;
		}
		
		// endPage에서 amount만큼 빼고 거기에 1을 더하면 현재 페이지 구간의 startPage를 구할 수 있음
		this.startPage = endPage - criteria.getAmount() + 1;
		
		if(startPage < 1) {
			startPage = 1;
		}
		
		// 현재 페이지 구간의 시작 페이지(startPage)가 1보다 크면 이전 구간이 있다는 뜻
		this.prev = this.startPage > 1;
		
		// 현재 페이지 구간의 끝 페이지(endPage)가 마지막 페이지(realEnd)보다 작으면 다음 구간이 있다는 뜻
		this.next = this.endPage < this.realEnd;
	}
	
	// 나머지 startPage ~ prev, next는 현재 DTO에서 선언함
	
	// 외부 클래스(DB)에서 전체 개수를 구한 후 현재 DTO에 전달해주면 realEnd를 구할 수 있다
	
	// 1 ~ 10 : 페이지 구간 1
	// 11 ~ 20 : 페이지 구간 2
	// 21 ~ 30 : 페이지 구간 3
	
	
}
