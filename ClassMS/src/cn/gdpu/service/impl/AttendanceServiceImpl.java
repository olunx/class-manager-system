package cn.gdpu.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.gdpu.bean.AttendanceComparator;
import cn.gdpu.bean.PageBean;
import cn.gdpu.dao.AttendanceDao;
import cn.gdpu.dao.StudentDao;
import cn.gdpu.service.AttendanceService;
import cn.gdpu.vo.Attendance;
import cn.gdpu.vo.Student;

public class AttendanceServiceImpl implements AttendanceService {

	AttendanceDao attendanceDao;
	StudentDao studentDao;

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

	/** */
	/**
	 * 分页查询
	 * 
	 * @param currentPage
	 *            当前第几页
	 * @param pageSize
	 *            每页大小
	 * @return 封闭了分页信息(包括记录集list)的Bean
	 */
	public PageBean queryForPage(int pageSize, int page) {

		final String hql = "from Attendance"; // 查询语句
		int allRow = attendanceDao.getAllRowCount(hql); // 总记录数
		int totalPage = PageBean.countTotalPage(pageSize, allRow); // 总页数
		final int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page);
		List<Attendance> list = attendanceDao.queryForPage(hql, offset, length); // "一页"的记录

		// 把分页信息保存到Bean中
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

	public List<Student> getTopTruant(int num) {
		List<Student> stus = studentDao.queryAllStudents();
		List<Student> retstus = new ArrayList<Student>();
		if (stus != null && stus.size() > 0) {
			AttendanceComparator<Student> attendanceComparator = new AttendanceComparator<Student>();
			Collections.sort(stus, attendanceComparator);

			for (int i=0;i<num;i++){
				if (stus.get(i).getAttendances().size() > 0)	retstus.add(stus.get(i));
			}
		}
		return retstus;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

}
