package com.example.ex01.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.ex01.domain.vo.TestVO;

@Mapper
public interface TestMapper {
	public List<TestVO> getList();
}
