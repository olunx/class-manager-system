package cn.gdpu.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import cn.gdpu.service.StudentService;
import cn.gdpu.vo.Student;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private StudentService studentService;
	private Student stu;
	private Map<String, Object> session;

	public String login() throws Exception {
		Student mystu = studentService.getStudentByUsernameAndPassword(stu.getUsername(), stu.getPassword());
		if (mystu != null) {
			session.put("student", mystu);
			return SUCCESS;
		}
		return INPUT;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public Student getStu() {
		return stu;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public Map<String, Object> getSession() {
		return session;
	}

}
