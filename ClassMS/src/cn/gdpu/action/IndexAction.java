package cn.gdpu.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import cn.gdpu.service.AttendanceService;
import cn.gdpu.service.NoticeService;
import cn.gdpu.service.VoteService;
import cn.gdpu.vo.Notice;
import cn.gdpu.vo.Student;
import cn.gdpu.vo.Vote;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport implements RequestAware {
	private static final long serialVersionUID = 1L;
	private NoticeService noticeService;
	private VoteService voteService;
	private AttendanceService attendanceService;

	private Map<String, Object> request;

	@Override
	public String execute() throws Exception {
		// 公告
		List<Notice> notices = null;
		notices = noticeService.getAllNotices();
		if (notices.size() == 0)
			notices = null;
		request.put("notices", notices);

		// 列出热门投票
		List<Vote> votes = new ArrayList<Vote>();
		votes = voteService.getHotVotes();
		if (votes.size() == 0)
			votes = null;
		request.put("votes", votes);

		// 逃课排行榜
		List<Student> topTruants = new ArrayList<Student>();
		topTruants = attendanceService.getTopTruant(5);
		if (topTruants == null || topTruants.size() == 0)
			topTruants = null;
		request.put("topTruants", topTruants);
		
		//列出最新投票
		List<Vote> newvotes = new ArrayList<Vote>();
		newvotes = voteService.getNewVotes();
		if(newvotes.size() == 0)
			newvotes = null;
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

	public AttendanceService getAttendanceService() {
		return attendanceService;
	}

	public void setAttendanceService(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}

}
