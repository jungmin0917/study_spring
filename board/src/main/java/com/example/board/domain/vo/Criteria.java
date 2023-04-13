package com.example.board.domain.vo;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;

// 리스트 페이징용 객체

@Data
public class Criteria {
	private int pageNum; // 현재 페이지 번호
	private int amount; // 페이지당 개수
	private String type;
	private String keyword;

	// 기본 생성자
	public Criteria() {
		this(1, 10);
	}

	// 검색어가 없을 경우의 생성자
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	// 검색어가 있을 경우의 생성자
	public Criteria(int pageNum, int amount, String type, String keyword) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.type = type;
		this.keyword = keyword;
	}
	
	// 기존 GET방식처럼 QueryString에 넣었던 것들을, 변수화하여 사용하는 것이다.
	public String getParams() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("").queryParam("pageNum", this.pageNum);
		
		return builder.toUriString();
	}
	
	// 사용자로부터 입력받은 검색 조건 (ex. TC 등)을 문자열 배열로 반환
	// TC, TW 처럼 다중 조건일 수가 있기 때문에
	public String[] getTypes() {
		// ex) "ABC".split("") --> 3칸 배열 ([A],[B],[C])
		if(type != null) {
			return type.split(""); // 1문자 단위로 끊어서 반환
		}else {
			return new String[] {};
		}
	}


}



