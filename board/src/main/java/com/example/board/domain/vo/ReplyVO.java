package com.example.board.domain.vo;

import lombok.Data;

// Âü°í¿ë
//	CREATE TABLE JUNGMIN_REPLY(
//		RNO NUMBER(10),
//		BNO NUMBER(10),
//		REPLY VARCHAR2(1000),
//		REPIYER VARCHAR2(500),
//		REPLYDATE DATE DEFAULT SYSDATE,
//		UPDATEDATE DATE DEFAULT SYSDATE,
//		CONSTRAINT PK_REPLY PRIMARY KEY(RNO),
//		CONSTRAINT FK_REPLY_BOARD FOREIGN KEY(BNO) REFERENCES JUNGMIN_BOARD(BNO)
//	);

@Data
public class ReplyVO {
	private Long rno;
	private Long bno;
	private String reply;
	private String replier;
	private String replyDate;
	private String updateDate;
	
	
}
