package cn.gdpu.dao.impl;

import java.util.List;

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

}
