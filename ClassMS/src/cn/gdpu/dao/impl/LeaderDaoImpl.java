package cn.gdpu.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gdpu.dao.LeaderDao;
import cn.gdpu.vo.Leader;

public class LeaderDaoImpl extends HibernateDaoSupport implements LeaderDao {

	public void deleteLeaderByName(String leaderName) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().load(Leader.class, leaderName));
	}

	public void deleteLeaderById(int leaderId) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().load(Leader.class, leaderId));
	}
	
	public void insertLeader(Leader leader) {
		this.getHibernateTemplate().save(leader);
	}

	@SuppressWarnings("unchecked")
	public List<Leader> queryAllLeaders() {
		return this.getHibernateTemplate().find("from Leader");
	}

	@SuppressWarnings("unchecked")
	public Leader queryLeaderByName(String realName) {
		//return (Leader) this.getHibernateTemplate().get(Leader.class, leaderName);
		Leader leader = null;
		List list = this.getHibernateTemplate().find("form Leader where leaderName=='" + realName + "'");
		if (list != null && list.size() > 0) {
			leader = (Leader) list.get(0);
		}
		return leader;
	}

	public Leader queryLeaderById(int leaderId) {
		return (Leader) this.getHibernateTemplate().load(Leader.class, leaderId);
	}
	
	public void updateLeader(Leader leader) {
		this.getHibernateTemplate().update(leader);
	}

	@SuppressWarnings("unchecked")
	public Leader queryLeaderByNameAndPassword(String username, String password) {
		Leader leader = null;
		List list = this.getHibernateTemplate().find("from Leader l where l.username='" + username + "' and l.password='" + password + "'");
		if (list != null && list.size() > 0) {
			leader = (Leader) list.get(0);
		}
		return leader;
	}

}
