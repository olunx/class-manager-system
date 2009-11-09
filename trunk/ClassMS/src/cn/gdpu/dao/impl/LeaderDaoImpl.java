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

	@SuppressWarnings("unchecked")
	public Leader queryLeaderByName(String leaderName) {
		//return (Leader) this.getHibernateTemplate().get(Leader.class, leaderName);
		Leader leader = null;
		List list = this.getHibernateTemplate().find("form Leader where leaderName=='" + leaderName + "'");
		if (list != null && list.size() > 0) {
			leader = (Leader) list.get(0);
		}
		return leader;
	}

	public void updateLeader(Leader leader) {
		this.getHibernateTemplate().update(leader);
	}

}
