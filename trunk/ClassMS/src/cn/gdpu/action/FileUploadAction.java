package cn.gdpu.action;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.util.ServletContextAware;

public class FileUploadAction implements ServletContextAware {

	private List<File> documents;
	private List<String> fileName;
	@SuppressWarnings("unused")
	private List<String> contentType;

	private ServletContext context;

	public void setDocuments(List<File> file) {
		this.documents = file;
	}

	public void setDocumentsFileName(List<String> fileName) {
		this.fileName = fileName;
	}

	public void setDocumentsContentType(List<String> contentType) {
		this.contentType = contentType;
	}

	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	public String execute() throws Exception {

		String targetDirectory = context.getRealPath("/upload");

		File target = null;

		int n = documents.size();

		for (int i = 0; i < n; i++) {
			target = new File(targetDirectory, fileName.get(i));
			FileUtils.copyFile(documents.get(i), target);
		}

		return "success";
	}

}
