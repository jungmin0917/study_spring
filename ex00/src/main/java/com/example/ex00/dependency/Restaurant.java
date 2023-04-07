package com.example.ex00.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Component
//@Getter
@Data
@RequiredArgsConstructor // 자동 생성자 주입 (final 키워드나 NonNull 어노테이션 붙은 클래스만)
public class Restaurant {

	private final Chef chef;
	
//	현재 클래스에 Chef 객체가 종속되어 있는데, 이를 의존성 관리하여 자동 주입하려 한다.
//	@Autowired
//	public Restaurant(Chef chef) { // 생성자 주입
//		this.chef = chef;
//	}
}
