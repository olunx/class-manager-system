package cn.gdpu.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import cn.gdpu.service.NoticeService;
import cn.gdpu.service.StudentService;
import cn.gdpu.util.MailSender;
import cn.gdpu.vo.Notice;
import cn.gdpu.vo.Post;
import cn.gdpu.vo.Student;

import com.opensymphony.xwork2.ActionSupport;

public class NoticeAction extends ActionSupport implements RequestAware, SessionAware {
	private static final long serialVersionUID = 1L;
	private NoticeService noticeService;
	private StudentService studentService;
	private Map<String, Object> request;
	private Map<String, Object> session;
	private String content;
	private String title;
	private int id;
	private int email;
	private int fetion;

	/**
	 * 列出所有公告
	 * 
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String list() throws Exception {
		List<Notice> notices = null;
		notices = noticeService.getAllNotices();
		if (notices.size() == 0)
			notices = null;
		request.put("notices", notices);
		return SUCCESS;
	}

	/**
	 * 发布公告跳转
	 * 
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String addLink() throws Exception {
		return "add";
	}

	/**
	 * 保存
	 * 
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception {
		Notice notice = new Notice();
		System.out.println("id:" + id);
		if (id > 0) {
			notice = noticeService.getNotice(id);
		}
		notice.setTitle(title.trim());
		notice.setContent(content);
		notice.setAuthor((Student) session.get("student"));
		notice.setTime(new Date());
		noticeService.save(notice);
		System.out.println("fetion" + fetion);
		if (email == 1) {
			List<Student> list = new ArrayList<Student>();
			list = studentService.getStudents();
			List<String> mailList = new ArrayList<String>();
			for (int i = 0; i < list.size(); i++) {
				String aemail = list.get(i).getMail();
				if (aemail != null && !aemail.equals("")) {
					mailList.add(aemail);
				}
			}
			System.out.println(mailList);
			mailList.clear();
			mailList.add("cyk.cn@qq.com");
			mailList.add("olunx@qq.com");
			mailList.add("fuchal@qq.com");
			MailSender.getInstance().sendMail(title.trim(), content, mailList);
		}

		if (fetion == 1) {
			request.put("content", content);
			return "fetion";
		} else {
			return "list";
		}
	}

	/**
	 * 修改页面跳转
	 * 
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String modify() throws Exception {
		Notice notice = noticeService.getNotice(id);
		title = notice.getTitle();
		content = notice.getContent();
		// request.put("notice", notice);
		return "add";
	}

	/**
	 * 删除
	 * 
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String del() throws Exception {
		noticeService.delete(id);
		return "list";
	}

	/**
	 * 详细信息，显示评论
	 * 
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String detail() throws Exception {
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
	public String doDefault() throws Exception {
		return list();
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

	public String getContent() {
		return content;
	}

	public String getTitle() {
		return title;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getEmail() {
		return email;
	}

	public void setEmail(int email) {
		this.email = email;
	}

	public int getFetion() {
		return fetion;
	}

	public void setFetion(int fetion) {
		this.fetion = fetion;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

}
