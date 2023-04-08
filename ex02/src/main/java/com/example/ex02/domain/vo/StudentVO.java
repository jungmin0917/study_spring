package com.example.ex02.domain.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class StudentVO {
	private int num; // 학생 번호
	private int kor;
	private int eng;
	private int math;
}
