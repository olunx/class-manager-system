package cn.gdpu.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import cn.gdpu.service.AttendanceService;
import cn.gdpu.service.StudentService;
import cn.gdpu.vo.Attendance;

import com.opensymphony.xwork2.ActionSupport;

public class AttendanceAction extends ActionSupport implements RequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Attendance attendance;// 接收传来的学生对象
	private String students;// 接收传来的学生学号字符串
	private int aid;// 接收传来的考勤信息ID号

	private AttendanceService attendanceService;
	private StudentService studentService;

	private Map<String, Object> request;

	public String add() {
		if (students != null && !students.equals("") && students != "") {
			if (attendance != null) {
				attendance.setStudents(studentService.getStudentsBySnoString(students));
				attendanceService.add(attendance);
				return SUCCESS;
			}
			return ERROR;
		}

		return ERROR;
	}

	public String update() {
		if (attendance != null) {
			attendanceService.update(attendance);
			return SUCCESS;
		}
		return ERROR;
	}

	public String delete() {
		attendanceService.delete(aid);
		return SUCCESS;
	}

	public String list() {
		List<Attendance> list = attendanceService.getAllAttendances();
		if (list != null && list.size() > 0) {
			request.put("attendances", list);
			return "list";
		}
		return ERROR;
	}

	public String link() {
		return SUCCESS;
	}

	public String addlink() {
		return "addlink";
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

}
