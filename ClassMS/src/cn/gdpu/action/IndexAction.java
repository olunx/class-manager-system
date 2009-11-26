package cn.gdpu.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import cn.gdpu.service.NoticeService;
import cn.gdpu.service.VoteService;
import cn.gdpu.vo.Notice;
import cn.gdpu.vo.Vote;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport implements RequestAware{
	private static final long serialVersionUID = 1L;
	private NoticeService noticeService;
	private VoteService voteService;
	
	private Map<String, Object> request;
	
	@Override
	public String execute() throws Exception {
		List<Notice> notices = null;
		notices = noticeService.getAllNotices();
		if (notices.size() == 0)
			notices = null;
		request.put("notices", notices);
		
		//列出热门投票
		List<Vote> votes = new ArrayList<Vote>();
		votes = voteService.getHotVotes();
		if(votes.size() == 0)
			votes = null;
		request.put("votes", votes);
		
		//列出最新投票
		List<Vote> newvotes = new ArrayList<Vote>();
		newvotes = voteService.getNewVotes();
		if(votes.size() == 0)
			votes = null;
		request.put("newvotes", newvotes);
			
		return SUCCESS;
	}
	
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public NoticeService getNoticeService() {
		return noticeService;
	}
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	public VoteService getVoteService() {
		return voteService;
	}

	public void setVoteService(VoteService voteService) {
		this.voteService = voteService;
	}

}
