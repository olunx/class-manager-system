package cn.gdpu.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import cn.gdpu.util.ActionImpl;
import cn.gdpu.util.excel.StudentExcel;

public class ScoreAction extends ActionImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String fileName;
	private Map<String, Object> request;
	
	//跳转
	public String list() {
		return "addLink";
	}

	//发送处理
	public String send() {
		
		if (fileName == null) {
			return "input";
		}

		String filePath = ServletActionContext.getServletContext().getRealPath("/upload") + "/" + fileName;
		List<String> items = StudentExcel.getStudentRegExcel().getScoreData(filePath);
		
		//这里调用发送数据即可
		for(String s : items) {
			System.out.println(s);
		}
		
		return "input";
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

}
