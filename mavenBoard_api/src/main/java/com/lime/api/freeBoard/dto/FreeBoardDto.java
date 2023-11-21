package com.lime.api.freeBoard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FreeBoardDto {
	private int num;
	private String name;
	private String title;
	private String content;
	private String regdate;
}
