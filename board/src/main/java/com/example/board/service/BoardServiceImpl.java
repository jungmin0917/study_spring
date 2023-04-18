package com.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.domain.dao.BoardDAO;
import com.example.board.domain.dao.FileDAO;
import com.example.board.domain.vo.BoardDTO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.FileDTO;
import com.example.board.domain.vo.FileVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	// 여기서 첨부파일도 같이 등록해줄 것임
	@Autowired
	private FileDAO fileDAO;
	
	@Override
	public void register(BoardDTO board) {
		boardDAO.register(board); // 여기서 before 쿼리로 이미 시퀀스의 NEXTVAL 값으로 bno를 받아왔다.
		// 그러므로 아래의 setBno에서는 board 객체의 bno를 쓸 수 있다.
		
		// board.getFiles : boardDTO의 getter 메소드로 파일 객체를 가져옴
		// boardDTO 객체로부터 Files 객체 (FileVO 리스트 객체)를 가져와서 순회하면서 FileDTO에 다 담고 거기에 bno (게시글 번호)를 추가한다
		for (FileVO file : board.getFiles()) {
			FileDTO fileDTO = new FileDTO();
			fileDTO.setUuid(file.getUuid());
			fileDTO.setUploadPath(file.getUploadPath());
			fileDTO.setFileName(file.getFileName());
			fileDTO.setFileType(file.isFileType());
			fileDTO.setBno(board.getBno()); // 게시글 번호를 별도로 추가한다 (방금 추가된 게시글의 번호)

			fileDAO.register(fileDTO); // 해당 fileDTO를 가지고 파일 하나하나를 DB에 등록한다.
		}
	}

	@Override
	public BoardVO get(Long bno) {
		return boardDAO.get(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		return boardDAO.modify(board); // 영향 받은 레코드가 0건이 아닐 때 true 반환
	}

	@Override
	public boolean remove(Long bno) {
		return boardDAO.remove(bno);
	}

	@Override
	public List<BoardVO> getList(Criteria criteria) {
		return boardDAO.getList(criteria);
	}
	
	@Override
	public int getTotal(Criteria criteria) {
		return boardDAO.getTotal(criteria);
	}
	
	@Override
	public List<FileVO> getFiles(Long bno) {
		return boardDAO.getFiles(bno);
	}

}
