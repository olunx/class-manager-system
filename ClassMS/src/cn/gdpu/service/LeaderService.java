package cn.gdpu.service;

import java.util.List;

import cn.gdpu.bean.PageBean;
import cn.gdpu.vo.Leader;

public interface LeaderService {
	
	/**
	 * 添加一个领导
	 * @param leader
	 */
	public abstract void add(Leader leader);
	
	/**
	 * 删除一个领导
	 * @param leaderName
	 */
	public abstract void deleteByName(String realName);
	
	public abstract void deleteById(int leaderId);
	
	/**
	 * 更新一个领导
	 * @param leader
	 */
	public abstract void update(Leader leader);
	
	/**
	 * 获取一个领导
	 * @param leaderName
	 * @return
	 */
	public abstract Leader getLeaderByName(String realName);
	
	public abstract Leader getLeaderById(int leaderId);
	
	/**
	 * @param username
	 * @param password
	 * @return
	 */
	public abstract Leader getLeaderByUsernameAndPassword(String username, String password);
	
	/**
	 * 获取所有领导
	 * @return
	 */
	public abstract List<Leader> getAllLeaders();

	/** *//** 
     * 分页查询 
     * @param currentPage 当前第几页 
     * @param pageSize 每页大小 
     * @return 封闭了分页信息(包括记录集list)的Bean 
     */  
    public abstract PageBean queryForPage(int pageSize,int currentPage);  
    
}
