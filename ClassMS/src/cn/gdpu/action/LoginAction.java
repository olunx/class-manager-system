package cn.gdpu.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import cn.gdpu.service.AdminService;
import cn.gdpu.service.LeaderService;
import cn.gdpu.service.StudentService;
import cn.gdpu.vo.Admin;
import cn.gdpu.vo.Leader;
import cn.gdpu.vo.Student;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private StudentService studentService;
	private LeaderService leaderService;
	private AdminService adminService;
	private String username;
	private String password;
	private int userType;
	private Map<String, Object> session;

	public String login() throws Exception {
		
		switch (userType) {
		// student
		case 0: {
			Student stu = studentService.getStudentByUsernameAndPassword(username, password);
			if (stu != null) {
				session.put("student", stu);
				return "student";
			}
		}
			// leader
		case 1: {
			Leader leader = leaderService.getLeaderByUsernameAndPassword(username, password);
			if (leader != null) {
				session.put("leader", leader);
				return "leader";
			}
			break;
		}
			// admin
		case 2: {
			Admin admin = adminService.getAdminByUsernameAndPassword(username, password);
			if (admin != null) {
				session.put("admin", admin);
				return "admin";
			}
			break;
		}
		}
		return INPUT;

	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public void setLeaderService(LeaderService leaderService) {
		this.leaderService = leaderService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

}
