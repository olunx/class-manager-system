package cn.gdpu.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import cn.gdpu.service.StudentService;
import cn.gdpu.vo.Duty;
import cn.gdpu.vo.Student;

import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport implements RequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int stuId = -1;
	private String avatar;
	private String username;
	private String password;
	private String sno;
	private String realName;
	private String dorm;
	private Duty duty;
	private long phoneNo;
	private long qq;
	private String mail;

	private StudentService studentService;

	private Map<String, Object> request;

	// 获取一条考勤信息，用于修改
	public String get() {
		if (stuId < 0) {
			return ERROR;
		}
		System.out.println("stuId: " + stuId);
		Student s = studentService.getStudentById(stuId);
		if (s == null) {
			return ERROR;
		}
		
		request.put("student", s);

		return "updateLink";
	}

	// 修改考勤信息
	public String update() {
		Student s = studentService.getStudentById(stuId);
		s.setAvatar(avatar);
		s.setUsername(username);
		s.setPassword(password);
		s.setSno(sno);
		s.setRealName(realName);
		s.setDorm(dorm);
		s.setPhoneNo(phoneNo);
		s.setQq(qq);
		s.setMail(mail);
		
		studentService.update(s);
		
		return "index";
	}

	// 删除学生
	public String delete() {
		studentService.deleteById(stuId);
		return "index";
	}

	// 列出所有学生
	public String list() {
		List<Student> list = studentService.getStudents();
		if (list != null && list.size() > 0) {
			request.put("students", list);
			return SUCCESS;
		}
		return ERROR;
	}

	// 跳转到添加页
	public String addLink() {
		return "addLink";
	}

	// 生成get/set
	
	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getDorm() {
		return dorm;
	}

	public void setDorm(String dorm) {
		this.dorm = dorm;
	}

	public Duty getDuty() {
		return duty;
	}

	public void setDuty(Duty duty) {
		this.duty = duty;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public long getQq() {
		return qq;
	}

	public void setQq(long qq) {
		this.qq = qq;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
