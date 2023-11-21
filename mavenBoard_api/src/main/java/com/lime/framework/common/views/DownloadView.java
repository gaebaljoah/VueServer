package com.lime.framework.common.views;


import com.lime.framework.dto.FileDto;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URLEncoder;
import java.util.Map;

@Component
public class DownloadView extends AbstractView {

	private final String path ="c:/uploads/";
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
										   HttpServletResponse response) throws Exception {
		
		FileDto fileDto = (FileDto) model.get("dto");
		File file = new File(path+fileDto.getSaveFileName());

        setContentType("application/download; utf-8");
        response.setContentType(getContentType());
        response.setContentLength((int)file.length());
         
        String userAgent = request.getHeader("User-Agent");
         
        boolean ie = userAgent.indexOf("MSIE") > -1;
         
        String fileName = null;
        
		if(ie){
		    fileName = URLEncoder.encode(fileDto.getOriginalFileName(), "utf-8");
		} else {
		    fileName = new String(fileDto.getOriginalFileName().getBytes("utf-8"));
		}// end if;
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
       
        FileUtils.copyFile(file, response.getOutputStream());
		
	}

}
