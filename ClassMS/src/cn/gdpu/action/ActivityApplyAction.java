package cn.gdpu.action;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.RequestAware;

import cn.gdpu.service.ActivityApplyService;
import cn.gdpu.service.StudentService;
import cn.gdpu.vo.ActivityApply;
import cn.gdpu.vo.Student;

import com.opensymphony.xwork2.ActionSupport;

public class ActivityApplyAction extends ActionSupport implements RequestAware {
	private static final long serialVersionUID = 1L;
	private ActivityApplyService activityApplyService;
	private StudentService studentService;
	private Map<String, Object> request;
	private String[] reason;
	private String[] mark;
	private String sno;
	private int aid;

	/**
	 * 列出所有学生
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		request.put("students", studentService.getStudents());
		return "list";
	}

	/**
	 * 某个学生的学分申请
	 * 
	 * @return
	 * @throws Exception
	 */
	public String listStu() throws Exception {
		Student stu = studentService.getStudent(sno);
		Set<ActivityApply> activityApplys = new HashSet<ActivityApply>();
		activityApplys = stu.getActivityApplys();
		if (activityApplys.size() == 0)
			activityApplys = null;
		request.put("student", stu);
		request.put("activityApplys", activityApplys);
		return "liststu";
	}

	/**
	 * 添加链接
	 * @return
	 * @throws Exception
	 */
	public String addLink() throws Exception {
		return INPUT;
	}

	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		Student stu = studentService.getStudent(sno);
		for (int i = 0; i < reason.length; i++) {
			if (!reason[i].trim().equals("") && !mark[i].trim().equals("")) {
				ActivityApply activityApply = new ActivityApply();
				activityApply.setMark(mark[i].trim());
				activityApply.setReason(reason[i].trim());
				activityApply.setStudent(stu);
				activityApply.setPass(0);
				activityApplyService.addActivityApply(activityApply);
			}
		}
		return "liststuAction";
	}
	
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		activityApplyService.delActivityApplyByID(aid);
		return "liststuAction";
	}

	@Override
	public String doDefault() throws Exception {
		return list();
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public void setActivityApplyService(ActivityApplyService activityApplyService) {
		this.activityApplyService = activityApplyService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String[] getReason() {
		return reason;
	}

	public void setReason(String[] reason) {
		this.reason = reason;
	}

	public String[] getMark() {
		return mark;
	}

	public void setMark(String[] mark) {
		this.mark = mark;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}
}
