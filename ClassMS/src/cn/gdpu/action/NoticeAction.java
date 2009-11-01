package cn.gdpu.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import cn.gdpu.service.NoticeService;
import cn.gdpu.vo.Notice;
import cn.gdpu.vo.Post;

import com.opensymphony.xwork2.ActionSupport;

public class NoticeAction extends ActionSupport implements RequestAware {
	private static final long serialVersionUID = 1L;
	private NoticeService noticeService;
	private Map<String, Object> request;
	private String content;
	private String title;
	private int id;

	/**
	 * 列出所有公告
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doList() throws Exception {
		List<Notice> notices = null;
		notices = noticeService.getAllNotices();
		request.put("notices", notices);
		return SUCCESS;
	}

	/**
	 * 发布公告跳转
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doAdd() throws Exception {
		return "add";
	}

	/**
	 * 保存
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doSave() throws Exception {
		Notice notice = new Notice();
		notice.setNid(id);
		notice.setTitle(title);
		notice.setContent(content);
		notice.setTime(new Date());
		noticeService.save(notice);
		return "list";
	}

	/**
	 * 修改页面跳转
	 * @return
	 * @throws Exception
	 */
	public String doModify() throws Exception {
		Notice notice = noticeService.getNotice(id);
		request.put("notice", notice);
		return "add";
	}

	/**
	 * 删除
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doDel() throws Exception {
		System.out.println("action-------" + id);
		noticeService.delete(id);
		return "list";
	}
	
	/**
	 * 详细信息，显示评论
	 * @return
	 * @throws Exception
	 */
	public String doDetail() throws Exception {
		Notice notice = noticeService.getNotice(id);
		List<Post> posts = noticeService.getPosts(id);
		request.put("notice", notice);
		request.put("posts", posts);
		return SUCCESS;
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}

	@Override
	public String doDefault() throws Exception {
		return doList();
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setId(int id) {
		this.id = id;
	}

}
