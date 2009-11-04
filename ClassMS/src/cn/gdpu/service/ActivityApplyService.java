package cn.gdpu.service;

import java.util.Set;

import cn.gdpu.vo.ActivityApply;


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
}
