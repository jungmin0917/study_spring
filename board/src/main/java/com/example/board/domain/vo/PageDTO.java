package com.example.board.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

// ������ ������ �����ϱ� ���� ����� ��ü (DTO)

@Data
@NoArgsConstructor // �Ű����� ���� �⺻ ������ ���� (�Ű����� �ִ� �����ڴ� �̸� �������)
public class PageDTO {
	// ���� ������ �������� �� (���� �� �������� ���⼭ ����)
	private int startPage; // ���� ������
	private int endPage; // �� ������
	private int realEnd; // ��¥ ������ ������
	private boolean prev, next; // ���� ������, ���� ������ ���� ����
	
	// ���� ������ ��ȣ, �������� ������ ���� �ִ� ����¡�� ��ü
	private Criteria criteria;
	
	private int total;

	// �ܺο��� Criteria�� total���� �޾ƿ� 
	public PageDTO(Criteria criteria, int total) {
		this.criteria = criteria;
		this.total = total;
		
		// ceil(�Ǽ� ��) : �ø� ó��, �������� �Խñ��� �� ���� ������ �ø��� �ؾ� �� (�������� �ϳ� �� �ʿ�)
		this.endPage = (int)(Math.ceil((double)total / criteria.getAmount())) * criteria.getAmount();
		
		// ���� ������ ���� ������ �������� ��¥ ������ ���������� ũ��
		if(endPage > realEnd) {
			this.endPage = realEnd;
		}
		
		this.startPage = endPage - criteria.getAmount() + 1;
	}
	
	// ������ startPage ~ prev, next�� ���� DTO���� ������
	
	// �ܺ� Ŭ����(DB)���� ��ü ������ ���� �� ���� DTO�� �������ָ� realEnd�� ���� �� �ִ�
	
}
