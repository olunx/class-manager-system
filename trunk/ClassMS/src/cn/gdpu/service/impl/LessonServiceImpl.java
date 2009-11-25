package cn.gdpu.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.gdpu.bean.PageBean;
import cn.gdpu.dao.LessonDao;
import cn.gdpu.service.LessonService;
import cn.gdpu.vo.Lesson;

public class LessonServiceImpl implements LessonService {

	private LessonDao lessonDao;

	public LessonDao getLessonDao() {
		return lessonDao;
	}

	public void setLessonDao(LessonDao lessonDao) {
		this.lessonDao = lessonDao;
	}

	public void add(Lesson lesson) {
		lessonDao.insertLesson(lesson);
	}

	public void delete(int lessonId) {
		lessonDao.deleteLessonById(lessonId);
	}

	public List<Lesson> getAllLessons() {
		return lessonDao.queryAllLessons();
	}

	public Lesson getLessonByName(String lessonName) {
		return lessonDao.queryLessonByName(lessonName);
	}

	public Lesson getLessonById(int lessonId) {
		return lessonDao.queryLessonById(lessonId);
	}
	
	public void update(Lesson lesson) {
		lessonDao.updateLesson(lesson);
	}

	public Set<Lesson> getLessonsByLessonIdString(String lessonIds) {

		String[] ids = lessonIds.split("\\,");
		Set<Lesson> lessons = new HashSet<Lesson>();
		for(int i=0;i<ids.length;i++) {
			System.out.println("ids:" + ids[i]);
			if(!ids[i].equals("") && ids[i] != "") {
				lessons.add(lessonDao.queryLessonById(Integer.parseInt(ids[i])));
			}
			
		}
		
		return lessons;
	}
	
	/** */
	/**
	 * 分页查询
	 * 
	 * @param currentPage
	 *            当前第几页
	 * @param pageSize
	 *            每页大小
	 * @return 封闭了分页信息(包括记录集list)的Bean
	 */
	public PageBean queryForPage(int pageSize, int page) {

		final String hql = "from Lesson"; // 查询语句
		int allRow = lessonDao.getAllRowCount(hql); // 总记录数
		int totalPage = PageBean.countTotalPage(pageSize, allRow); // 总页数
		final int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page);
		List<Lesson> list = lessonDao.queryForPage(hql, offset, length); // "一页"的记录

		// 把分页信息保存到Bean中
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

	
}
