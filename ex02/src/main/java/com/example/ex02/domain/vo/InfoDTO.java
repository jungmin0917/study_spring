package com.example.ex02.domain.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component // ������ �����̳ʰ� �����ϵ��� ���
@Data // �⺻ �޼ҵ�� ����
public class InfoDTO {
	private String name;
	private int age;
}