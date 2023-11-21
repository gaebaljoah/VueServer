package com.lime.api.fileBoard.controller;

import com.lime.api.fileBoard.dto.FileBoardDto;
import com.lime.framework.common.views.DownloadView;
import com.lime.framework.dto.SearchDto;
import com.lime.api.fileBoard.service.FileBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class FileBoardRestController {

	private final FileBoardService fileBoardService;

	@RequestMapping("/fileList")
	public Map<String, Object> fileList(@RequestBody SearchDto searchDto) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (searchDto == null) {
			searchDto = new SearchDto();
		}
		int count = fileBoardService.selectFileBoardListCount(searchDto);
		map.put("list", fileBoardService.selectFileBoardList(searchDto));
		map.put("count", count);
		searchDto.setTotalCnt(count);
		map.put("searchDto", searchDto);
		return map;
	}

	@RequestMapping("/fileBoardDetail")
	public Map<String, Object> fileBoardDetail(@RequestBody SearchDto searchDto) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dto", fileBoardService.selectFileBoard(searchDto));
		map.put("fileList", fileBoardService.selectFileList(searchDto));
		return map;
	}

	/**
	 * insertFileBoard - 수정로직
	 *
	 * @param fileBoardDto
	 * @return
	 */
	@RequestMapping("/insertFileBoard")
	public Map<String, Object> insertFileBoard(@RequestBody FileBoardDto fileBoardDto) {
		int result = fileBoardService.insertFileBoard(fileBoardDto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		return map;
	}

	/**
	 * updateFileBoard - 수정로직
	 *
	 * @param fileBoardDto
	 * @return
	 */
	@RequestMapping("/updateFileBoard")
	public Map<String, Object> updateFileBoard(@RequestBody FileBoardDto fileBoardDto) {
		int result = fileBoardService.updateFileBoard(fileBoardDto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		return map;
	}

	/**
	 * deleteFileBoard - 삭제로직
	 *
	 * @param fileBoardDto
	 * @return
	 */
	@RequestMapping("/deleteFileBoard")
	public Map<String, Object> deleteFileBoard(@RequestBody FileBoardDto fileBoardDto) {
		int result = fileBoardService.deleteFileBoard(fileBoardDto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		return map;
	}
}
