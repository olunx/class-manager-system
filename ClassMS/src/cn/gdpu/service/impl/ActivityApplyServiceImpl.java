package cn.gdpu.service.impl;

import java.util.List;
import java.util.Set;

import cn.gdpu.bean.PageBean;
import cn.gdpu.dao.ActivityApplyDao;
import cn.gdpu.service.ActivityApplyService;
import cn.gdpu.vo.ActivityApply;
import cn.gdpu.vo.Student;

public class ActivityApplyServiceImpl implements ActivityApplyService {
	private ActivityApplyDao activityApplyDao;

	public void addActivityApply(ActivityApply activityApply) {
		activityApplyDao.insertActivityApply(activityApply);
	}

	public void delActivityApplyByID(int aid) {
		activityApplyDao.deleteActivityApplyByID(aid);
	}

	public void delActivityApplyByStuID(int sid) {
		activityApplyDao.deleteActivityApplyByStuID(sid);
	}

	public ActivityApply getActivityApply(int aid) {
		return activityApplyDao.queryActivityApply(aid);
	}

	public Set<ActivityApply> getActivityApplysByStuID(int sid) {
		return activityApplyDao.queryActivityApplysByStuID(sid);
	}
	
	 /** *//** 
     * 分页查询 
     * @param currentPage 当前第几页 
     * @param pageSize 每页大小 
     * @return 封闭了分页信息(包括记录集list)的Bean 
     */  
    public PageBean queryForPage(int pageSize,int page,Student stu ){  
        final String hql = "from ActivityApply where student_id=" + stu.getStuId();        //查询语句  
        int allRow = activityApplyDao.getAllRowCount(hql);    //总记录数  
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //总页数  
        final int offset = PageBean.countOffset(pageSize, page);    //当前页开始记录  
        final int length = pageSize;    //每页记录数  
        final int currentPage = PageBean.countCurrentPage(page);  
        List<ActivityApply> list = activityApplyDao.queryForPage(hql,offset, length);        //"一页"的记录  
          
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

	public void updateActivityApply(ActivityApply activityApply) {
		activityApplyDao.updateActivityApply(activityApply);
	}

	public ActivityApplyDao getActivityApplyDao() {
		return activityApplyDao;
	}

	public void setActivityApplyDao(ActivityApplyDao activityApplyDao) {
		this.activityApplyDao = activityApplyDao;
	}

	public void setActivityApplyPass(int aid,int pass) {
		ActivityApply activityApply = activityApplyDao.queryActivityApply(aid);
		activityApply.setPass(pass);
		activityApplyDao.updateActivityApply(activityApply);
	}

}
