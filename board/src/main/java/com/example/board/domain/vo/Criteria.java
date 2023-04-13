package com.example.board.domain.vo;

import org.springframework.web.util.UriComponentsBuilder;

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
	
	// 기존 GET방식처럼 QueryString에 넣었던 것들을, 변수화하여 사용하는 것이다.
	public String getParams() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("").queryParam("pageNum", this.pageNum);
		
		return builder.toUriString();
	}
}
