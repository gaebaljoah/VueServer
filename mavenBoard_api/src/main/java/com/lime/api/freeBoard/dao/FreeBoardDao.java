package com.lime.api.freeBoard.dao;


import com.lime.api.freeBoard.dto.FreeBoardDto;
import com.lime.framework.dto.SearchDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FreeBoardDao {

    public List<FreeBoardDto> selectFreeBoardList(SearchDto searchDto);

    public int selectFreeBoardListCount(SearchDto searchDto);

    public FreeBoardDto selectFreeBoard(SearchDto searchDto);

    public int insertFreeBoard(FreeBoardDto freeBoardDto);

    public int updateFreeBoard(FreeBoardDto freeBoardDto);

    public int deleteFreeBoard(FreeBoardDto freeBoardDto);
}
