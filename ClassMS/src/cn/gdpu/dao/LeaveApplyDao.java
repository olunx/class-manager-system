package cn.gdpu.dao;

import java.util.List;
import java.util.Set;

import cn.gdpu.vo.LeaveApply;


public interface LeaveApplyDao {
	
	/**
	 * 插入请假申请
	 */
	public abstract void insertLeaveApply(LeaveApply leaveApply);
	
	/**
	 * 根据ID删除
	 * @param aid
	 */
	public abstract void deleteLeaveApplyByID(int lid);
	
	/**
	 * 根据学生ID删除
	 * @param sid
	 */
	public abstract void deleteLeaveApplyByStuID(int sid);
	
	/**
	 * 更新
	 * @param activityApply
	 */
	public abstract void updateLeaveApply(LeaveApply leaveApply);
	
	/**
	 * 查找一个请假
	 * @param lid
	 * @return
	 */
	public abstract LeaveApply queryLeaveApply(int lid);
	
	/**
	 * 找出此学生的所有活动申请
	 * @param sid
	 * @return
	 */
	public abstract Set<LeaveApply> queryLeaveApplysByStuID(int sid);
	
	 /** *//** 
     * 分页查询 
     * @param hql 查询的条件 
     * @param offset 开始记录 
     * @param length 一次查询几条记录 
     * @return 
     */  
    public List queryForPage(final String hql,final int offset,final int length);  
      
    /** *//** 
     * 查询所有记录数 
     * @param hql 查询的条件 
     * @return 总记录数 
     */  
    public int getAllRowCount(String hql);  
}
