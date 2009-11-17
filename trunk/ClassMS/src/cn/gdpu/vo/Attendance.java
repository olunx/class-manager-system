package cn.gdpu.vo;

import java.util.Date;
import java.util.Set;

public class Attendance {
	private int aid;
	private Set<Student> students;
	private Student clerk;
	private String subject;
	private Date time;
	private String week;
	private String day;
	private String lesson;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Student getClerk() {
		return clerk;
	}

	public void setClerk(Student clerk) {
		this.clerk = clerk;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getLesson() {
		return lesson;
	}

	public void setLesson(String lesson) {
		this.lesson = lesson;
	}

	@Override
	public String toString() {
		return "Attendance [aid=" + aid + ", day=" + day + ", lesson=" + lesson + ", subject=" + subject + ", time=" + time + ", week=" + week + "]";
	}

}
