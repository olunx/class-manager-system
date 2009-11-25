package cn.gdpu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gdpu.dao.LessonDao;
import cn.gdpu.vo.Lesson;

public class LessonDaoImpl extends HibernateDaoSupport implements LessonDao {

	public void insertLesson(Lesson lesson) {
		this.getHibernateTemplate().save(lesson);
	}

	public void deleteLessonById(int lessonId) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().load(Lesson.class, lessonId));
	}

	public void updateLesson(Lesson lesson) {
		this.getHibernateTemplate().update(lesson);
	}

	@SuppressWarnings("unchecked")
	public Lesson queryLessonByName(String lessonName) {
		Lesson lesson = null;
		List list = this.getHibernateTemplate().find("from Lesson l where l.lessonName like '%" + lessonName + "%'");
		if (list != null && list.size() > 0) {
			lesson = (Lesson) list.get(0);
		}
		return lesson;
	}
	
	public Lesson queryLessonById(int lessonId) {
		return (Lesson) this.getHibernateTemplate().load(Lesson.class, lessonId);
	}

	@SuppressWarnings("unchecked")
	public List<Lesson> queryAllLessons() {
		return this.getHibernateTemplate().find("from Lesson");
	}

	  /** *//** 
     * 分页查询 
     * @param hql 查询的条件 
     * @param offset 开始记录 
     * @param length 一次查询几条记录 
     * @return 
     */  
    @SuppressWarnings("unchecked")
	public List<Lesson> queryForPage(final String hql,final int offset,final int length){  
        List list = getHibernateTemplate().executeFind(new HibernateCallback(){  
            public Object doInHibernate(Session session) throws HibernateException,SQLException{  
                Query query = session.createQuery(hql);  
                query.setFirstResult(offset);  
                query.setMaxResults(length);  
                List list = query.list();  
                return list;  
            }  
        });  
        return list;  
    }  
      
      
    /** *//** 
     * 查询所有记录数 
     * @return 总记录数 
     */  
    public int getAllRowCount(String hql){  
        return getHibernateTemplate().find(hql).size();  
    }  
}
