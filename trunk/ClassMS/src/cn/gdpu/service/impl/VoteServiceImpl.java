package cn.gdpu.service.impl;

import java.util.List;


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
	
}
