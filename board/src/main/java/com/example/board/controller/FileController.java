package com.example.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.board.domain.vo.FileVO;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Log4j

@Controller
public class FileController {
	@PostMapping(value = "/upload", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}) // JSON Ÿ������ ��ȯ
	// �Ϲ� Controller ������̼ǿ��� �ش� �޼ҵ带 REST�� ����ؾ� �� �� �ۼ��� (@ResponseBody)
	@ResponseBody // ViewResolver�� ���� ȭ�� �̵��� �ƴ� �׳� HTTP ���� ������ ���� ���� ��ȯ�ϰڴٴ� ��
	public ResponseEntity<List<FileVO>> upload(MultipartFile[] multipartFiles){ // ���� ������ �޾ƾ� �ϱ⿡ �迭 Ÿ������ ����
		log.info("upload");
		
		List<FileVO> files = new ArrayList<FileVO>();
		String uploadDir = "C:\\upload";
		String uploadDatePath = getDirectoryForm();
		
		// ���ε� ���͸��� File ��ü�� ����
		File uploadPath = new File(uploadDir, uploadDatePath);
		log.info("upload path : " + uploadPath);
		
		// �ش� ���ε� ���͸��� ������ ����
		if(!uploadPath.exists()) {
			uploadPath.mkdirs(); // mkdirs()�� ���� ��� /upload/2023-04-18 �̷��� �����ȴٰ� �ϸ�, �߰��� upload ������ ������ �߰� ���͸����� �������ش�.
		}
		
		// �ܺο��� ���� ����  uploadFiles��� ��ü�� ��ȸ�ϸ鼭 ��������� �Ѵ�.
		for (MultipartFile multipartFile : multipartFiles) {
			// ���� ��ȸ�ϸ鼭 �� ���� ���� �α�
			log.info("---------------");
			log.info("Upload File Name : " + multipartFile.getOriginalFilename());
			log.info("Upload File Size : " + multipartFile.getSize());
			
			// �� ������ �� FileVO ��ü�� ��Ƽ� files List ��ü�� ��´�.
			FileVO fileVO = new FileVO();
			
			String originalFileName = multipartFile.getOriginalFilename(); // ���ε��� �� ���� ���ϸ�
			String fileName = null; // ��ü�� ���� ���ϸ� (UUID�� ����)
			
			UUID uuid = UUID.randomUUID(); // 128��Ʈ�� ���� UUID ����
			fileName = uuid.toString() + "_" + originalFileName; // �ߺ� ���� ���ϸ� ����

			// fileVO ��ü�� ���� ���
			fileVO.setUuid(uuid.toString());
			fileVO.setUploadPath(uploadDatePath); // ��ü ��ο��� ��ġ�� �κ��� ���� �ø�
			fileVO.setFileName(originalFileName); // UUID �ٱ� ���� ���� ���ϸ�

			try {
				// ���ε� ���͸� ���ο� �Ʊ� ���� ���ϸ����� File ��ü ����
				File file = new File(uploadPath, fileName);
				// multipartFile ��ü�� transferTo() �޼ҵ�� �ش� ��ġ�� ���� ���ε� (�̵���Ű�� ���� �� ���ε�)
				multipartFile.transferTo(file); // �̰� ���� ���ε���
				
				// ���� �̹������� �ƴ��� �ľ��ؾ� �Ѵ�.
				// �̹������, ����ϱ��� ���� ���� �÷��� ���̴�.
				// �ϴ� Thumbnailator�� ���������
				
				// ���� inputstream���� ���� ������ �о�ͼ� ����Ϸ� ����� outputstream���� ���ε��� ���̴�.
				
				InputStream in = new FileInputStream(file); // ������ ���ε��� ������ ��Ʈ���� ������
				
				if(checkImageType(file)) { // �̹��� �����̸� ����� ������ ��
					fileVO.setFileType(true);
					FileOutputStream out = new FileOutputStream(new File(uploadPath, "t_" + fileName)); // uploadPath ���͸� �ȿ� t_���ε����ϸ� ���� ����� ���� ��Ʈ���� ������
					// ���� ���� ��Ʈ��, ��� ���� ��Ʈ��, ����, ���θ� �Է����ش�.
					Thumbnailator.createThumbnail(in, out, 100, 100);
					
					// ��Ʈ�� ����
					in.close();
					out.close();
				}else {
					in.close();
					fileVO.setFileType(false);
				}
				
				// �ϼ��� fileVO ��ü�� files List�� ����
				files.add(fileVO);
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return new ResponseEntity<List<FileVO>>(files, HttpStatus.OK);
	}
	
	// ���ε� �ð��� �������� Directory���� ������ ������ ������
	private String getDirectoryForm() {
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy\\MM\\dd");
		String formatToday = today.format(formatter);
		
		return formatToday;
	}
	
	// �ش� ������ �̹������� Ȯ���ϴ� �޼ҵ�
	private boolean checkImageType(File file) throws IOException { // File ��ü�� �޾Ƽ� üũ�Ѵ�.
		// �ش� path�� �ִ� ������ MIME Ÿ���� ��ȯ��
		// File ��ü�� toPath�� �ش� ������ path�� ��ȯ��
		String contentType = Files.probeContentType(file.toPath());
		
		// �ٷΰ��� �̹����� �߰��� ó������� ��
		if(contentType == null) {
			return false;
		}
		
		return contentType.startsWith("image");
	}
	
	// ���ϸ��� �����ϸ� ����Ʈ �ڵ�� ��ȯ�ϴ� �޼ҵ�
	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> display(String fileName){
		log.info("file name : " + fileName);
		
		// DB�� �÷����� ���ϸ����� File ��ü ����
		File file = new File("C:\\upload\\" + fileName);
		
		log.info("file : " + file);
		
		ResponseEntity<byte[]> result = null; // ����Ʈ �迭�� ���� ��ƼƼ ����

		HttpHeaders header = new HttpHeaders(); // ������ �����ӿ�ũ�� HttpHeaders ��ü ����
		
		try {
			// �ش� ���� ������ ����� ������ MIME Ÿ�� ����
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			
			// result�� ResponseEntity ��ü �����Ͽ� file ������ ����Ʈ�ڵ�� ��ȯ�� �迭�� ��´�. �׸��� ����� �ξ��� HttpHeaders ��ü�� HttpStatus.OK�� ���� ��´�.
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// ���� �ٿ�ε� �޼ҵ� (����Ʈ �迭�� ���� ������ ������)
	@GetMapping(value="/download", produces = {MediaType.APPLICATION_OCTET_STREAM_VALUE})
	@ResponseBody
	public ResponseEntity<Resource> download(String fileName) {
		log.info("download ...... " + fileName);
		
		// FileSystemResource�� ���� �ý��ۿ��� ������ �������� ���� Spring�� Resource �������̽� ����ü��.
		// 
		Resource resource = new FileSystemResource("C:\\upload\\" + fileName);
		
		if(!resource.exists()) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}

		// ��ȯ�� �� ResponseEntity�� ����� ���� �������ָ鼭 Ŭ���̾�Ʈ �������� �̰� �ٿ������� �νĽ�Ŵ
		HttpHeaders header = new HttpHeaders();
		
		// �ٿ�ε��� ���� �̸� ������
		String resourceName = resource.getFilename();
		// uuid�� ����������
		resourceName = resourceName.substring(resourceName.indexOf("_") + 1);
		
		try {
			resourceName = new String(resourceName.getBytes("UTF-8"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// �Ʒ� ����� Content-Disposition ������ �����ν� �� ��ȯ���� �ٿ�ε��ϴ� ������ �˸���.
		header.add("Content-Disposition", "attachment; filename=" + resourceName);
		
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}
	
	// ���� �������� ���� �����ϴ� �޼ҵ�
	@PostMapping(value="/delete")
	@ResponseBody
	public void delete(String fileName, String thumbFileName, boolean fileType) { // �̹����̸� ����ϱ��� �����ؾ� �ϹǷ� type�� �޾ƿ�
		log.info("delete file....... " + fileName + ", fileType : " + fileType);
		
		try {
			fileName = URLDecoder.decode(fileName, "UTF-8");
			thumbFileName = URLDecoder.decode(thumbFileName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		log.info("decoded fileName : " + fileName);
		
		File file = new File("C:\\upload\\" + fileName);
		
		log.info(file);
		
		if(file.exists()) {
			log.info("file exists!");
			file.delete();
		}

		if(fileType) {
			// �ϴ� ����� �Ʒ��� �����ߴµ�, �̷��� ������ ����.
			// ���� ���ϸ� t_�� ���� ������ �� ����. �ٵ� �ϴ� �׳� ����..
			log.info("fileType is true");
			
			file = new File("C:\\upload\\" + thumbFileName);
			
			if(file.exists()) {
				file.delete();
			}
		}
	}
}























