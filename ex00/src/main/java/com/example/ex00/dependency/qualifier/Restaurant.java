package com.example.ex00.dependency.qualifier;

public interface Restaurant {
	
	// �������̽� ���ο��� private�� ���� ����. (�������̽��� �⺻������ ��� ������ �����ϰų� ���� �Ҵ��ϴ� ���� ������ �ƴϰ�, �޼ҵ� �ñ״�ó�� �����ϴ� �뵵�� ���ȴ�.
	
//	public static final int steak = 80000;
	public int steak = 80000; // static final ���� ����
	
	// ���̵�� ���� �˻� �޼ҵ� ���� 
	public boolean sidebar();
}
