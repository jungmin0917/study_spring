package com.example.board.domain.vo;

import lombok.Data;

@Data
public class FileDTO {
	private String uuid;
	private String uploadPath; // ī�� ǥ������� �ص� ���̹�Ƽ���� ��������� ������ �˾Ƽ� ������ �� ����
	private String fileName;
	private boolean fileType; // �̹������� �ƴ��� ����
	private Long bno;
}
