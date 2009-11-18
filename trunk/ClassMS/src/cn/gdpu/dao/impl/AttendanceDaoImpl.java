package cn.gdpu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gdpu.dao.AttendanceDao;
import cn.gdpu.vo.Attendance;
import cn.gdpu.vo.ClassFee;

public class AttendanceDaoImpl extends HibernateDaoSupport implements AttendanceDao {

	public void deleteAttendanceByAid(int aid) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().load(Attendance.class, aid));
	}

	public void insertAttendance(Attendance attendance) {
		this.getHibernateTemplate().save(attendance);
	}

	@SuppressWarnings("unchecked")
	public List<Attendance> queryAllAttendances() {
		return this.getHibernateTemplate().find("from Attendance");
	}

	@SuppressWarnings("unchecked")
	public Attendance queryAttendanceByWeekDay(int week, int day) {
		//return (Attendance) this.getHibernateTemplate().find("form Attendance where week=='" + week + "'&day=='" + day + "'").get(0);
		Attendance attendance = null;
		List list = this.getHibernateTemplate().find("from Attendance where week=='" + week + "'&day=='" + day + "'");
		if (list != null && list.size() > 0) {
			attendance = (Attendance) list.get(0);
		}
		return attendance;
	}

	public void updateAttendance(Attendance attendance) {
		this.getHibernateTemplate().update(attendance);
	}

	public Attendance queryAttendanceByAid(int aid) {
		return (Attendance) this.getHibernateTemplate().load(Attendance.class, aid);
	}

	  /** *//** 
     * 分页查询 
     * @param hql 查询的条件 
     * @param offset 开始记录 
     * @param length 一次查询几条记录 
     * @return 
     */  
    public List<Attendance> queryForPage(final String hql,final int offset,final int length){  
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
