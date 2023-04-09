package com.example.ex02.domain.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ProductVO {
	private int productNumber;
	private String productName;
	private int productPrice;
	private int productRate;
}
