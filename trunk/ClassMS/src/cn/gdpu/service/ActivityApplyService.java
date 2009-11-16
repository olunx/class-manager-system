package cn.gdpu.service;

import java.util.Set;

import cn.gdpu.bean.PageBean;
import cn.gdpu.vo.ActivityApply;
import cn.gdpu.vo.Student;


public interface ActivityApplyService {
	/**
	 * 插入活动申请
	 * @param activityApply
	 */
	public abstract void addActivityApply(ActivityApply activityApply);
	
	/**
	 * 根据活动ID删除
	 * @param aid
	 */
	public abstract void delActivityApplyByID(int aid);
	
	/**
	 * 根据学生ID删除
	 * @param sid
	 */
	public abstract void delActivityApplyByStuID(int sid);
	
	/**
	 * 更新
	 * @param activityApply
	 */
	public abstract void updateActivityApply(ActivityApply activityApply);
	
	/**
	 * 查找一个活动
	 * @param aid
	 * @return
	 */
	public abstract ActivityApply getActivityApply(int aid);
	
	/**
	 * 找出此学生的所有活动申请
	 * @param sid
	 * @return
	 */
	public abstract Set<ActivityApply> getActivityApplysByStuID(int sid);
	
	 /** *//** 
     * 分页查询 
     * @param currentPage 当前第几页 
     * @param pageSize 每页大小 
     * @return 封闭了分页信息(包括记录集list)的Bean 
     */  
    public PageBean queryForPage(int pageSize,int currentPage,Student stu);  
	
	/**
	 * 设置申请的状态
	 * @param pass
	 */
	public abstract void setActivityApplyPass(int aid,int pass);
}

