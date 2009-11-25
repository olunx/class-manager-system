package cn.gdpu.action;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import cn.gdpu.bean.PageBean;
import cn.gdpu.service.AttendanceService;
import cn.gdpu.service.LessonService;
import cn.gdpu.service.StudentService;
import cn.gdpu.vo.Attendance;
import cn.gdpu.vo.Lesson;
import cn.gdpu.vo.Student;

import com.opensymphony.xwork2.ActionSupport;

public class AttendanceAction extends ActionSupport implements RequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private Attendance attendance;// 接收传来的学生对象
	private String week;
	private String day;
	private String lessonIds;
	private String students;// 接收传来的学生学号字符串
	private String clerk;// 接收传来的数据录入人员
	private int aid = -1;// 接收传来的考勤信息ID号

	private int[] aids;
	private AttendanceService attendanceService;
	private StudentService studentService;
	private LessonService lessonService;
	private PageBean pageBean;
	private int page;
	

	private Map<String, Object> request;

	// 添加考勤信息
	public String add() {
		System.out.println(students);
		Attendance attendance = new Attendance();
		attendance.setWeek(week);
		attendance.setDay(day);
		//attendance.setLesson(lesson);
		attendance.setLessons(lessonService.getLessonsByLessonIdString(lessonIds));
		attendance.setStudents(studentService.getStudentsBySnoString(students));
		attendance.setClerk(studentService.getStudentBySno(clerk));
		attendance.setTime(new Date());
		attendanceService.add(attendance);

		return "index";
	}

	// 获取一条考勤信息，用于修改
	@SkipValidation
	public String get() {
		if (aid < 0) {
			return ERROR;
		}
		System.out.println("aid: " + aid);
		Attendance attendance = attendanceService.getAttendanceByAid(aid);
//		Set<Lesson> lesson = attendance.getLessons();
//		String lessons = "";
//		for(Lesson l : lesson) {
//			lessons = lesson + l.getLessonName();
//		}
		Set<Student> stus = attendance.getStudents();
		String students = "";
		for (Student stu : stus) {
			students = students + stu.getSno() + ",";
		}
		String clerk = null;
		if (attendance.getClerk() != null) {
			clerk = attendance.getClerk().getSno();
		}

		request.put("attendance", attendance);
//		request.put("lessons", lessons);
		request.put("students", students);
		request.put("clerk", clerk);

		return "updateLink";
	}

	// 修改考勤信息
	public String update() {
		Attendance attendance = attendanceService.getAttendanceByAid(aid);
		attendance.setWeek(week);
		attendance.setDay(day);
		//attendance.setLesson(lesson);
		attendance.setStudents(studentService.getStudentsBySnoString(students));
		attendance.setClerk(studentService.getStudentBySno(clerk));
		attendance.setTime(new Date());
		attendanceService.update(attendance);
		return "index";
	}

	// 删除考勤信息
	@SkipValidation
	public String delete() {
		attendanceService.delete(aid);
		return "index";
	}

	//批量删除
	@SkipValidation
	public String deleteMany() {
		for(int i=0; i<aids.length; i++) {
			attendanceService.delete(aids[i]);
		}
		return "index";
	}
	
	/*// 列出考勤信息
	public String list() {
		List<Attendance> list = attendanceService.getAllAttendances();
		if (list != null && list.size() > 0) {
			
			request.put("attendances", list);
			
			return SUCCESS;
		}
		return ERROR;
	}*/
	
	/**
	 * 分页列出所有考勤信息
	 * @return
	 */
	@SkipValidation
	public String list() throws Exception {  
        //分页的pageBean,参数pageSize表示每页显示记录数,page为当前页  
        this.pageBean = attendanceService.queryForPage(15, page);  
        if(pageBean.getList().isEmpty())
    		pageBean.setList(null);
        return SUCCESS;  
    }  

	// 跳转到添加页
	@SkipValidation
	public String addLink() {
		List<Student> students = studentService.getStudents();
		List<Lesson> lessons = lessonService.getAllLessons();
		request.put("students", students);
		request.put("lessons", lessons);
		return "addLink";
	}

	//生成get/set
	
	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getLessonIds() {
		return lessonIds;
	}

	public void setLessonIds(String lessonIds) {
		this.lessonIds = lessonIds;
	}

	public String getStudents() {
		return students;
	}

	public void setStudents(String students) {
		this.students = students;
	}

	public String getClerk() {
		return clerk;
	}

	public void setClerk(String clerk) {
		this.clerk = clerk;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public AttendanceService getAttendanceService() {
		return attendanceService;
	}

	public void setAttendanceService(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public LessonService getLessonService() {
		return lessonService;
	}

	public void setLessonService(LessonService lessonService) {
		this.lessonService = lessonService;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public int[] getAids() {
		return aids;
	}

	public void setAids(int[] aids) {
		this.aids = aids;
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
}
