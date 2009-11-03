package cn.gdpu.service.impl;

import java.util.List;

import cn.gdpu.dao.LeaderDao;
import cn.gdpu.service.LeaderService;
import cn.gdpu.vo.Leader;

public class LeaderServiceImpl implements LeaderService {

	private LeaderDao leaderDao;

	public LeaderDao getLeaderDao() {
		return leaderDao;
	}

	public void setLeaderDao(LeaderDao leaderDao) {
		this.leaderDao = leaderDao;
	}

	public void add(Leader leader) {
		leaderDao.insertLeader(leader);
	}

	public void delete(String leaderName) {
		leaderDao.deleteLeaderByName(leaderName);
	}

	public List<Leader> getAllLeaders() {
		return leaderDao.queryAllLeaders();
	}

	public Leader getLeaderByName(String leaderName) {
		return leaderDao.queryLeaderByName(leaderName);
	}

	public void update(Leader leader) {
		leaderDao.updateLeader(leader);
	}

}
