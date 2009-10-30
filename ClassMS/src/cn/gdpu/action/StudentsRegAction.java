package cn.gdpu.action;

import java.util.List;

import cn.gdpu.service.StudentService;
import cn.gdpu.util.ReadExcel;
import cn.gdpu.vo.Student;

public class StudentsRegAction {

	private StudentService studentService;
	private String filePath;

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String execute() {

		if (filePath == null) {
			return "error";
		}
		
		List<String> fileData = ReadExcel.getReadExcel().getExcelData(filePath);

		// 减去最后保存列数的一位
		int resultLength = fileData.size() - 1;

		// 获取保存的属性列数
		int columns = Integer.parseInt(fileData.get(resultLength).toString());

		Student stu;
		for (int i = columns; i < resultLength;) {
			stu = new Student();
			stu.setRealName(fileData.get(i++));
			stu.setDorm(fileData.get(i++));
			stu.setQq(Integer.parseInt(fileData.get(i++)));
			stu.setPhoneNo(Long.parseLong(fileData.get(i++)));
			studentService.add(stu);
			i = i + columns;
		}

		return "success";
	}
}
