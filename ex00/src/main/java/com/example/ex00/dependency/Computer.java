package com.example.ex00.dependency;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component // �ش� ��ü�� Spring���� �����ϵ��� ����
@Data // ���� ���� �޼��带 �ڵ����� ������ ��
public class Computer {
	// ������ ������ �ϱ� ����, ���������� �̸� �˷��� ��
	
	int data = 1;
}
