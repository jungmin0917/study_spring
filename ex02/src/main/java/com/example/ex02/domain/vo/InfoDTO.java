package com.example.ex02.domain.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component // 스프링 컨테이너가 관리하도록 등록
@Data // 기본 메소드들 생성
public class InfoDTO {
	private String name;
	private int age;
}