package com.example.board.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

// ������ ������ �����ϱ� ���� ����� ��ü (DTO)

@Data
@NoArgsConstructor // �Ű����� ���� �⺻ ������ ���� (�Ű����� �ִ� �����ڴ� �̸� �������)
public class PageDTO {
	// ���� ������ �������� �� (���� �� �������� ���⼭ ����)
	
	// ���� ������ ���� ���� ���� ������
	private int startPage;
	// ���� ������ ���� ���� ������ ������
	private int endPage;
	// ���� ������ ������
	private int realEnd;
	// ���� ������ �������� ���� ��ư�� ���� ��ư�� ���� �˻�
	private boolean prev, next;
	
	// ���� ������ ��ȣ, �������� ������ ���� �ִ� ����¡�� ��ü
	private Criteria criteria;
	
	// ��ü �Խñ� ��
	private int total;

	// �ܺο��� Criteria�� total���� �޾ƿ� 
	public PageDTO(Criteria criteria, int total) {
		this.criteria = criteria;
		this.total = total;
		
		// ceil(�Ǽ� ��) : �ø� ó��, �������� �Խñ��� �� ���� ������ �ø��� �ؾ� �� (�������� �ϳ� �� �ʿ�)
		this.endPage = (int)(Math.ceil((double)(criteria.getPageNum()) / criteria.getAmount())) * criteria.getAmount();
		
		// total�� DB���� ��ȸ�ؼ� �޾ƿԴٰ� �����ϰ� ���
		// (��ü ������ ���� / amount)�� �Ͽ� �ø��� �Ѵ�
		this.realEnd = (int)(Math.ceil((double)total / criteria.getAmount()));
		
		// ���� ������ ���� ������ �������� ��¥ ������ ���������� ũ��
		if(endPage > realEnd) {
			this.endPage = realEnd;
		}
		
		// endPage���� amount��ŭ ���� �ű⿡ 1�� ���ϸ� ���� ������ ������ startPage�� ���� �� ����
		this.startPage = endPage - criteria.getAmount() + 1;
		
		if(startPage < 1) {
			startPage = 1;
		}
		
		// ���� ������ ������ ���� ������(startPage)�� 1���� ũ�� ���� ������ �ִٴ� ��
		this.prev = this.startPage > 1;
		
		// ���� ������ ������ �� ������(endPage)�� ������ ������(realEnd)���� ������ ���� ������ �ִٴ� ��
		this.next = this.endPage < this.realEnd;
	}
	
	// ������ startPage ~ prev, next�� ���� DTO���� ������
	
	// �ܺ� Ŭ����(DB)���� ��ü ������ ���� �� ���� DTO�� �������ָ� realEnd�� ���� �� �ִ�
	
	// 1 ~ 10 : ������ ���� 1
	// 11 ~ 20 : ������ ���� 2
	// 21 ~ 30 : ������ ���� 3
	
	
}
