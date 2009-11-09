package cn.gdpu.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.gdpu.service.StudentService;
import cn.gdpu.util.excel.StudentExcel;
import cn.gdpu.vo.Student;

public class RegisterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private StudentService studentService;
	private Map<String, Object> request;

	private String username;
	private String password;
	private String fileName;
	private String savePath;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
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
	
	/**
	 * 注册跳转
	 * @return
	 */
	public String regLink() {
		return INPUT;
	}

	// 单个注册
	public String doStuReg() {

		Student stu = new Student();
		stu.setUsername(username);
		stu.setPassword(password);
		studentService.add(stu);

		return "success";
	}

	// 批量注册
	public String doStudentsReg() {

		if (fileName == null) {
			return "error";
		}

		String filePath = ServletActionContext.getServletContext().getRealPath(savePath) + "/" + fileName;
		List<Student> students = StudentExcel.getStudentRegExcel().getRegData(filePath);

		int resultLength = students.size();

		for (int i = 0; i < resultLength; i++) {
			studentService.add(students.get(i));
		}

		return "success";
	}

	// 查询全部学生
	public String doQueryAll() throws Exception {
		try {
			List<Student> students = new ArrayList<Student>();
			students = studentService.getStudents();
			request.put("req", students);
			
			return SUCCESS;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return ERROR;
	}

}
