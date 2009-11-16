package cn.gdpu.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gdpu.dao.ActivityApplyDao;
import cn.gdpu.vo.ActivityApply;
import cn.gdpu.vo.Student;

public class ActivityApplyDaoImpl extends HibernateDaoSupport implements ActivityApplyDao {

	public void deleteActivityApplyByID(int aid) {
		ActivityApply activityApply = queryActivityApply(aid);
		Student stu = activityApply.getStudent();
		stu.getActivityApplys().remove(activityApply);
		activityApply.setStudent(null);
		this.getHibernateTemplate().delete(activityApply);
	}

	public void deleteActivityApplyByStuID(int sid) {
		Student stu = (Student) this.getHibernateTemplate().get(Student.class, sid);
		stu.setActivityApplys(null);
		this.getHibernateTemplate().save(stu);
	}

	public void insertActivityApply(ActivityApply activityApply) {
		this.getHibernateTemplate().save(activityApply);
	}

	public ActivityApply queryActivityApply(int aid) {
		ActivityApply activityApply = null;
		activityApply = (ActivityApply) this.getHibernateTemplate().get(ActivityApply.class, aid);
		return activityApply;
	}

	public Set<ActivityApply> queryActivityApplysByStuID(int sid) {
		Student stu = (Student) this.getHibernateTemplate().get(Student.class, sid);
		Set<ActivityApply> set = null;
		set = stu.getActivityApplys();
		return set;
	}

	public void updateActivityApply(ActivityApply activityApply) {
		this.getHibernateTemplate().update(activityApply);
	}
	
	 /** *//** 
     * 分页查询 
     * @param hql 查询的条件 
     * @param offset 开始记录 
     * @param length 一次查询几条记录 
     * @return 
     */  
    public List queryForPage(final String hql,final int offset,final int length){  
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
