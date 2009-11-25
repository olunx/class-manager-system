package cn.gdpu.dao;

import java.util.List;

import cn.gdpu.vo.Lesson;

public interface LessonDao {
	
	public abstract void insertLesson(Lesson lesson);
	
	public abstract void deleteLessonById(int lessonId);

	public abstract void updateLesson(Lesson lesson);
	
	public abstract Lesson queryLessonByName(String lessonName);
	
	public abstract Lesson queryLessonById(int lessonId);
	
	public abstract List<Lesson> queryAllLessons();
	
	/** 
     * 分页查询 
     * @param hql 查询的条件 
     * @param offset 开始记录 
     * @param length 一次查询几条记录 
     * @return 
     */  
	public abstract List<Lesson> queryForPage(final String hql,final int offset,final int length);  
 
    /**
     * 查询所有记录数 
     * @param hql 查询的条件 
     * @return 总记录数 
     */  
    public abstract int getAllRowCount(String hql);  
}
