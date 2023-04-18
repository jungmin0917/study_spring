package com.example.board.domain.vo;

import lombok.Data;

// �����
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
	private String uploadPath; // ī�� ǥ������� �ص� ���̹�Ƽ���� ��������� ������ �˾Ƽ� ������ �� ����
	private String fileName;
	private boolean fileType; // �̹������� �ƴ��� ����

}
