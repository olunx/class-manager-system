package cn.gdpu.action;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.RequestAware;

import cn.gdpu.bean.PageBean;
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
	private String[] type;
	private String sno;
	private int aid;
	private int[] aids;
	private int cmd;// 批量操作命令

	private PageBean pageBean;
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

	private int page;
	
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
		Student stu = studentService.getStudentBySno(sno);
		Set<ActivityApply> activityApplys = new HashSet<ActivityApply>();
		if (stu != null) {
			activityApplys = stu.getActivityApplys();
		}
		if (activityApplys.size() == 0)
			activityApplys = null;
		request.put("student", stu);
		request.put("activityApplys", activityApplys);
		return "liststu";
	}
	

	/**
	 * 分页某个学生的学分申请
	 * 
	 * @return
	 * @throws Exception
	 */
	public String listPage() throws Exception {
		Student stu = studentService.getStudentBySno(sno);
		request.put("student", stu);
		this.pageBean = activityApplyService.queryForPage(15, page, stu);  
		if(pageBean.getList().isEmpty())
			pageBean = null;
        return "listpage";
	}

	/**
	 * 添加链接
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addLink() throws Exception {
		Student stu = studentService.getStudentBySno(sno);
		request.put("student", stu);
		return INPUT;
	}

	/**
	 * 添加
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		Student stu = studentService.getStudentBySno(sno);
		for (int i = 0; i < reason.length; i++) {
			if (!reason[i].trim().equals("") && !mark[i].trim().equals("")) {
				ActivityApply activityApply = new ActivityApply();
				activityApply.setMark(mark[i].trim());
				activityApply.setReason(reason[i].trim());
				activityApply.setStudent(stu);
				activityApply.setPass(0);
				activityApply.setType(type[i].trim());
				activityApplyService.addActivityApply(activityApply);
			}
		}
		return "liststuAction";
	}

	/**
	 * 删除
	 * 
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		activityApplyService.delActivityApplyByID(aid);
		return "liststuAction";
	}

	/**
	 * 批量操作
	 * 
	 * @return
	 * @throws Exception
	 */
	public String batch() throws Exception {
		
		if (aids != null && aids.length > 0) {
			for (int i = 0; i < aids.length; i++) {
				switch (cmd) {
				case 1:
					activityApplyService.setActivityApplyPass(aids[i], 1);
					break;
				case 2:
					activityApplyService.setActivityApplyPass(aids[i], 2);
					break;
				case 3:
					activityApplyService.delActivityApplyByID(aids[i]);
					break;
				}
			}
		}
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

	public void setAids(int[] aids) {
		this.aids = aids;
	}

	public int[] getAids() {
		return aids;
	}

	public int getCmd() {
		return cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}

	public String[] getType() {
		return type;
	}

	public void setType(String[] type) {
		this.type = type;
	}
}
