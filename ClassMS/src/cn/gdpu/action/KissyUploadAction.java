package cn.gdpu.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class KissyUploadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private File imgFile;
	private String fileName;
	private String savePath;
	private String imgUrl;
	
	
	

	public String execute() throws Exception {
		
		if(imgFile == null)
			return ERROR;
		
		ServletContext context = ServletActionContext.getServletContext();
		
		// 获取在服务器中的目录
		String targetDirectory = context.getRealPath(savePath);
		
		File target = null;
		String targetFileName = null;
		targetFileName = generateFileName(fileName);
		target = new File(targetDirectory, targetFileName);
		
		try {
			FileUtils.copyFile(imgFile, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imgUrl = context.getContextPath() + savePath + "/" + targetFileName;
		context.setAttribute("imgUrl", imgUrl);
		return SUCCESS;
	}

	//产生唯一的文件名  
    private synchronized String generateFileName(String filename)  
    {  
        int position=filename.lastIndexOf(".");  
        String ext=filename.substring(position);  
          
        return System.nanoTime()+ext;  
    }
	
	//Getter and Setter
	public File getImgFile() {
		return imgFile;
	}

	public void setImgFile(File imgFile) {
		this.imgFile = imgFile;
	}
	
	public void setImgFileFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
