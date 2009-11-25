package cn.gdpu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gdpu.dao.AdminDao;
import cn.gdpu.vo.Admin;

public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {

	public void insertAdmin(Admin admin) {
		this.getHibernateTemplate().save(admin);
	}

	public void deleteAdminById(int adminId) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().load(Admin.class, adminId));
	}

	public void updateAdmin(Admin admin) {
		this.getHibernateTemplate().update(admin);
	}

	public Admin queryAdminById(int adminId) {
		return (Admin) this.getHibernateTemplate().load(Admin.class, adminId);
	}
	
	@SuppressWarnings("unchecked")
	public Admin queryAdminByName(String adminName) {
		//return (Duty) this.getHibernateTemplate().get(Duty.class, dutyName);
		Admin admin = null;
		List list = this.getHibernateTemplate().find("form Admin where adminName=='" + adminName + "'");
		if (list != null && list.size() > 0) {
			admin = (Admin) list.get(0);
		}
		return admin;
	}

	@SuppressWarnings("unchecked")
	public List<Admin> queryAllAdmins() {
		return this.getHibernateTemplate().find("from Admin");
	}

	@SuppressWarnings("unchecked")
	public Admin queryAdminByUsernameAndPassword(String username, String password) {

		Admin admin = null;
		List list = this.getHibernateTemplate().find("from Admin a where a.username='" + username + "' and a.password='" + password + "'");
		System.out.println("list size:"+list.size());
		if (list != null && list.size() > 0) {
			admin = (Admin) list.get(0);
		}
		return admin;
	}
	
	/** *//** 
     * 分页查询 
     * @param hql 查询的条件 
     * @param offset 开始记录 
     * @param length 一次查询几条记录 
     * @return 
     */  
    @SuppressWarnings("unchecked")
	public List<Admin> queryForPage(final String hql,final int offset,final int length){  
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
