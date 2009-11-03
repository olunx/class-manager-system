package cn.gdpu.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gdpu.dao.LeaderDao;
import cn.gdpu.vo.Leader;

public class LeaderDaoImpl extends HibernateDaoSupport implements LeaderDao {

	public void deleteLeaderByName(String leaderName) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().load(Leader.class, leaderName));
	}

	public void insertLeader(Leader leader) {
		this.getHibernateTemplate().save(leader);
	}

	@SuppressWarnings("unchecked")
	public List<Leader> queryAllLeaders() {
		return this.getHibernateTemplate().find("from Leader");
	}

	public Leader queryLeaderByName(String leaderName) {
		return (Leader) this.getHibernateTemplate().get(Leader.class, leaderName);
	}

	public void updateLeader(Leader leader) {
		this.getHibernateTemplate().update(leader);
	}

}
