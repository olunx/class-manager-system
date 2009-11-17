package cn.gdpu.vo;

import java.util.HashSet;
import java.util.Set;

public class Student {

	private int stuId;
	private String avatar;
	private String username;
	private String password;
	private String sno;
	private String realName;
	private String dorm;
	private Set<Duty> dutys;
	private long phoneNo;
	private long qq;
	private String mail;
	private Set<ActivityApply> activityApplys = new HashSet<ActivityApply>();
	private Set<Attendance> attendances;
	
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getDorm() {
		return dorm;
	}
	public void setDorm(String dorm) {
		this.dorm = dorm;
	}
	public Set<Duty> getDutys() {
		return dutys;
	}
	public void setDutys(Set<Duty> dutys) {
		this.dutys = dutys;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public long getQq() {
		return qq;
	}
	public void setQq(long qq) {
		this.qq = qq;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Set<ActivityApply> getActivityApplys() {
		return activityApplys;
	}
	public void setActivityApplys(Set<ActivityApply> activityApplys) {
		this.activityApplys = activityApplys;
	}
	public Set<Attendance> getAttendances() {
		return attendances;
	}
	public void setAttendances(Set<Attendance> attendances) {
		this.attendances = attendances;
	}

}
