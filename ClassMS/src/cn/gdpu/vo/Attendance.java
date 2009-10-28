package cn.gdpu.vo;

import java.util.Date;

public class Attendance {
	private Student student;
	private Student clerk;
	private String subject;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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

	private Date time;
}
