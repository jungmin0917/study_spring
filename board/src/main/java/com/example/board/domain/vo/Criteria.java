package com.example.board.domain.vo;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;

// ����Ʈ ����¡�� ��ü

@Data
@AllArgsConstructor
public class Criteria {
	private int pageNum; // ���� ������ ��ȣ
	private int amount; // �������� ����
	
	public Criteria() {
		this(1, 10);
	}
	
	// ���� GET���ó�� QueryString�� �־��� �͵���, ����ȭ�Ͽ� ����ϴ� ���̴�.
	public String getParams() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("").queryParam("pageNum", this.pageNum);
		
		return builder.toUriString();
	}
}
