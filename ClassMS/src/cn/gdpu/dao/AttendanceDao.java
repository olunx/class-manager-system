package cn.gdpu.dao;

import java.util.List;

import cn.gdpu.vo.Attendance;

public interface AttendanceDao {
	
	/**
	 * 添加一条考勤记录
	 * @param attendance
	 */
	public abstract void insertAttendance(Attendance attendance);
	
	/**
	 * 删除一条考勤记录
	 * @param aid
	 */
	public abstract void deleteAttendanceByAid(int aid);

	/**
	 * 更新一条考勤记录
	 * @param attendance
	 */
	public abstract void updateAttendance(Attendance attendance);
	
	/**
	 * 获取一条考勤记录
	 * @param week,day
	 * @return
	 */
	public abstract Attendance queryAttendanceByWeekDay(int week, int day);
	
	/**
	 * 获取一条考勤记录
	 * @param aid
	 * @return
	 */
	public abstract Attendance queryAttendanceByAid(int aid);
	
	/**
	 * 获取所有考勤记录
	 * @return
	 */
	public abstract List<Attendance> queryAllAttendances();
	
	/** *//** 
     * 分页查询 
     * @param hql 查询的条件 
     * @param offset 开始记录 
     * @param length 一次查询几条记录 
     * @return 
     */  
	public abstract List<Attendance> queryForPage(final String hql,final int offset,final int length);  
 
    /** *//** 
     * 查询所有记录数 
     * @param hql 查询的条件 
     * @return 总记录数 
     */  
    public abstract int getAllRowCount(String hql);  
}
