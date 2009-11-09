package cn.gdpu.action;

import cn.gdpu.service.LeaderService;

import com.opensymphony.xwork2.ActionSupport;

public class LeaderAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private LeaderService leaderService;
	
	
	public LeaderService getLeaderService() {
		return leaderService;
	}
	public void setLeaderService(LeaderService leaderService) {
		this.leaderService = leaderService;
	}

}
