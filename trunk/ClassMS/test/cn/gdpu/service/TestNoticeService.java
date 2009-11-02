package cn.gdpu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.gdpu.vo.Notice;

public class TestNoticeService {

	private static NoticeService noticeService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			noticeService = (NoticeService) ctx.getBean("noticeService");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void insertNotice() {
		Notice notice = new Notice();
		notice.setAuthor(null);
		notice.setContent("Test公告");
		notice.setComment(new ArrayList());
		notice.setTitle("Title2~~~");
		notice.setTime(new Date());
		noticeService.add(notice);
	}

	@Test
	public Notice getNotice() {
		Notice notice = noticeService.getNotice(27);
		if (notice != null)
			System.out.println(notice.getContent());
		return notice;
	}

	@Test
	public void getAllNotices() {
		List<Notice> notices = new ArrayList<Notice>();
		notices = noticeService.getAllNotices();
		if (notices != null) {
			for (Notice notice : notices) {
				System.out.println(notice.getTitle());
			}
		}
	}
	
	@Test
	public void deleteNotice() {
		noticeService.delete(1);
	}
}
