package cn.gdpu.service;

import java.util.List;

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
	public abstract Attendance getLeaderByWeekDay(int week, int day);
	
	/**
	 * 获取所有考勤信息
	 * @return
	 */
	public abstract List<Attendance> getAllAttendances();

}
