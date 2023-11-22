package com.lime.api.freeBoard.controller;

import com.lime.api.freeBoard.dto.FreeBoardDto;
import com.lime.api.freeBoard.service.FreeBoardService;
import com.lime.framework.dto.SearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class FreeBoardController {

	private final FreeBoardService freeBoardService;

	@RequestMapping("/freeBoardList")
	public Map<String,Object> freeBoardList(SearchDto searchDto){
		System.out.println("freeBoardList의 영역입니다");
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

	@RequestMapping("/getOnePost")
	public FreeBoardDto getOnePost(int seq){
		System.out.println("getOnePost 영역입니다");
		FreeBoardDto post = freeBoardService.selectFreeBoard(seq);
		return post;
	}

	/**
	 * insertFreeBoard - 수정로직
	 * @param freeBoardDto
	 * @return
	 */
	@PostMapping("/insertFreeBoard.ino")
	public int insertFreeBoard(FreeBoardDto freeBoardDto){
		System.out.println("insertFreeBoard의 영역입니다.");
		System.out.println("getName..?"+freeBoardDto.getName());
		System.out.println("getContent..?"+freeBoardDto.getContent());
		System.out.println("getTitle..?"+freeBoardDto.getTitle());
		System.out.println("getRegdate..?"+freeBoardDto.getRegdate());
		int result = freeBoardService.insertFreeBoard(freeBoardDto);
		System.out.println("result...?"+result);
		return result;
	}
	
	/**
	 * updateFreeBoard - 수정로직
	 * @param freeBoardDto
	 * @return
	 */
	@RequestMapping("/updateFreeBoard.ino")
	public int updateFreeBoard(FreeBoardDto freeBoardDto){

		Map<String,Object> map = new HashMap<String,Object>();
		int result = freeBoardService.updateFreeBoard(freeBoardDto);
		return result;
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
