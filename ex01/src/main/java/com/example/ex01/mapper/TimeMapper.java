package com.example.ex01.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 *  
 * @author jungmin
 *	
 *	Mapper �������̽�
 *	
 *	SQL�� �ۼ��ϴ� �۾��� XML�� �̿��� ���� ������, �ּ����� �ڵ带 �ۼ��ϱ� ���ؼ��� Mapper �������̽��� ����Ѵ�.
 *	������ SQL�� �Ʒ��� ���� �ϸ� �ǰ�, �� ��� ���������� XML ������ �̿��ϸ� �ȴ�.
 *	�翬�� SqlSessionFactory ��ü�� DataSource ��ü�� �Բ� �����Ǿ� �־�� ����.
 *
 */

@Mapper
public interface TimeMapper {
	
	@Select("SELECT SYSDATE FROM DUAL")
	public String getTime();
	
	// ���� ���� ���� CRUD ������̼��� ���������� �װɷ� �а�,
	// ���� ������ root-context.xml�� ���Ե� ���� ��θ� �о�, �ű⿡ �ִ� xml�� ���� ���ӽ����̽� ���ۿ� ���� �������̽��� �޼ҵ��� xml ������ �±� id�� ���� �� ����ϰ� �ȴ�.
	public String getTime2();
}
