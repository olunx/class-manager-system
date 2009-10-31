package cn.gdpu.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.gdpu.service.StudentService;
import cn.gdpu.util.excel.StudentExcel;
import cn.gdpu.vo.Student;

public class StudentAction {

	private StudentService studentService;

	private String username;
	private String password;
	private String fileName;
	private String savePath;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	// 单个注册
	public String doRegister() {

		Student stu = new Student();
		stu.setUsername(username);
		stu.setPassword(password);
		studentService.add(stu);

		return "success";
	}

	// 批量注册
	public String doRegisters() {
		
		if (fileName == null) {
			return "error";
		}

		String filePath = ServletActionContext.getServletContext().getRealPath(savePath) + "/" +fileName;
		List<Student> students = StudentExcel.getStudentRegExcel().getRegData(filePath);
		
		int resultLength = students.size();
		
		for (int i = 0; i < resultLength; i++) {
			studentService.add(students.get(i));
		}

		return "success";
	}

}
