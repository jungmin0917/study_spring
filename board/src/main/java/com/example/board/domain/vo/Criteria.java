package com.example.board.domain.vo;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;

// ����Ʈ ����¡�� ��ü

@Data
public class Criteria {
	private int pageNum; // ���� ������ ��ȣ
	private int amount; // �������� ����
	private String type;
	private String keyword;

	// �⺻ ������
	public Criteria() {
		this(1, 10);
	}

	// �˻�� ���� ����� ������
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	// �˻�� ���� ����� ������
	public Criteria(int pageNum, int amount, String type, String keyword) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.type = type;
		this.keyword = keyword;
	}
	
	// ���� GET���ó�� QueryString�� �־��� �͵���, ����ȭ�Ͽ� ����ϴ� ���̴�.
	public String getParams() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("").queryParam("pageNum", this.pageNum);
		
		return builder.toUriString();
	}
	
	// ����ڷκ��� �Է¹��� �˻� ���� (ex. TC ��)�� ���ڿ� �迭�� ��ȯ
	// TC, TW ó�� ���� ������ ���� �ֱ� ������
	public String[] getTypes() {
		// ex) "ABC".split("") --> 3ĭ �迭 ([A],[B],[C])
		if(type != null) {
			return type.split(""); // 1���� ������ ��� ��ȯ
		}else {
			return new String[] {};
		}
	}


}



