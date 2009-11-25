package cn.gdpu.service;

import java.util.List;
import java.util.Set;

import cn.gdpu.bean.PageBean;
import cn.gdpu.vo.Lesson;

public interface LessonService {
	
	public abstract void add(Lesson lesson);
	
	public abstract void delete(int lessonId);
	
	public abstract void update(Lesson lesson);
	
	public abstract Lesson getLessonByName(String lessonName);
	
	public abstract Lesson getLessonById(int lessonId);
	
	public abstract List<Lesson> getAllLessons();
	
	public abstract Set<Lesson> getLessonsByLessonIdString(String lessonIds);

	/** *//** 
     * 分页查询 
     * @param currentPage 当前第几页 
     * @param pageSize 每页大小 
     * @return 封闭了分页信息(包括记录集list)的Bean 
     */  
    public abstract PageBean queryForPage(int pageSize,int currentPage);  
    
}
