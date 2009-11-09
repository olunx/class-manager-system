package cn.gdpu.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gdpu.dao.AttendanceDao;
import cn.gdpu.vo.Attendance;

public class AttendanceDaoImpl extends HibernateDaoSupport implements AttendanceDao {

	public void deleteAttendanceByAid(int aid) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().load(Attendance.class, aid));
	}

	public void insertAttendance(Attendance attendance) {
		this.getHibernateTemplate().save(attendance);
	}

	@SuppressWarnings("unchecked")
	public List<Attendance> queryAllAttendances() {
		return this.getHibernateTemplate().find("form Attendance");
	}

	@SuppressWarnings("unchecked")
	public Attendance queryAttendanceByWeekDay(int week, int day) {
		//return (Attendance) this.getHibernateTemplate().find("form Attendance where week=='" + week + "'&day=='" + day + "'").get(0);
		Attendance attendance = null;
		List list = this.getHibernateTemplate().find("form Attendance where week=='" + week + "'&day=='" + day + "'");
		if (list != null && list.size() > 0) {
			attendance = (Attendance) list.get(0);
		}
		return attendance;
	}

	public void updateAttendance(Attendance attendance) {
		this.getHibernateTemplate().update(attendance);
	}

}
