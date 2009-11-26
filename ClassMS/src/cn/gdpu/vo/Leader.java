package cn.gdpu.vo;

import java.util.HashSet;
import java.util.Set;

public class Leader {

	private int leaderId;
	private String username;
	private String password;
	private String realName;
	private String avatar;
	private String remark;
	private Set<LeaveApply> leaveApplys = new HashSet<LeaveApply>();

	public int getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(int leaderId) {
		this.leaderId = leaderId;
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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public Set<LeaveApply> getLeaveApplys() {
		return leaveApplys;
	}

	public void setLeaveApplys(Set<LeaveApply> leaveApplys) {
		this.leaveApplys = leaveApplys;
	}

}
