package cn.gdpu.action;

import java.io.File;
import java.io.IOException;
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

	public String execute() {

		List<String> fileData = null;

		if (documents == null) {
			return "error";
		}

		// 获取在服务器中的目录
		String targetDirectory = context.getRealPath("/upload");

		File target = null;

		int n = documents.size();
		String filePath = null;
		StringBuffer sb = new StringBuffer();
		String targetFile = null;
		for (int i = 0; i < n; i++) {
			
			targetFile = generateFileName(fileName.get(i));
			target = new File(targetDirectory, targetFile);
			
			try {
				FileUtils.copyFile(documents.get(i), target);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			filePath = targetDirectory + "/" + targetFile;
			
			// 读取刚上传的excel文件数据
			fileData = ReadExcel.getReadExcel().getExcelData(filePath);

			//减去最后保存列数的一位
			int resultLength = fileData.size() - 1;
			
			// 获取保存的属性列数
			int columns = Integer.parseInt(fileData.get(resultLength).toString());

			sb.append("<table border=\"1\">");
			for (int j = 0; j < resultLength; j++) {
				if (j % columns == 0)
					sb.append("<tr>");
					sb.append("<td>" + fileData.get(j) + "</td>");
				if (j % columns == 3)
					sb.append("</tr>");
			}
			sb.append("</table>");

			context.setAttribute("filePath", filePath);
		}

		if (fileData != null) {
			context.setAttribute("fileData", sb.toString());
		}

		return "success";
	}
	
	//产生唯一的文件名  
    private synchronized String generateFileName(String filename)  
    {  
        int position=filename.lastIndexOf(".");  
        String ext=filename.substring(position);  
          
        return System.nanoTime()+ext;  
    }  

}
