package cn.gdpu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gdpu.dao.DutyDao;
import cn.gdpu.vo.Duty;

public class DutyDaoImpl extends HibernateDaoSupport implements DutyDao {

	public void insertDuty(Duty duty) {
		this.getHibernateTemplate().save(duty);
	}

	public void deleteDutyById(int dutyId) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().load(Duty.class, dutyId));
	}

	public void updateDuty(Duty duty) {
		this.getHibernateTemplate().update(duty);
	}

	@SuppressWarnings("unchecked")
	public Duty queryDutyByName(String dutyName) {
		//return (Duty) this.getHibernateTemplate().get(Duty.class, dutyName);
		Duty duty = null;
		List list = this.getHibernateTemplate().find("from Duty d where d.dutyName like '%" + dutyName + "%'");
		if (list != null && list.size() > 0) {
			duty = (Duty) list.get(0);
		}
		return duty;
	}
	
	public Duty queryDutyById(int dutyId) {
		return (Duty) this.getHibernateTemplate().load(Duty.class, dutyId);
	}

	@SuppressWarnings("unchecked")
	public List<Duty> queryAllDutys() {
		return this.getHibernateTemplate().find("from Duty");
	}

	  /** *//** 
     * 分页查询 
     * @param hql 查询的条件 
     * @param offset 开始记录 
     * @param length 一次查询几条记录 
     * @return 
     */  
    @SuppressWarnings("unchecked")
	public List<Duty> queryForPage(final String hql,final int offset,final int length){  
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
