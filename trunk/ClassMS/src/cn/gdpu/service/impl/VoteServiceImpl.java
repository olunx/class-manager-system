package cn.gdpu.service.impl;

import java.util.List;


import cn.gdpu.bean.PageBean;
import cn.gdpu.dao.VoteDao;
import cn.gdpu.service.VoteService;
import cn.gdpu.vo.Vote;
import cn.gdpu.vo.VoteItem;

public class VoteServiceImpl implements VoteService {	
	
	private VoteDao voteDao;

	//投票
	
	

	public void addVote(Vote vote) {
		voteDao.insertVote(vote);
	}

	public void deleteVote(int vid) {
		voteDao.deleteVoteById(vid);
	}

	public Vote getVote(int vid) {
		return voteDao.queryVoteById(vid);
	}

	public List<Vote> getAllVotes() {
		return voteDao.queryAllVotes();
	}

	public void updateVote(Vote vote) {
		voteDao.updateVote(vote);
	}

	//投票选项
	
	public void addVoteItem(VoteItem voteItem) {
		voteDao.insertVoteItem(voteItem);
	}

	public void deleteVoteItem(int viid) {
		voteDao.deleteVoteItemById(viid);
	}

	public VoteItem getVoteItem(int viid) {
		return voteDao.queryVoteItemById(viid);
	}

	public List<VoteItem> getAllVoteItems() {
		return voteDao.queryAllVoteItems();
	}

	public void updateVoteItem(VoteItem voteItem) {
		voteDao.updateVoteItem(voteItem);
	}

	public VoteDao getVoteDao() {
		return voteDao;
	}

	public void setVoteDao(VoteDao voteDao) {
		this.voteDao = voteDao;
	}
	
	 /** *//** 
     * 分页查询 
     * @param currentPage 当前第几页 
     * @param pageSize 每页大小 
     * @return 封闭了分页信息(包括记录集list)的Bean 
     */  
    public PageBean queryForPage(int pageSize,int page){  
  
        final String hql = "from Vote";        //查询语句  
        int allRow = voteDao.getAllRowCount(hql);    //总记录数  
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //总页数  
        final int offset = PageBean.countOffset(pageSize, page);    //当前页开始记录  
        final int length = pageSize;    //每页记录数  
        final int currentPage = PageBean.countCurrentPage(page);  
        List<Vote> list = voteDao.queryForPage(hql,offset, length);        //"一页"的记录  
          
        //把分页信息保存到Bean中  
        PageBean pageBean = new PageBean();  
        pageBean.setPageSize(pageSize);      
        pageBean.setCurrentPage(currentPage);  
        pageBean.setAllRow(allRow);  
        pageBean.setTotalPage(totalPage);  
        pageBean.setList(list);  
        pageBean.init();  
        return pageBean;  
    }  
	
}
