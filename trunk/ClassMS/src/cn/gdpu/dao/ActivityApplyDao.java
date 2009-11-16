package cn.gdpu.dao;

import java.util.List;
import java.util.Set;

import cn.gdpu.vo.ActivityApply;

public interface ActivityApplyDao {
	
	/**
	 * 插入活动申请
	 * @param activityApply
	 */
	public abstract void insertActivityApply(ActivityApply activityApply);
	
	/**
	 * 根据活动ID删除
	 * @param aid
	 */
	public abstract void deleteActivityApplyByID(int aid);
	
	/**
	 * 根据学生ID删除
	 * @param sid
	 */
	public abstract void deleteActivityApplyByStuID(int sid);
	
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
	public abstract ActivityApply queryActivityApply(int aid);
	
	/**
	 * 找出此学生的所有活动申请
	 * @param sid
	 * @return
	 */
	public abstract Set<ActivityApply> queryActivityApplysByStuID(int sid);
	
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
