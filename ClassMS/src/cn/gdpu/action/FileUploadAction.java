package cn.gdpu.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.util.ServletContextAware;


import cn.gdpu.util.ReadExcel;

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

		List<String> fileData = null;

		if (documents == null) {
			return "error";
		}

		String targetDirectory = context.getRealPath("/upload");

		File target = null;

		int n = documents.size();

		for (int i = 0; i < n; i++) {
			target = new File(targetDirectory, fileName.get(i));
			FileUtils.copyFile(documents.get(i), target);
			
			fileData = getExcelData(targetDirectory + fileName.get(i));
			
			context.setAttribute("fileName", fileName.get(i));
		}
		if(fileData != null)
			context.setAttribute("fileData", fileData.toString());
		return "success";
	}

	private List<String> getExcelData(String filePath) {

		ReadExcel re = new ReadExcel();
		List<Object> result = re.readExcel(filePath);

		if (result != null) {
			List<String> data = new ArrayList<String>();

			int resultLength = result.size();
			int columns = Integer.parseInt(result.get(resultLength - 1)
					.toString());

			System.out.println("columns  " + columns);
			System.out.println("result  " + result);

			int dorm = -1, name = -1, qq = -1, phone = -1;

			String text;
			for (int i = 0; i < columns; i++) {
				text = result.get(i).toString();
				// System.out.println(text);
				if (text.contains("宿舍")) {
					dorm = i;
				} else if (text.contains("姓名")) {
					name = i;
				} else if (text.contains("QQ")) {
					qq = i;
				} else if (text.contains("手机")) {
					phone = i;
				}
			}

			int lastLoop = resultLength - columns;
			for (int i = columns, j = 1; i < lastLoop; j++) {
				data.add((String) result.get(i + name));
				System.out.println(j + " dorm: " + result.get(i + dorm));
				System.out.println(j + " name: " + result.get(i + name));
				System.out.println(j + " qq: " + result.get(i + qq));
				System.out.println(j + " phone: " + result.get(i + phone));
				System.out.println();

				i = i + columns;
			}

			return data;
		}

		return null;
	}

}
