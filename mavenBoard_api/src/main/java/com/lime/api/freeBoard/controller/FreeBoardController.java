package com.lime.api.freeBoard.controller;

import com.lime.api.freeBoard.dto.FreeBoardDto;
import com.lime.api.freeBoard.service.FreeBoardService;
import com.lime.framework.dto.SearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class FreeBoardController {

	private final FreeBoardService freeBoardService;

	@RequestMapping(value="/freeBoardList/{searchKey}/{searchValue}", method = RequestMethod.GET)
	public Map<String,Object> freeBoardList(@PathVariable String searchKey,@PathVariable String searchValue){

		System.out.println("freeBoardList의 영역입니다");
		Map<String,Object> map = new HashMap<String,Object>();
		SearchDto searchDto = new SearchDto();

		if(searchKey == null || searchValue==null) {
			System.out.println("searchDto가 없다.");
		}else{
			searchDto.setSearchKey(searchKey);
			searchDto.setSearchValue(searchValue);
		}

		int count = freeBoardService.selectFreeBoardListCount(searchDto);
		map.put("list",  freeBoardService.selectFreeBoardList(searchDto));
		map.put("count", count);
		searchDto.setTotalCnt(count);
		map.put("searchDto", searchDto);
		return map;
	}

	@RequestMapping(value = "/getOnePost/{seq}", method = RequestMethod.GET)
	public FreeBoardDto getOnePost(@PathVariable int seq){
		System.out.println("getOnePost 영역입니다");
		FreeBoardDto result = freeBoardService.selectFreeBoard(seq);
		return result;
	}

	/**
	 * insertFreeBoard - 수정로직
	 * @param freeBoardDto
	 * @return
	 */
	@PostMapping("/insertFreeBoard.ino")
	public int insertFreeBoard(@RequestBody FreeBoardDto freeBoardDto){
		System.out.println("insertFreeBoard의 영역입니다?!?!.");
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
	@RequestMapping(value = "/updateFreeBoard.ino", method = RequestMethod.PUT)
	public int updateFreeBoard(@RequestBody FreeBoardDto freeBoardDto){
		//vue에서 axios에 데이터 부분에 dto 필드명과 일치한 json을 보내면 스프링이 알아서 맞춰준다.
		System.out.println("freeBoardDto...?"+ freeBoardDto.getContent());
		int result = freeBoardService.updateFreeBoard(freeBoardDto);
		return result;
	}
	
	/**
	 * deleteFreeBoard - 삭제로직
	 * @param seq
	 * @return
	 */
	@RequestMapping(value = "/deleteFreeBoard.ino/{seq}", method = RequestMethod.DELETE)
	public int deleteFreeBoard(@PathVariable int seq){
		System.out.println("deleteFreeBoard 영역입니다.");
		System.out.println("seq.,,,?"+seq);
		int result = freeBoardService.deleteFreeBoard(seq);
		return result;
	}
	
	
	
}
