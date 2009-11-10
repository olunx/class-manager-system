package cn.gdpu.service.impl;

import java.util.List;

import cn.gdpu.dao.AttendanceDao;
import cn.gdpu.service.AttendanceService;
import cn.gdpu.vo.Attendance;

public class AttendanceServiceImpl implements AttendanceService {

	AttendanceDao attendanceDao;

	public void setAttendanceDao(AttendanceDao attendanceDao) {
		this.attendanceDao = attendanceDao;
	}

	public AttendanceDao getAttendanceDao() {
		return attendanceDao;
	}

	public void add(Attendance attendance) {
		attendanceDao.insertAttendance(attendance);
	}

	public void delete(int aid) {
		attendanceDao.deleteAttendanceByAid(aid);
	}

	public List<Attendance> getAllAttendances() {
		return attendanceDao.queryAllAttendances();
	}

	public Attendance getAttendanceByWeekDay(int week, int day) {
		return attendanceDao.queryAttendanceByWeekDay(week, day);
	}

	public void update(Attendance attendance) {
		attendanceDao.updateAttendance(attendance);
	}

	public Attendance getAttendanceByAid(int aid) {
		return attendanceDao.queryAttendanceByAid(aid);
	}

}
