package com.example.board.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;


// 리스트 페이징용 객체

@Data
@AllArgsConstructor
public class Criteria {
	private int pageNum; // 현재 페이지 번호
	private int amount; // 페이지당 개수
	
	public Criteria() {
		this(1, 10);
	}
}
