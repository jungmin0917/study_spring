package com.example.board.domain.vo;

import lombok.Data;

// 참고용
//  CREATE TABLE JUNGMIN_FILE(
//		UUID VARCHAR2(1000) CONSTRAINT PK_FILE PRIMARY KEY,
//		UPLOAD_PATH VARCHAR2(1000),
//		FILE_NAME VARCHAR2(1000),
//		FILE_TYPE CHAR(1),
//		BNO NUMBER(10),
//		CONSTRAINT FK_FILE 
//		FOREIGN KEY(BNO) REFERENCES JUNGMIN_BOARD(BNO)
//	);

@Data
public class FileVO {
	private String uuid;
	private String uploadPath; // 카멜 표기법으로 해도 마이배티스에 설정해줬기 때문에 알아서 매핑이 될 것임
	private String fileName;
	private boolean fileType; // 이미지인지 아닌지 여부

}
