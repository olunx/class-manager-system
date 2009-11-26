package cn.gdpu.service;



import java.util.List;

import cn.gdpu.bean.PageBean;
import cn.gdpu.vo.Vote;
import cn.gdpu.vo.VoteItem;

public interface VoteService {
	
	//投票
	
	/**
	 * 添加投票
	 * @param vote
	 */
	public abstract void addVote(Vote vote);
	
	/**
	 * 根据ID删除投票
	 * @param vid
	 */
	public abstract void deleteVote(int vid);
	
	/**
	 * 更新投票
	 * @param vote
	 */
	public abstract void updateVote(Vote vote);
	
	/**
	 * 根据ID获取投票
	 * @param vid
	 */
	public abstract Vote getVote(int vid);
	
	/**
	 * 获取所有投票
	 */
	public abstract List<Vote> getNewVotes();
	/**
	 * 获取热门投票
	 * @return
	 */
	public abstract List<Vote> getHotVotes();
	
	//投票选项
	
	/**
	 * 添加投票选项
	 * @param voteItem
	 */
	public abstract void addVoteItem(VoteItem voteItem);
	
	/**
	 * 根据ID删除投票选项
	 * @param viid
	 */
	public abstract void deleteVoteItem(int viid);
	
	/**
	 * 更新投票选项
	 * @param voteItem
	 */
	public abstract void updateVoteItem(VoteItem voteItem);
	
	/**
	 * 根据ID获取投票选项
	 * @param viid
	 */
	public abstract VoteItem getVoteItem(int viid);
	
	/**
	 * 获取所有投票选项
	 */
	public abstract List<VoteItem> getAllVoteItems();
	


	/** *//** 
     * 分页查询 
     * @param currentPage 当前第几页 
     * @param pageSize 每页大小 
     * @return 封闭了分页信息(包括记录集list)的Bean 
     */  
    public abstract PageBean queryForPage(int pageSize,int currentPage); 
}
