package cn.gdpu.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import cn.gdpu.service.NoticeService;
import cn.gdpu.vo.Notice;

import com.opensymphony.xwork2.ActionSupport;

public class NoticeAction extends ActionSupport implements RequestAware {
	private static final long serialVersionUID = 1L;
	private NoticeService noticeService;
	private Map<String, Object> request;

	public String doList() throws Exception {
		@SuppressWarnings("unused")
		List<Notice> notices = null;
		notices = noticeService.getAllNotices();
		request.put("notices", notices);
		return SUCCESS;
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	

}
