package cn.gdpu.service;

import java.util.Set;

import cn.gdpu.bean.PageBean;
import cn.gdpu.vo.LeaveApply;
import cn.gdpu.vo.Student;


public interface LeaveApplyService {
	/**
	 * 插入请假申请
	 * @param leaveApply
	 */
	public abstract void addLeaveApply(LeaveApply leaveApply);
	
	/**
	 * 根据ID删除
	 * @param lid
	 */
	public abstract void delLeaveApplyByID(int lid);
	
	/**
	 * 根据学生ID删除
	 * @param sid
	 */
	public abstract void delLeaveApplyByStuID(int sid);
	
	/**
	 * 更新
	 * @param leaveApply
	 */
	public abstract void updateLeaveApply(LeaveApply leaveApply);
	
	/**
	 * 查找一个请假
	 * @param lid
	 * @return
	 */
	public abstract LeaveApply getLeaveApply(int lid);
	
	/**
	 * 找出此学生的所有请假申请
	 * @param sid
	 * @return
	 */
	public abstract Set<LeaveApply> getLeaveApplysByStuID(int sid);
	
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
	public abstract void setLeaveApplyPass(int lid,int pass);
}

