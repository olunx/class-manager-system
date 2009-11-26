package cn.gdpu.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import cn.gdpu.service.FetionService;
import cn.gdpu.util.ActionImpl;
import cn.gdpu.util.excel.StudentExcel;

public class ScoreAction extends ActionImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String fileName;
	private String phone;
	private String pwd;
	private Map<String, Object> request;
	private FetionService fetionService;
	
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
		Map<String, Object> items = StudentExcel.getStudentRegExcel().getScoreData(filePath);
		
		System.out.println("发送成绩");
		//发送飞信
		//fetionService.sendScore(phone, pwd, items);
		
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setFetionService(FetionService fetionService) {
		this.fetionService = fetionService;
	}

}
