package cn.gdpu.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.RequestAware;

import cn.gdpu.service.AttendanceService;
import cn.gdpu.service.StudentService;
import cn.gdpu.vo.Attendance;
import cn.gdpu.vo.Student;

import com.opensymphony.xwork2.ActionSupport;

public class AttendanceAction extends ActionSupport implements RequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Attendance attendance;// 接收传来的学生对象
	private String students;// 接收传来的学生学号字符串
	private String clerk;// 接收传来的数据录入人员
	private int aid = -1;// 接收传来的考勤信息ID号

	private AttendanceService attendanceService;
	private StudentService studentService;

	private Map<String, Object> request;

	// 添加考勤信息
	public String add() {
		if (students != null && !students.equals("") && students != "") {
			if (attendance != null) {
				attendance.setStudents(studentService.getStudentsBySnoString(students));
				attendance.setClerk(studentService.getStudent(clerk));
				attendanceService.add(attendance);
				return SUCCESS;
			}
			return ERROR;
		}

		return ERROR;
	}

	// 获取一条考勤信息，用于修改
	public String get() {
		if (aid < 0) {
			return ERROR;
		}
		System.out.println("aid: " + aid);
		Attendance attendance = attendanceService.getAttendanceByAid(aid);
		Set<Student> stus = attendance.getStudents();
		String students = "";
		for (Student stu : stus) {
			students = students + stu.getSno() + ",";
		}
		String clerk = null;
		if(attendance.getClerk() != null) {
			clerk = attendance.getClerk().getSno();
		}
		
		request.put("attendance", attendance);
		request.put("students", students);
		request.put("clerk", clerk);

		return "attendanceUpdate";
	}

	// 修改考勤信息
	public String update() {
		if (attendance != null) {
			attendanceService.update(attendance);
			return "index";
		}
		return ERROR;
	}

	// 删除考勤信息
	public String delete() {
		attendanceService.delete(aid);
		return "index";
	}

	// 列出考勤信息
	public String list() {
		List<Attendance> list = attendanceService.getAllAttendances();
		if (list != null && list.size() > 0) {
			request.put("attendances", list);
			return SUCCESS;
		}
		return ERROR;
	}

	// 跳转到添加页
	public String jumpAdd() {
		return "attendanceAdd";
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}

	public void setStudents(String students) {
		this.students = students;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public void setAttendanceService(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public void setClerk(String clerk) {
		this.clerk = clerk;
	}

}
