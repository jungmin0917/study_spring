package com.example.ex02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.ex02.domain.vo.TestVO;

@Mapper
public interface TestMapper {
	public List<TestVO> getList();
}
