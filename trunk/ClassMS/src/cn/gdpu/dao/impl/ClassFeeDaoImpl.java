package cn.gdpu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gdpu.dao.ClassFeeDao;
import cn.gdpu.vo.ClassFee;


public class ClassFeeDaoImpl extends HibernateDaoSupport implements ClassFeeDao {

	public void insertClassFee(ClassFee classFee) {
		this.getHibernateTemplate().save(classFee);
	}
	
	public void deleteClassFeeByID(String fid) {
		ClassFee classFee = null;
		classFee = (ClassFee)this.getHibernateTemplate().get(ClassFee.class, fid);
		if(classFee != null)
			this.getHibernateTemplate().delete(classFee);
	}
	
	@SuppressWarnings("unchecked")
	public List<ClassFee> queryAllClassFees() {
		List<ClassFee> classFees = null;
		classFees = this.getHibernateTemplate().find("from ClassFee");
		return classFees;
	}

	public ClassFee queryClassFeeByID(String fid) {
		ClassFee classFee = null;
		classFee = (ClassFee)this.getHibernateTemplate().get(ClassFee.class, fid);
		return classFee;
	}

	public void updateClassFee(ClassFee classFee) {
		this.getHibernateTemplate().update(classFee);
	}

	  /** *//** 
     * 分页查询 
     * @param hql 查询的条件 
     * @param offset 开始记录 
     * @param length 一次查询几条记录 
     * @return 
     */  
    public List<ClassFee> queryForPage(final String hql,final int offset,final int length){  
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
