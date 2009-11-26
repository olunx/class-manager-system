package cn.gdpu.action;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import cn.gdpu.bean.PageBean;
import cn.gdpu.service.LeaveApplyService;
import cn.gdpu.service.StudentService;
import cn.gdpu.vo.LeaveApply;
import cn.gdpu.vo.Student;

import com.opensymphony.xwork2.ActionSupport;

public class LeaveApplyAction extends ActionSupport implements RequestAware {
	private static final long serialVersionUID = 1L;
	private LeaveApplyService leaveApplyService;
	private StudentService studentService;
	private Map<String, Object> request;
	private String sno;
	private String reason;
	private String airtime;
	private String endtime;
	private int lid;
	private int[] lids;
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
	@SkipValidation
	public String list() throws Exception {
		request.put("students", studentService.getStudents());
		return "list";
	}

	/**
	 * 某个学生的请假申请
	 * 
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String listStu() throws Exception {
		Student stu = studentService.getStudentBySno(sno);
		Set<LeaveApply> leaveApplys = new HashSet<LeaveApply>();
		if (stu != null) {
			leaveApplys = stu.getLeaveApplys();
		}
		if (leaveApplys.size() == 0)
			leaveApplys = null;
		request.put("student", stu);
		request.put("leaveApplys",leaveApplys);
		return "liststu";
	}
	

	/**
	 * 分页某个学生的请假申请
	 * 
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String listPage() throws Exception {
		if(sno == null || sno.trim().equals("")){
			this.pageBean = leaveApplyService.queryForPage(15, page, null);  
			if(pageBean.getList().isEmpty())
				pageBean = null;
	        return "listpage";
		}
		else{
			Student stu = studentService.getStudentBySno(sno);
			request.put("student", stu);
			this.pageBean = leaveApplyService.queryForPage(15, page, stu);  
			if(pageBean.getList().isEmpty())
				pageBean = null;
	        return "listpage";
		}
	}

	/**
	 * 添加链接
	 * 
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
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
		
		LeaveApply leaveApply = new LeaveApply();
		leaveApply.setStudent(stu);
		String content = "本人因" + reason + "，不能按照正常时间上课，故于" + airtime + "至" + endtime + "(时间)请假，请见谅，望批准！" ;
		leaveApply.setContent(content);
		leaveApply.setStudent(stu);
		leaveApply.setPass(0);
		leaveApply.setTime(new Date());
		leaveApplyService.addLeaveApply(leaveApply);
		
		return "liststuAction";
	}

	/**
	 * 删除
	 * 
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String del() throws Exception {
		leaveApplyService.delLeaveApplyByID(lid);
		return "liststuAction";
	}

	/**
	 * 批量操作
	 * 
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String batch() throws Exception {
		
		if (lids != null && lids.length > 0) {
			for (int i = 0; i < lids.length; i++) {
				switch (cmd) {
				case 1:
					leaveApplyService.setLeaveApplyPass(lids[i], 1);
					break;
				case 2:
					leaveApplyService.setLeaveApplyPass(lids[i], 2);
					break;
				case 3:
					leaveApplyService.delLeaveApplyByID(lids[i]);
					break;
				}
			}
		}
		return "liststuAction";
	}

	@Override
	@SkipValidation
	public String doDefault() throws Exception {
		return list();
	}

	public LeaveApplyService getLeaveApplyService() {
		return leaveApplyService;
	}
	public void setLeaveApplyService(LeaveApplyService leaveApplyService) {
		this.leaveApplyService = leaveApplyService;
	}

	public String getAirtime() {
		return airtime;
	}

	public void setAirtime(String airtime) {
		this.airtime = airtime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public Map<String, Object> getRequest() {
		return request;
	}
	
	public void setRequest(Map<String, Object> request) {
		this.request = request;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public int[] getLids() {
		return lids;
	}

	public void setLids(int[] lids) {
		this.lids = lids;
	}

	public int getCmd() {
		return cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}

	
}
