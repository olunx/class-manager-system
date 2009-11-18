package cn.gdpu.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import cn.gdpu.service.FetionService;
import cn.gdpu.service.StudentService;
import cn.gdpu.vo.Student;

import com.opensymphony.xwork2.ActionSupport;

public class FetionAction extends ActionSupport implements RequestAware {
	private static final long serialVersionUID = 1L;
	private StudentService studentService;
	private FetionService fetionService;
	private String content;
	private String phone;
	private String pwd;
	private String tophones;
	private Map<String, Object> request;

	public String sendFetionLink() throws Exception {
		List<Student> stulist = studentService.getStudents();
		StringBuffer sb = new StringBuffer();
		for (Student stu : stulist){
			sb.append(stu.getPhoneNo()).append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		request.put("stuphones", sb.toString());
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

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}


}
