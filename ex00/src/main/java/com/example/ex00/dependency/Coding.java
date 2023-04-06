package com.example.ex00.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Coding {
	
//	���� ��� �Ʒ��� ���� ���� Ŭ���� ������ �ٸ� Ŭ������ ��üȭ�ϸ�, ���� �������� �����
//	Computer computer = new Computer();
	
//	�Ʒ��� ���� �����ϸ�, ��ü�� ���������� �����ϰڴٴ� ���̴�.
	
//	�̷� �� �ʵ� �����̶�� �Ѵ�.
//	������ ���ϰ� ������ �� ������ ��ȯ ����(���ѷ���) �� ������ �߻����� �ʱ� ������, Stack Overflow)�� �߻��Ѵ�.
	@Autowired // �� ���ø����̼� ���ؽ�Ʈ�� �޸𸮿� �ö󰡸鼭 �ڵ����� ��ü ������ ����
	private final Computer computer; // private�� �ٿ��ִ� �� ����
}
