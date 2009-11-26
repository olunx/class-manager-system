package cn.gdpu.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gdpu.dao.LeaveApplyDao;
import cn.gdpu.vo.LeaveApply;
import cn.gdpu.vo.Student;

public class LeaveApplyDaoImpl extends HibernateDaoSupport implements LeaveApplyDao {

	public void deleteLeaveApplyByID(int lid) {
		LeaveApply leaveApply = queryLeaveApply(lid);
		Student stu = leaveApply.getStudent();
		stu.getLeaveApplys().remove(leaveApply);
		leaveApply.setStudent(null);
		this.getHibernateTemplate().delete(leaveApply);
	}

	public void deleteLeaveApplyByStuID(int sid) {
		Student stu = (Student) this.getHibernateTemplate().get(Student.class, sid);
		stu.setLeaveApplys(null);
		this.getHibernateTemplate().save(stu);
	}

	public void insertLeaveApply(LeaveApply leaveApply) {
		this.getHibernateTemplate().save(leaveApply);
	}

	public LeaveApply queryLeaveApply(int lid) {
		LeaveApply leaveApply = null;
		leaveApply = (LeaveApply) this.getHibernateTemplate().get(LeaveApply.class, lid);
		return leaveApply;
	}

	public Set<LeaveApply> queryLeaveApplysByStuID(int sid) {
		Student stu = (Student) this.getHibernateTemplate().get(Student.class, sid);
		Set<LeaveApply> set = null;
		set = stu.getLeaveApplys();
		return set;
	}

	public void updateLeaveApply(LeaveApply leaveApply) {
		this.getHibernateTemplate().update(leaveApply);
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
