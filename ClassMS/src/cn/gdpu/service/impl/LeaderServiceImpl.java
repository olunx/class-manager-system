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

	public void deleteByName(String realName) {
		leaderDao.deleteLeaderByName(realName);
	}
	
	public void deleteById(int leaderId) {
		leaderDao.deleteLeaderById(leaderId);
	}

	public List<Leader> getAllLeaders() {
		return leaderDao.queryAllLeaders();
	}

	public Leader getLeaderByName(String realName) {
		return leaderDao.queryLeaderByName(realName);
	}
	
	public Leader getLeaderById(int leaderId) {
		return leaderDao.queryLeaderById(leaderId);
	}

	public void update(Leader leader) {
		leaderDao.updateLeader(leader);
	}

	public Leader getLeaderByUsernameAndPassword(String username, String password) {
		return leaderDao.queryLeaderByNameAndPassword(username, password);
	}

}
