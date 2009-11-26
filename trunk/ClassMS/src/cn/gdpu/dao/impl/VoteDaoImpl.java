package cn.gdpu.dao.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
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
	public List<Vote> queryNewVotes() {
		List<Vote> votes = null;
		votes = this.getHibernateTemplate().find("from Vote order by vid desc");
		return votes;
	}
	public List<Vote> queryRealVotes() {
		List<Vote> votes = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String str1 = sdf.format(new Date());
        
		votes = this.getHibernateTemplate().find("from Vote Where deadline >= '" + str1 + "'");
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
	/** *//** 
     * 分页查询 
     * @param hql 查询的条件 
     * @param offset 开始记录 
     * @param length 一次查询几条记录 
     * @return 
     */  
    public List<Vote> queryForPage(final String hql,final int offset,final int length){  
        List list = getHibernateTemplate().executeFind(new HibernateCallback(){  
            public Object doInHibernate(Session session) throws HibernateException,SQLException{  
                Query query = session.createQuery(hql);  
                query.setFirstResult(offset);  
                query.setMaxResults(length);  
                List list = query.list();  
                return list;  
            }  
        });  
        return list;  
    }  
      
      
    /** *//** 
     * 查询所有记录数 
     * @return 总记录数 
     */  
    public int getAllRowCount(String hql){  
        return getHibernateTemplate().find(hql).size();  
    }  
}
