package com.example.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.board.domain.vo.FileVO;

import lombok.extern.log4j.Log4j;

@Log4j

@Controller
public class FileController {
	@PostMapping(value = "/upload", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}) // JSON 타입으로 반환
	// 일반 Controller 어노테이션에서 해당 메소드를 REST로 사용해야 할 때 작성함 (@ResponseBody)
	@ResponseBody // ViewResolver를 통해 화면 이동이 아닌 그냥 HTTP 응답 본문에 현재 값을 반환하겠다는 뜻
	public ResponseEntity<List<FileVO>> upload(MultipartFile[] uploadFiles){ // 여러 파일을 받아야 하기에 배열 타입으로 받음
		log.info("upload");
		
		List<FileVO> files = new ArrayList<FileVO>();
		String uploadDir = "C:\\upload";
	}
	
	// 업로드 시간을 기준으로 Directory마다 나눠서 저장할 생각임
	public String getDirectoryForm() {
		
	}
}














