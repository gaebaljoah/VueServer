package com.lime.api.fileBoard.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.lime.api.fileBoard.dao.FileBoardDao;
import com.lime.api.fileBoard.dto.FileBoardDto;
import com.lime.framework.dto.FileDto;
import com.lime.framework.dto.SearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
@RequiredArgsConstructor
public class FileBoardService {

    private final FileBoardDao fileBoardDao;

    public List<FileBoardDto> selectFileBoardList(SearchDto searchDto) {
        return fileBoardDao.selectFileBoardList(searchDto);
    }

    public int selectFileBoardListCount(SearchDto searchDto) {
        return fileBoardDao.selectFileBoardListCount(searchDto);

    }

    public FileBoardDto selectFileBoard(SearchDto searchDto) {
        return fileBoardDao.selectFileBoard(searchDto);
    }

    public int insertFileBoard(FileBoardDto fileBoardDto) {

        fileBoardDao.insertFileBoard(fileBoardDto);
        try {
            List<FileDto> fileDtos = uploadFile(fileBoardDto.getFiles(), fileBoardDto.getNum());
            for (FileDto fileDto : fileDtos) {
                this.insertFile(fileDto);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 1;
    }

    public int updateFileBoard(FileBoardDto fileBoardDto) {
        fileBoardDao.updateFileBoard(fileBoardDto);
        for (String num : fileBoardDto.getDelFileList()) {
            FileDto fileDto = new FileDto();
            fileDto.setfNum(Integer.parseInt(num));
            deleteFile(fileDto);
        }
        try {
            List<FileDto> fileDtos = uploadFile(fileBoardDto.getFiles(), fileBoardDto.getNum());
            for (FileDto fileDto : fileDtos) {
                this.insertFile(fileDto);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 1;
    }

    public int deleteFileBoard(FileBoardDto fileBoardDto) {
        return fileBoardDao.deleteFileBoard(fileBoardDto);
    }

    public List<FileDto> selectFileList(SearchDto searchDto) {
        return fileBoardDao.selectFileList(searchDto);
    }

    public FileDto selectFile(SearchDto searchDto) {
        return fileBoardDao.selectFile(searchDto);
    }

    public int insertFile(FileDto fileDto) {
        return fileBoardDao.insertFile(fileDto);
    }

    public int deleteFile(FileDto fileDto) {
        return fileBoardDao.deleteFile(fileDto);
    }

    private final String path = "/c:/uploads/";

    private List<FileDto> uploadFile(List<MultipartFile> files, int num) throws IOException {
        List<FileDto> results = new ArrayList<>();
        for (MultipartFile file : files) {
            String fileName = getUuid();
            File uploadfile = new File(path + fileName);
            file.transferTo(uploadfile);

            FileDto fileDto = new FileDto();
            fileDto.setNum(num);
            fileDto.setFileSize(file.getSize() + "");
            fileDto.setSaveFileName(fileName);
            fileDto.setOriginalFileName(file.getOriginalFilename());
            results.add(fileDto);
        }
        return results;
    }

    private String getUuid() {
        return UUID.randomUUID().toString();
    }


}
