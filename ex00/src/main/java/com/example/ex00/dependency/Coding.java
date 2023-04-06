package com.example.ex00.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@Getter // ���� �׽�Ʈ���� ������ ���� ������ �־��� (getComputer�� ���� ����)
//@AllArgsConstructor // ��� �ʵ��� ������ ������ ���ش�
@RequiredArgsConstructor // �ʿ��� �ʵ常 ������ ������ ���ش�
public class Coding {
	
//	���� ��� �Ʒ��� ���� ���� Ŭ���� ������ �ٸ� Ŭ������ ��üȭ�ϸ�, ���� �������� �����
//	Computer computer = new Computer();

//	�ʵ� ����
//	������ ���ϰ� ������ �� ������ ��ȯ ����(���ѷ���) �� ������ �߻����� �ʱ� ������, Stack Overflow)�� �߻��Ѵ�.
//	final�� ������ ������ �ܺο��� �ش� Ŭ������ ������ �� �־ ���� ������, �ʵ� ������ final�� ���� �� ���ٴ� ������ �ִ� 
	@Autowired // �� ���ø����̼� ���ؽ�Ʈ�� �޸𸮿� �ö󰡸鼭 �ڵ����� ��ü ������ ����
	private final Computer computer; // private�� �ٿ��ִ� �� ����
	
// final ���� NonNull �ٿ�����
//	@Autowired
//	@NonNull
//	private Computer computer;

//	������ ����
//	��ȯ ���� �� �����Ϸ��� ���� �����Ͽ� ������ �߻���Ų��.
//	�����ڸ� ���ؼ� �ܺο��� ���� ������ ������ NullPointerException�� ���.
//	�޸𸮿� �Ҵ��ϸ鼭 �ʱⰪ���� ���ԵǹǷ� final Ű���� ����� �����Ͽ�, �ٸ� ������ ������ �Ұ����Ͽ� ����.
//	������ ������ ���� ������, ��ü ��ü�� �������� �����Ƿ�
//	@Autowired // �̷��� �ϸ� ������ �����̴�
//	public Coding(Computer computer) { // ������ ����
//		super();
//		this.computer = computer;
//	}
	
//	setter ����
//	������ ���ϰ� ������ �� ������ ��ȯ ����(���ѷ���) �� ������ �߻����� �ʱ� ������, Stack Overflow)�� �߻��Ѵ�.
//	setter�� public�̹Ƿ� �ܺο��� ���� ������ �����ϴ� (����)
//	�ٵ� �׷� ��Ȳ�� ���� ���� �ʰ�, setter ������ ��ü�� �� ���Ƽ� ���� ������ �ʴ´�
//	@Autowired // setter ������ ����
//	public void setComputer(Computer computer) { // computer ��ü�� �μ��� �޾� ���� Coding ��ü�� �ʵ�� �־���
//		this.computer = computer;
//	}
//	�ٵ� ���� ���� �Ǹ� setComputer�� ����, ���� ��ü�� ��������߸� �ȴ�.
//	�ٵ� ������������ �츮�� ���� �ʰ� �������� �˾Ƽ� ���ش�.
	
//	���� �޼ҵ带 ����Ͽ� ������ �ϴ� ���� setter �����̶�� �Ѵ�.
}



