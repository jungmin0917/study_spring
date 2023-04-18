package com.example.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
	@PostMapping(value = "/upload", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}) // JSON 타입으로 반환
	// 일반 Controller 어노테이션에서 해당 메소드를 REST로 사용해야 할 때 작성함 (@ResponseBody)
	@ResponseBody // ViewResolver를 통해 화면 이동이 아닌 그냥 HTTP 응답 본문에 현재 값을 반환하겠다는 뜻
	public ResponseEntity<List<FileVO>> upload(MultipartFile[] multipartFiles){ // 여러 파일을 받아야 하기에 배열 타입으로 받음
		log.info("upload");
		
		List<FileVO> files = new ArrayList<FileVO>();
		String uploadDir = "C:\\upload";
		String uploadDatePath = getDirectoryForm();
		
		// 업로드 디렉터리를 File 객체로 생성
		File uploadPath = new File(uploadDir, uploadDatePath);
		log.info("upload path : " + uploadPath);
		
		// 해당 업로드 디렉터리가 없으면 생성
		if(!uploadPath.exists()) {
			uploadPath.mkdirs(); // mkdirs()는 예를 들어 /upload/2023-04-18 이렇게 생성된다고 하면, 중간에 upload 폴더가 없으면 중간 디렉터리까지 생성해준다.
		}
		
		// 외부에서 전달 받은  uploadFiles라는 객체를 순회하면서 가져와줘야 한다.
		for (MultipartFile multipartFile : multipartFiles) {
			// 파일 순회하면서 각 파일 정보 로깅
			log.info("---------------");
			log.info("Upload File Name : " + multipartFile.getOriginalFilename());
			log.info("Upload File Size : " + multipartFile.getSize());
			
			// 각 파일을 각 FileVO 객체에 담아서 files List 객체에 담는다.
			FileVO fileVO = new FileVO();
			
			String originalFileName = multipartFile.getOriginalFilename(); // 업로드할 때 원본 파일명
			String fileName = null; // 객체에 담을 파일명 (UUID가 붙은)
			
			UUID uuid = UUID.randomUUID(); // 128비트의 랜덤 UUID 생성
			fileName = uuid.toString() + "_" + originalFileName; // 중복 없는 파일명 생성

			// fileVO 객체에 정보 담기
			fileVO.setUuid(uuid.toString());
			fileVO.setUploadPath(uploadDatePath); // 전체 경로에서 겹치는 부분은 빼고 올림
			fileVO.setFileName(originalFileName); // UUID 붙기 전의 원본 파일명

			try {
				// 업로드 디렉터리 내부에 아까 만든 파일명으로 File 객체 생성
				File file = new File(uploadPath, fileName);
				// multipartFile 객체의 transferTo() 메소드로 해당 위치에 파일 업로드 (이동시키는 것이 곧 업로드)
				multipartFile.transferTo(file); // 이게 파일 업로드임
				
				// 이제 이미지인지 아닌지 파악해야 한다.
				// 이미지라면, 썸네일까지 만들어서 같이 올려줄 것이다.
				// 일단 Thumbnailator로 만들어주자
				
				// 파일 inputstream으로 위의 파일을 읽어와서 썸네일로 만들고 outputstream으로 업로드할 것이다.
				
				InputStream in = new FileInputStream(file); // 위에서 업로드한 파일을 스트림에 가져옴
				
				if(checkImageType(file)) { // 이미지 파일이면 썸네일 만들어야 함
					fileVO.setFileType(true);
					FileOutputStream out = new FileOutputStream(new File(uploadPath, "t_" + fileName)); // uploadPath 디렉터리 안에 t_업로드파일명 으로 썸네일 파일 스트림을 생성함
					// 원본 파일 스트림, 출력 파일 스트림, 가로, 세로를 입력해준다.
					Thumbnailator.createThumbnail(in, out, 100, 100);
					
					// 스트림 닫음
					in.close();
					out.close();
				}else {
					fileVO.setFileType(false);
				}
				
				// 완성된 fileVO 객체를 files List에 담음
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
	
	// 업로드 시간을 기준으로 Directory마다 나눠서 저장할 생각임
	private String getDirectoryForm() {
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy\\MM\\dd");
		String formatToday = today.format(formatter);
		
		return formatToday;
	}
	
	// 해당 파일이 이미지인지 확인하는 메소드
	private boolean checkImageType(File file) throws IOException { // File 객체를 받아서 체크한다.
		// 해당 path에 있는 파일의 MIME 타입을 반환함
		// File 객체의 toPath는 해당 파일의 path를 반환함
		String contentType = Files.probeContentType(file.toPath());
		return contentType.startsWith("image");
	}
	
	// 파일명을 전달하면 바이트 코드로 반환하는 메소드
	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> display(String fileName){
		log.info("file name : " + fileName);
		
		// DB에 올려놨던 파일명으로 File 객체 생성
		File file = new File("C:\\upload\\" + fileName);
		
		log.info("file : " + file);
		
		ResponseEntity<byte[]> result = null; // 바이트 배열을 담은 엔티티 생성

		HttpHeaders header = new HttpHeaders(); // 스프링 프레임워크의 HttpHeaders 객체 생성
		
		try {
			// 해당 파일 정보로 헤더에 파일의 MIME 타입 전달
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			
			// result에 ResponseEntity 객체 생성하여 file 내용을 바이트코드로 변환한 배열을 담는다. 그리고 만들어 두었던 HttpHeaders 객체와 HttpStatus.OK를 같이 담는다.
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}














