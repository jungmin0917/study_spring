package com.example.ex00.dependency.qualifier;

public interface Restaurant {
	
	// 인터페이스 내부에는 private을 쓰지 않음. (인터페이스는 기본적으로 멤버 변수를 정의하거나 값을 할당하는 것이 목적이 아니고, 메소드 시그니처를 정의하는 용도로 사용된다.
	
//	public static final int steak = 80000;
	public int steak = 80000; // static final 생략 가능
	
	// 사이드바 유무 검사 메소드 선언 
	public boolean sidebar();
}
