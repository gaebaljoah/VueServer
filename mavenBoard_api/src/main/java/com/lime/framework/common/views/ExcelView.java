package com.lime.framework.common.views;

import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Map;
@Component
public class ExcelView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String filename = (String) model.get("filename");
		String template = (String) model.get("template");
		response.setHeader("Content-Type", "application/octet-stream");
		try {
			ClassPathResource classPathResource = new ClassPathResource("templates/"+template+".xlsx");
			File file = classPathResource.getFile();
			InputStream is = new BufferedInputStream(new FileInputStream(file));
			XLSTransformer transformer = new XLSTransformer();
			Workbook resultWorkbook = transformer.transformXLS(is, model);
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.setHeader("filename", URLEncoder.encode(filename, "UTF-8"));
			response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + ".xlsx\"");
			OutputStream os = response.getOutputStream();
			resultWorkbook.write(os);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}