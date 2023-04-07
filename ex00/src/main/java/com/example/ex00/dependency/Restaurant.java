package com.example.ex00.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Component
//@Getter
@Data
@RequiredArgsConstructor // �ڵ� ������ ���� (final Ű���峪 NonNull ������̼� ���� Ŭ������)
public class Restaurant {

	private final Chef chef;
	
//	���� Ŭ������ Chef ��ü�� ���ӵǾ� �ִµ�, �̸� ������ �����Ͽ� �ڵ� �����Ϸ� �Ѵ�.
//	@Autowired
//	public Restaurant(Chef chef) { // ������ ����
//		this.chef = chef;
//	}
}
