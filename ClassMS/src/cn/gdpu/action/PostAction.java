package cn.gdpu.action;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import cn.gdpu.service.NoticeService;
import cn.gdpu.service.PostService;
import cn.gdpu.vo.Post;
import cn.gdpu.vo.Student;

import com.opensymphony.xwork2.ActionSupport;

public class PostAction extends ActionSupport implements RequestAware,SessionAware {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> request;
	private Map<String, Object> session;
	private PostService postService;
	private NoticeService noticeService;
	private String content;
	private int id;
	private int pid;

	/**
	 * 添加评论
	 * @return
	 * @throws Exception
	 */
	public String addPost() throws Exception {
		Post post = new Post();
		post.setAuthor((Student) session.get("student"));
		post.setContent(content);
		System.out.println("nid-----"+id);
		post.setParent(noticeService.getNotice(id));
		post.setTime(new Date());
		postService.add(post);
		return "detail";
	}
	
	/**
	 * 删除评论
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String delPost() throws Exception {
		postService.delete(pid);
		return "detail";
	}
	
	/**
	 * 跳转到修改页面链接
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String modifyPost() throws Exception {
		Post post = postService.getPost(pid);
		request.put("post", post);
		return SUCCESS;
	}
	
	/**
	 * 保存修改
	 * @return
	 * @throws Exception
	 */
	public String updatePost() throws Exception {
		Post post = postService.getPost(pid);
		post.setContent(content);
		postService.update(post);
		return "detail";
	}
	
	
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public int getId() {
		return id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getContent() {
		return content;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
