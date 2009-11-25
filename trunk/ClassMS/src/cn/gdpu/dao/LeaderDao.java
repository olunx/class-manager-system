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
	public abstract void deleteLeaderByName(String realName);
	
	public abstract void deleteLeaderById(int leaderId);

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
	public abstract Leader queryLeaderByName(String realName);
	
	public abstract Leader queryLeaderById(int leaderId);
	
	/**
	 * 登录时使用
	 * @param username
	 * @param password
	 * @return
	 */
	public abstract Leader queryLeaderByNameAndPassword(String username, String password);
	
	/**
	 * 获取所有领导信息
	 * @return
	 */
	public abstract List<Leader> queryAllLeaders();
	
	/** *//** 
     * 分页查询 
     * @param hql 查询的条件 
     * @param offset 开始记录 
     * @param length 一次查询几条记录 
     * @return 
     */  
	public abstract List<Leader> queryForPage(final String hql,final int offset,final int length);  
 
    /** *//** 
     * 查询所有记录数 
     * @param hql 查询的条件 
     * @return 总记录数 
     */  
    public abstract int getAllRowCount(String hql);  
	
}
