package com.example.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.domain.vo.FileDTO;

@Mapper
public interface FileMapper {
	// ÷������ �߰�
	public void insert(FileDTO file);
}
