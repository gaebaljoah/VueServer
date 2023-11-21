package com.lime.api.fileBoard.dao;


import com.lime.api.fileBoard.dto.FileBoardDto;
import com.lime.framework.dto.FileDto;
import com.lime.framework.dto.SearchDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FileBoardDao {

    public List<FileBoardDto> selectFileBoardList(SearchDto searchDto);

    public int selectFileBoardListCount(SearchDto searchDto);

    public FileBoardDto selectFileBoard(SearchDto searchDto);

    public int insertFileBoard(FileBoardDto fileBoardDto);

    public int updateFileBoard(FileBoardDto fileBoardDto);

    public int deleteFileBoard(FileBoardDto fileBoardDto);

    public List<FileDto> selectFileList(SearchDto searchDto);

    public FileDto selectFile(SearchDto searchDto);

    public int insertFile(FileDto fileDto);

    public int deleteFile(FileDto fileDto);

}
