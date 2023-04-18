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
	@PostMapping(value = "/upload", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}) // JSON Ÿ������ ��ȯ
	// �Ϲ� Controller ������̼ǿ��� �ش� �޼ҵ带 REST�� ����ؾ� �� �� �ۼ��� (@ResponseBody)
	@ResponseBody // ViewResolver�� ���� ȭ�� �̵��� �ƴ� �׳� HTTP ���� ������ ���� ���� ��ȯ�ϰڴٴ� ��
	public ResponseEntity<List<FileVO>> upload(MultipartFile[] uploadFiles){ // ���� ������ �޾ƾ� �ϱ⿡ �迭 Ÿ������ ����
		log.info("upload");
		
		List<FileVO> files = new ArrayList<FileVO>();
		String uploadDir = "C:\\upload";
	}
	
	// ���ε� �ð��� �������� Directory���� ������ ������ ������
	public String getDirectoryForm() {
		
	}
}














