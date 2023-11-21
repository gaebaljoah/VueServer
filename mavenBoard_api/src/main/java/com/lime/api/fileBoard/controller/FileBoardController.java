package com.lime.api.fileBoard.controller;

import com.lime.api.fileBoard.service.FileBoardService;
import com.lime.framework.common.views.DownloadView;
import com.lime.framework.dto.SearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequiredArgsConstructor
public class FileBoardController {

    private final FileBoardService fileBoardService;
    private final DownloadView downloadView;


    /**
     * downloadFile - 다운로드
     * @return downloadView
     */
    @RequestMapping("/downloadFile")
    public ModelAndView downloadFile(@RequestParam SearchDto searchDto) {
        return new ModelAndView(downloadView, "dto", fileBoardService.selectFile(searchDto));
    }
}
