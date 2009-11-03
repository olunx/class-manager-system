package cn.gdpu.dao;

import java.util.List;

import cn.gdpu.vo.Leader;

public interface LeaderDao {
	
	/**
	 * 添加一个领导
	 * @param leader
	 */
	public abstract void insertLeader(Leader leader);
	
	/**
	 * 删除一个领导
	 * @param leaderName
	 */
	public abstract void deleteLeaderByName(String leaderName);

	/**
	 * 更新一个领导
	 * @param leader
	 */
	public abstract void updateLeader(Leader leader);
	
	/**
	 * 获取一个领导信息
	 * @param leaderName
	 * @return
	 */
	public abstract Leader queryLeaderByName(String leaderName);
	
	/**
	 * 获取所有领导信息
	 * @return
	 */
	public abstract List<Leader> queryAllLeaders();
}
