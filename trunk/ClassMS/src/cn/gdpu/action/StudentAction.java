package cn.gdpu.action;

import java.util.List;

import cn.gdpu.service.StudentService;
import cn.gdpu.util.ReadExcel;
import cn.gdpu.vo.Student;

public class StudentAction {

	private StudentService studentService;

	private String username;
	private String password;
	private String filePath;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
		
		if (filePath == null) {
			return "error";
		}

		List<Student> students = ReadExcel.getReadExcel().getExcelData(filePath);
		
		int resultLength = students.size();
		
		for (int i = 0; i < resultLength; i++) {
			studentService.add(students.get(i));
		}

		return "success";
	}

}
