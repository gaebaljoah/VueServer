package com.lime.api.fileBoard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileBoardDto {
	private int num;
	private String name;
	private String title;
	private String content;
	private String regdate;
	
	private String[] delFileList;
	private List<MultipartFile> files;
}
