package cn.gdpu.vo;

import java.util.Date;

public class LeaveApply {
	private int lid;
	private Student student;
	private Leader leader; 
	private int pass;//0：默认值(未审核),1:通过,2不通过
	private String remarks;
	private String content;
	private Date time;
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Leader getLeader() {
		return leader;
	}
	public void setLeader(Leader leader) {
		this.leader = leader;
	}
	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		this.pass = pass;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
