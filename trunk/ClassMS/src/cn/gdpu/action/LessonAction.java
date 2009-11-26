package cn.gdpu.action;

import java.util.Map;

import org.apache.struts2.interceptor.validation.SkipValidation;

import cn.gdpu.bean.PageBean;
import cn.gdpu.service.LessonService;
import cn.gdpu.util.ActionImpl;
import cn.gdpu.vo.Lesson;

public class LessonAction extends ActionImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int lessonId = -1;
	private String day;
	private String lessonName;
	private String lessonPeriod;

	private int[] lessonIds;
	private LessonService lessonService;
	private Map<String, Object> request;
	private PageBean pageBean;
	private int page;

	@Override
	public String add() {

		Lesson l = new Lesson();
		l.setDay(day);
		l.setLessonName(lessonName);
		l.setLessonPeriod(lessonPeriod);
		lessonService.add(l);

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
		lessonService.delete(lessonId);
		return super.delete();
	}

	@Override
	@SkipValidation
	public String deleteMany() {
		if(lessonIds == null || lessonIds.length < 1)
			return "index";  
		for (int i = 0; i < lessonIds.length; i++) {
			lessonService.delete(lessonIds[i]);
		}
		return super.deleteMany();
	}

	@Override
	@SkipValidation
	public String get() {
		if (lessonId < 0) {
			return "input";
		}

		Lesson l = lessonService.getLessonById(lessonId);

		request.put("lesson", l);

		return super.get();
	}

	/*
	 * @Override public String list() { List<Duty> list =
	 * dutyService.getAllDutys(); if (list != null && list.size() > 0) {
	 * request.put("dutys", list); } return super.list(); }
	 */
	/**
	 * 分页列出所有职务
	 * 
	 * @return
	 */

	@SkipValidation
	public String list() {
		// 分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
		this.pageBean = lessonService.queryForPage(15, page);
		if (pageBean.getList().isEmpty())
			pageBean.setList(null);
		return super.list();
	}

	@Override
	public String update() {

		Lesson l = lessonService.getLessonById(lessonId);
		l.setDay(day);
		l.setLessonName(lessonName);
		l.setLessonPeriod(lessonPeriod);
		lessonService.add(l);

		return super.update();
	}

	// 生成get/set方法

	public int getLessonId() {
		return lessonId;
	}

	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public String getLessonPeriod() {
		return lessonPeriod;
	}

	public void setLessonPeriod(String lessonPeriod) {
		this.lessonPeriod = lessonPeriod;
	}

	public int[] getLessonIds() {
		return lessonIds;
	}

	public void setLessonIds(int[] lessonIds) {
		this.lessonIds = lessonIds;
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
