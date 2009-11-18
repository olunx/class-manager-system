package cn.gdpu.service;

import java.util.List;

import cn.gdpu.bean.PageBean;
import cn.gdpu.vo.Attendance;

public interface AttendanceService {
	
	/**
	 * 添加一条考勤信息
	 * @param attendance
	 */
	public abstract void add(Attendance attendance);
	
	/**
	 * 删除一条考勤信息
	 * @param aid
	 */
	public abstract void delete(int aid);
	
	/**
	 * 更新一条考勤信息
	 * @param attendance
	 */
	public abstract void update(Attendance attendance);
	
	/**
	 * 获取一条考勤信息
	 * @param week,day
	 * @return
	 */
	public abstract Attendance getAttendanceByWeekDay(int week, int day);
	
	/**
	 * 获取一条考勤信息
	 * @param aid
	 * @return
	 */
	public abstract Attendance getAttendanceByAid(int aid);
	
	/**
	 * 获取所有考勤信息
	 * @return
	 */
	public abstract List<Attendance> getAllAttendances();

	/** *//** 
     * 分页查询 
     * @param currentPage 当前第几页 
     * @param pageSize 每页大小 
     * @return 封闭了分页信息(包括记录集list)的Bean 
     */  
    public abstract PageBean queryForPage(int pageSize,int currentPage);  
}
