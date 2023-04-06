package com.example.ex00.dependency;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component // 해당 객체를 Spring에서 관리하도록 설정
@Data // 각종 기초 메서드를 자동으로 생성해 줌
public class Computer {
	// 의존성 주입을 하기 전에, 스프링에게 이를 알려야 함
	
	int data = 1;
}
