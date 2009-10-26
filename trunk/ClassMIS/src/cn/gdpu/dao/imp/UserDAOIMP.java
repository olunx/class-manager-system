package cn.gdpu.dao.imp;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gdpu.dao.UserDAO;
import cn.gdpu.vo.User;


public class UserDAOIMP extends HibernateDaoSupport implements UserDAO {

	// private static final String QUERYALL_HQL = "from User";

	public boolean insertUser(User user) {
		boolean b = true;

		System.out.println("insert ...");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());

		this.getHibernateTemplate().save(user);

		return b;
	}

	public List<User> queryAll() {

		/*
		 * List<User> users = this.getHibernateTemplate().getSessionFactory()
		 * .getCurrentSession() .createQuery(this.QUERYALL_HQL).list();
		 */
		return null;
	}

}