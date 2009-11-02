package cn.gdpu.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gdpu.dao.VoteDao;
import cn.gdpu.vo.Vote;
import cn.gdpu.vo.VoteItem;


public class VoteDaoImpl extends HibernateDaoSupport implements VoteDao {

	//投票
	
	public void insertVote(Vote vote) {
		this.getHibernateTemplate().save(vote);
	}
	
	public void deleteVoteById(int vid) {
		Vote vote = null;
		vote = (Vote)this.getHibernateTemplate().get(Vote.class, vid);
		if(vote != null)
			this.getHibernateTemplate().delete(vote);
	}
	
	public void updateVote(Vote vote) {
		this.getHibernateTemplate().update(vote);
	}
	
	public Vote queryVoteById(int vid) {
		Vote vote = null;
		vote = (Vote)this.getHibernateTemplate().get(Vote.class, vid);
		return vote;
	}
	
	@SuppressWarnings("unchecked")
	public List<Vote> queryAllVotes() {
		List<Vote> votes = null;
		votes = this.getHibernateTemplate().find("from Vote");
		return votes;
	}
	
	//投票选项
	
	public void insertVoteItem(VoteItem voteItem) {
		this.getHibernateTemplate().save(voteItem);
	}
	
	public void deleteVoteItemById(int viid) {
		VoteItem voteItem = null;
		voteItem = (VoteItem)this.getHibernateTemplate().get(VoteItem.class, viid);
		if(voteItem != null)
			this.getHibernateTemplate().delete(voteItem);
	}
	
	public void updateVoteItem(VoteItem voteItem) {
		this.getHibernateTemplate().update(voteItem);
	}
	
	public VoteItem queryVoteItemById(int viid) {
		VoteItem voteItem = null;
		voteItem = (VoteItem)this.getHibernateTemplate().get(VoteItem.class, viid);
		return voteItem;
	}
	
	@SuppressWarnings("unchecked")
	public List<VoteItem> queryAllVoteItems() {
		List<VoteItem> voteItems = null;
		voteItems = this.getHibernateTemplate().find("from VoteItem");
		return voteItems;
	}
}
