package com.example.board.domain.vo;

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
}
