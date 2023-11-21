package com.lime.api.freeBoard.controller;

import com.lime.api.freeBoard.dto.FreeBoardDto;
import com.lime.api.freeBoard.service.FreeBoardService;
import com.lime.framework.dto.SearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class FreeBoardController {

	@Autowired
	private final FreeBoardService freeBoardService;

	@RequestMapping("/freeBoardList")
	public Map<String,Object> freeBoardList(SearchDto searchDto){
		Map<String,Object> map = new HashMap<String,Object>();
		if(searchDto == null) {
			searchDto = new SearchDto();
		}
		int count = freeBoardService.selectFreeBoardListCount(searchDto);   
		map.put("list",  freeBoardService.selectFreeBoardList(searchDto));
		map.put("count", count);
		searchDto.setTotalCnt(count);
		map.put("searchDto", searchDto);
		return map;
	}
	
	/**
	 * insertFreeBoard - 수정로직
	 * @param freeBoardDto
	 * @return
	 */
	@RequestMapping("/insertFreeBoard.ino")
	public Map<String,Object> insertFreeBoard(FreeBoardDto freeBoardDto){
		Map<String,Object> map = new HashMap<String,Object>();
		int result = freeBoardService.insertFreeBoard(freeBoardDto);
		map.put("result", result);
		return map;
	}
	
	/**
	 * updateFreeBoard - 수정로직
	 * @param freeBoardDto
	 * @return
	 */
	@RequestMapping("/updateFreeBoard.ino")
	public Map<String,Object> updateFreeBoard(FreeBoardDto freeBoardDto){
		Map<String,Object> map = new HashMap<String,Object>();
		int result = freeBoardService.updateFreeBoard(freeBoardDto);
		map.put("result", result);
		return map;
	}
	
	/**
	 * deleteFreeBoard - 삭제로직
	 * @param freeBoardDto
	 * @return
	 */
	@RequestMapping("/deleteFreeBoard.ino")
	public Map<String,Object> deleteFreeBoard(FreeBoardDto freeBoardDto){
		Map<String,Object> map = new HashMap<String,Object>();
		int result = freeBoardService.deleteFreeBoard(freeBoardDto);
		map.put("result", result);
		return map;
	}
	
	
	
}
