package cn.gdpu.action;

import cn.gdpu.service.FetionService;
import cn.gdpu.service.StudentService;

import com.opensymphony.xwork2.ActionSupport;

public class FetionAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private StudentService studentService;
	private FetionService fetionService;
	private String content;
	private String phone;
	private String pwd;
	private String tophones;

	public String sendFetionLink() throws Exception {
		return SUCCESS;
	}
	
	public String sendFetion() throws Exception {
		fetionService.sendFetion(phone, pwd, tophones, content);
		return SUCCESS;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public void setFetionService(FetionService fetionService) {
		this.fetionService = fetionService;
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

	public String getTophones() {
		return tophones;
	}

	public void setTophones(String tophones) {
		this.tophones = tophones;
	}


}
