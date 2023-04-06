package com.example.ex00.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Coding {
	
//	예를 들어 아래와 같이 직접 클래스 내에서 다른 클래스를 객체화하면, 서로 의존성이 생긴다
//	Computer computer = new Computer();
	
//	아래와 같이 선언하면, 객체를 스프링에서 관리하겠다는 것이다.
	
//	이런 걸 필드 주입이라고 한다.
//	굉장히 편하게 주입할 수 있으나 순환 참조(무한루프) 시 오류가 발생하지 않기 때문에, Stack Overflow)가 발생한다.
	@Autowired // 웹 어플리케이션 컨텍스트가 메모리에 올라가면서 자동으로 객체 관리를 해줌
	private final Computer computer; // private은 붙여주는 게 좋다
}
