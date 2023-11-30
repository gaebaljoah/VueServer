package com.lime.api.freeBoard.service;

import com.lime.api.freeBoard.dao.FreeBoardDao;
import com.lime.api.freeBoard.dto.FreeBoardDto;
import com.lime.framework.dto.SearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FreeBoardService {

	private final FreeBoardDao freeBoardDao;

	public List<FreeBoardDto> selectFreeBoardList(SearchDto searchDto) {
		return freeBoardDao.selectFreeBoardList(searchDto);

	}

	public int selectFreeBoardListCount(SearchDto searchDto) {
		return freeBoardDao.selectFreeBoardListCount(searchDto);

	}

	public FreeBoardDto selectFreeBoard(int seq) {
		return freeBoardDao.selectFreeBoard(seq);
	}

	public int insertFreeBoard(FreeBoardDto freeBoardDto) {
		return freeBoardDao.insertFreeBoard(freeBoardDto);
	}

	public int updateFreeBoard(FreeBoardDto freeBoardDto) {
		return freeBoardDao.updateFreeBoard(freeBoardDto);

	}

	public int deleteFreeBoard(int seq) {
		return freeBoardDao.deleteFreeBoard(seq);
	}
}
