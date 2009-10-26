package cn.gdpu.vo;

import java.util.Date;

public class Voting {
	private Student author;
	private String title;
	private Options options;
	
	public Student getAuthor() {
		return author;
	}
	public void setAuthor(Student author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Options getOptions() {
		return options;
	}
	public void setOptions(Options options) {
		this.options = options;
	}
	public Date getAirTime() {
		return airTime;
	}
	public void setAirTime(Date airTime) {
		this.airTime = airTime;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	private Date airTime;
	private Date deadline;
}
