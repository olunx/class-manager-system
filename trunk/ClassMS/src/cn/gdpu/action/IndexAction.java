package cn.gdpu.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import cn.gdpu.service.NoticeService;
import cn.gdpu.vo.Notice;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport implements RequestAware{
	private static final long serialVersionUID = 1L;
	private NoticeService noticeService;
	private Map<String, Object> request;
	
	@Override
	public String execute() throws Exception {
		List<Notice> notices = null;
		notices = noticeService.getAllNotices();
		if (notices.size() == 0)
			notices = null;
		request.put("notices", notices);
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

}
