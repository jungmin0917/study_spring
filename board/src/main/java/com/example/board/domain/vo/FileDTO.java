package com.example.board.domain.vo;

import lombok.Data;

@Data
public class FileDTO {
	private String uuid;
	private String uploadPath; // 카멜 표기법으로 해도 마이배티스에 설정해줬기 때문에 알아서 매핑이 될 것임
	private String fileName;
	private boolean fileType; // 이미지인지 아닌지 여부
	private Long bno;
}
