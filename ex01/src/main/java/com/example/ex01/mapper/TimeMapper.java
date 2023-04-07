package com.example.ex01.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 *  
 * @author jungmin
 *	
 *	Mapper 인터페이스
 *	
 *	SQL을 작성하는 작업은 XML을 이용할 수도 있지만, 최소한의 코드를 작성하기 위해서는 Mapper 인터페이스를 사용한다.
 *	간단한 SQL은 아래와 같이 하면 되고, 좀 길고 복잡해지면 XML 파일을 이용하면 된다.
 *	당연히 SqlSessionFactory 객체와 DataSource 객체가 함께 설정되어 있어야 가능.
 *
 */

@Mapper
public interface TimeMapper {
	
	@Select("SELECT SYSDATE FROM DUAL")
	public String getTime();
	
	// 위와 같이 직접 CRUD 어노테이션이 적혀있으면 그걸로 읽고,
	// 만약 없으면 root-context.xml에 포함된 매퍼 경로를 읽어, 거기에 있는 xml에 적힌 네임스페이스 매퍼와 같은 인터페이스의 메소드명과 xml 파일의 태그 id와 같은 걸 사용하게 된다.
	public String getTime2();
}
