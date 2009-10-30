package cn.gdpu.action;

import java.util.List;

import cn.gdpu.service.NoticeService;
import cn.gdpu.vo.Notice;

import com.opensymphony.xwork2.ActionSupport;

public class NoticeAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private NoticeService noticeService;

	public String doList() throws Exception {
		@SuppressWarnings("unused")
		List<Notice> notices = null;
		notices = noticeService.getAllNotices();
		return SUCCESS;
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	

}
