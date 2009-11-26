package cn.gdpu.service.impl;

import java.util.List;
import java.util.Set;

import cn.gdpu.bean.PageBean;
import cn.gdpu.dao.LeaveApplyDao;
import cn.gdpu.service.LeaveApplyService;
import cn.gdpu.vo.LeaveApply;
import cn.gdpu.vo.Student;

public class LeaveApplyServiceImpl implements LeaveApplyService {
	private LeaveApplyDao leaveApplyDao;

	public void addLeaveApply(LeaveApply leaveApply) {
		leaveApplyDao.insertLeaveApply(leaveApply);
	}

	public void delLeaveApplyByID(int lid) {
		leaveApplyDao.deleteLeaveApplyByID(lid);
	}

	public void delLeaveApplyByStuID(int sid) {
		leaveApplyDao.deleteLeaveApplyByStuID(sid);
	}

	public LeaveApply getLeaveApply(int lid) {
		return leaveApplyDao.queryLeaveApply(lid);
	}

	public Set<LeaveApply> getLeaveApplysByStuID(int sid) {
		return leaveApplyDao.queryLeaveApplysByStuID(sid);
	}
	
	 /** *//** 
     * 分页查询 
     * @param currentPage 当前第几页 
     * @param pageSize 每页大小 
     * @return 封闭了分页信息(包括记录集list)的Bean 
     */  
    public PageBean queryForPage(int pageSize,int page,Student stu ){  
    	String hql;
    	if(stu == null){
    		hql = "from LeaveApply";        //查询语句  
    	}else{
    		hql = "from LeaveApply where stu_leave_id=" + stu.getStuId();        //查询语句  
    	}
        int allRow = leaveApplyDao.getAllRowCount(hql);    //总记录数  
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //总页数  
        final int offset = PageBean.countOffset(pageSize, page);    //当前页开始记录  
        final int length = pageSize;    //每页记录数  
        final int currentPage = PageBean.countCurrentPage(page);  
        List<LeaveApply> list = leaveApplyDao.queryForPage(hql , offset , length);        //"一页"的记录  
          
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

	public void updateLeaveApply(LeaveApply leaveApply) {
		leaveApplyDao.updateLeaveApply(leaveApply);
	}
	
	public void setLeaveApplyPass(int lid,int pass) {
		LeaveApply leaveApply = leaveApplyDao.queryLeaveApply(lid);
		leaveApply.setPass(pass);
		leaveApplyDao.updateLeaveApply(leaveApply);
	}

	public LeaveApplyDao getLeaveApplyDao() {
		return leaveApplyDao;
	}

	public void setLeaveApplyDao(LeaveApplyDao leaveApplyDao) {
		this.leaveApplyDao = leaveApplyDao;
	}

	

}
