package cn.gdpu.action;

import java.util.Map;

import org.apache.struts2.interceptor.validation.SkipValidation;

import cn.gdpu.bean.PageBean;
import cn.gdpu.service.DutyService;
import cn.gdpu.service.StudentService;
import cn.gdpu.util.ActionImpl;
import cn.gdpu.vo.Duty;

public class DutyAction extends ActionImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int dutyId = -1;
	private String dutyName;
	private String job;

	private String students;
	private int[] dutyIds;
	private StudentService studentService;
	private DutyService dutyService;
	private Map<String, Object> request;
	private PageBean pageBean;
	private int page;
	
	@Override
	public String add() {
		
		Duty d = new Duty();
		//d.setStudent(student);
		d.setDutyName(dutyName);
		d.setJob(job);
		dutyService.add(d);
		
		return super.add();
	}

	@Override
	@SkipValidation
	public String addLink() {
		// TODO Auto-generated method stub
		return super.addLink();
	}

	@Override
	@SkipValidation
	public String delete() {
		dutyService.delete(dutyId);
		return super.delete();
	}

	@Override
	@SkipValidation
	public String deleteMany() {
		for(int i=0;i<dutyIds.length;i++) {
			dutyService.delete(dutyIds[i]);
		}
		return super.deleteMany();
	}

	@Override
	@SkipValidation
	public String get() {
		if (dutyId < 0) {
			return "input";
		}
		
		Duty d = dutyService.getDutyById(dutyId);
		
		request.put("duty", d);
		
		return super.get();
	}

	/*@Override
	public String list() {
		List<Duty> list = dutyService.getAllDutys();
		if (list != null && list.size() > 0) {
			request.put("dutys", list);
		}
		return super.list();
	}*/
	/**
	 * 分页列出所有职务
	 * @return
	 */
	
	@SkipValidation
	public String list(){  
        //分页的pageBean,参数pageSize表示每页显示记录数,page为当前页  
        this.pageBean = dutyService.queryForPage(15, page);  
        if(pageBean.getList().isEmpty())
    		pageBean.setList(null);
        return super.list();  
    }  

	@Override
	public String update() {
		
		Duty d = dutyService.getDutyById(dutyId);
		d.setStudents(studentService.getStudentsBySnoString(students));
		d.setDutyName(dutyName);
		d.setJob(job);
		dutyService.add(d);
		
		return super.update();
	}

	//生成get/set方法
	
	public int getDutyId() {
		return dutyId;
	}

	public void setDutyId(int dutyId) {
		this.dutyId = dutyId;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int[] getDutyIds() {
		return dutyIds;
	}

	public void setDutyIds(int[] dutyIds) {
		this.dutyIds = dutyIds;
	}

	public DutyService getDutyService() {
		return dutyService;
	}

	public void setDutyService(DutyService dutyService) {
		this.dutyService = dutyService;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public String getStudents() {
		return students;
	}

	public void setStudents(String students) {
		this.students = students;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
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
