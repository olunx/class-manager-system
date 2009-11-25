package cn.gdpu.dao;


import java.util.List;

import cn.gdpu.vo.Vote;
import cn.gdpu.vo.VoteItem;

public interface VoteDao {

	/**
	 * 新建投票
	 * @param vote
	 */
	public abstract void insertVote(Vote vote);
	
	/**
	 * 根据ID删除投票
	 * @param vid
	 */
	public abstract void deleteVoteById(int vid);
	
	/**
	 * 更新投票
	 * @param vote
	 */
	public abstract void updateVote(Vote vote);
	
	/**
	 * 根据ID获取投票
	 * @param vid
	 */
	public abstract Vote queryVoteById(int vid);
	
	/**
	 * 获取所有投票
	 */
	public abstract List<Vote> queryAllVotes();
	
	/**
	 * 获取所有示过期投票
	 */
	public abstract List<Vote> queryRealVotes();
	
	/**
	 * 新建投票选项
	 * @param voteItem
	 */
	public abstract void insertVoteItem(VoteItem voteItem);
	


	/**
	 * 根据ID删除投票选项
	 * @param viid
	 */
	public abstract void deleteVoteItemById(int viid);


	/**
	 * 更新投票选项
	 * @param voteItem
	 */
	public abstract void updateVoteItem(VoteItem voteItem);
	
	
	/**
	 * 根据ID获取投票选项
	 * @param vid
	 */
	public abstract VoteItem queryVoteItemById(int viid);
	
	/**
	 * 获取所有投票选项
	 */
	public abstract List<VoteItem> queryAllVoteItems();
	
	 /** *//** 
     * 分页查询 
     * @param hql 查询的条件 
     * @param offset 开始记录 
     * @param length 一次查询几条记录 
     * @return 
     */  
    public abstract List<Vote> queryForPage(final String hql,final int offset,final int length);  
      
    /** *//** 
     * 查询所有记录数 
     * @param hql 查询的条件 
     * @return 总记录数 
     */  
    public abstract int getAllRowCount(String hql);  
  
}
