package cn.gdpu.action;

import cn.gdpu.service.StudentService;
import cn.gdpu.vo.Student;

public class StudentAction {

	private StudentService studentService;
	
	private String username;
	private String password;
	
	public String execute(){
		
		Student stu = new Student();
		stu.setUsername(username);
		stu.setPassword(password);
		studentService.add(stu);
		
		return "success";
	}
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
