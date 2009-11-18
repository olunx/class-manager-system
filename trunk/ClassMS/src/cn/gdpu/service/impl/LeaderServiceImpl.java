package cn.gdpu.service.impl;

import java.util.List;

import cn.gdpu.bean.PageBean;
import cn.gdpu.dao.LeaderDao;
import cn.gdpu.service.LeaderService;
import cn.gdpu.vo.ClassFee;
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

	/** *//** 
     * 分页查询 
     * @param currentPage 当前第几页 
     * @param pageSize 每页大小 
     * @return 封闭了分页信息(包括记录集list)的Bean 
     */  
    public PageBean queryForPage(int pageSize,int page){  
  
        final String hql = "from Leader";        //查询语句  
        int allRow = leaderDao.getAllRowCount(hql);    //总记录数  
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //总页数  
        final int offset = PageBean.countOffset(pageSize, page);    //当前页开始记录  
        final int length = pageSize;    //每页记录数  
        final int currentPage = PageBean.countCurrentPage(page);  
        List<Leader> list = leaderDao.queryForPage(hql,offset, length);        //"一页"的记录  
          
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
