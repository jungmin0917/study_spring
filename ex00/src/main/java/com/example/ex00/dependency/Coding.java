package com.example.ex00.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@Getter // 단위 테스트에서 오류가 나기 때문에 넣었음 (getComputer가 없기 때문)
//@AllArgsConstructor // 모든 필드의 생성자 주입을 해준다
@RequiredArgsConstructor // 필요한 필드만 생성자 주입을 해준다
public class Coding {
	
//	예를 들어 아래와 같이 직접 클래스 내에서 다른 클래스를 객체화하면, 서로 의존성이 생긴다
//	Computer computer = new Computer();

//	필드 주입
//	굉장히 편하게 주입할 수 있으나 순환 참조(무한루프) 시 오류가 발생하지 않기 때문에, Stack Overflow)가 발생한다.
//	final을 붙이지 않으면 외부에서 해당 클래스를 수정할 수 있어서 좋지 않은데, 필드 주입은 final을 붙일 수 없다는 단점이 있다 
	@Autowired // 웹 어플리케이션 컨텍스트가 메모리에 올라가면서 자동으로 객체 관리를 해줌
	private final Computer computer; // private은 붙여주는 게 좋다
	
// final 말고 NonNull 붙여보기
//	@Autowired
//	@NonNull
//	private Computer computer;

//	생성자 주입
//	순환 참조 시 컴파일러가 인지 가능하여 오류를 발생시킨다.
//	생성자를 통해서 외부에서 값이 들어오지 않으면 NullPointerException이 뜬다.
//	메모리에 할당하면서 초기값으로 주입되므로 final 키워드 사용이 가능하여, 다른 곳에서 변형이 불가능하여 좋다.
//	의존성 주입이 되지 않으면, 객체 자체가 생성되지 않으므로
//	@Autowired // 이렇게 하면 생성자 주입이다
//	public Coding(Computer computer) { // 생성자 선언
//		super();
//		this.computer = computer;
//	}
	
//	setter 주입
//	굉장히 편하게 주입할 수 있으나 순환 참조(무한루프) 시 오류가 발생하지 않기 때문에, Stack Overflow)가 발생한다.
//	setter는 public이므로 외부에서 직접 주입이 가능하다 (장점)
//	근데 그런 상황이 거의 오지 않고, setter 주입을 대체할 게 많아서 굳이 쓰지는 않는다
//	@Autowired // setter 의존성 주입
//	public void setComputer(Computer computer) { // computer 객체를 인수로 받아 현재 Coding 객체의 필드로 넣어줌
//		this.computer = computer;
//	}
//	근데 위와 같이 되면 setComputer를 쓰고, 넣을 객체를 전달해줘야만 된다.
//	근데 스프링에서는 우리가 하지 않고 스프링이 알아서 해준다.
	
//	위의 메소드를 사용하여 주입을 하는 것을 setter 주입이라고 한다.
}



