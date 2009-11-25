package cn.gdpu.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import cn.gdpu.bean.PageBean;
import cn.gdpu.service.AttendanceService;
import cn.gdpu.service.DutyService;
import cn.gdpu.service.StudentService;
import cn.gdpu.util.excel.StudentExcel;
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
	private long phoneNo;
	private long qq;
	private String mail;

	private String dutys;
	private int[] stuIds;
	private String fileName;
	private DutyService dutyService;
	private StudentService studentService;
	private AttendanceService attendanceService;
	private Map<String, Object> request;
	
	private PageBean pageBean;    //分页
	private int page;
	
	//添加一个学生信息
	public String add() {
		
		Student s = new Student();
		s.setAvatar(avatar);
		s.setUsername(username);
		s.setPassword(password);
		s.setSno(sno);
		s.setRealName(realName);
		s.setDorm(dorm);
		s.setPhoneNo(phoneNo);
		s.setQq(qq);
		s.setMail(mail);
		
		studentService.add(s);
		return "index";
	}
	
	@SkipValidation
	public String addMany() {
		if (fileName == null) {
			return "input";
		}

		String filePath = ServletActionContext.getServletContext().getRealPath("/upload") + "/" + fileName;
		List<Student> students = StudentExcel.getStudentRegExcel().getRegData(filePath);

		int resultLength = students.size();

		for (int i = 0; i < resultLength; i++) {
			studentService.add(students.get(i));
		}

		return "index";
	}

	// 获取一条考勤信息，用于修改
	@SkipValidation
	public String get() {
		if (stuId < 0) {
			return "input";
		}
		//System.out.println("stuId: " + stuId);
		Student s = studentService.getStudentById(stuId);
		if (s == null) {
			return "input";
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
		System.out.println(dutys);
		s.setDutys(dutyService.getDutysByDutyNameString(dutys));
		studentService.update(s);
		
		return "index";
	}

	// 删除学生
	@SkipValidation
	public String delete() {
		studentService.deleteById(stuId);
		return "index";
	}
	
	@SkipValidation
	public String deleteMany() {
		if(stuIds == null || stuIds.length < 1) {
			return "index";
		}
		for(int i=0;i<stuIds.length;i++) {
			studentService.deleteById(stuIds[i]);
		}
		return "index";
	}

	/*// 列出所有学生
	public String list() {
		List<Student> list = studentService.getStudents();
		if (list != null && list.size() > 0) {
			request.put("students", list);
		}
		return "input";
	}*/
	
	/**
	 * 分页列出所有学生
	 * @return
	 */
	@SkipValidation
	public String list() throws Exception {  
        //分页的pageBean,参数pageSize表示每页显示记录数,page为当前页  
        this.pageBean = studentService.queryForPage(15, page);  
        if(pageBean.getList().isEmpty())
    		pageBean.setList(null);
        return "input";  
    }  

	// 跳转到添加页
	@SkipValidation
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int[] getStuIds() {
		return stuIds;
	}

	public void setStuIds(int[] stuIds) {
		this.stuIds = stuIds;
	}

	public AttendanceService getAttendanceService() {
		return attendanceService;
	}

	public void setAttendanceService(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}
	
	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getDutys() {
		return dutys;
	}

	public void setDutys(String dutys) {
		this.dutys = dutys;
	}

	public DutyService getDutyService() {
		return dutyService;
	}

	public void setDutyService(DutyService dutyService) {
		this.dutyService = dutyService;
	}

}
