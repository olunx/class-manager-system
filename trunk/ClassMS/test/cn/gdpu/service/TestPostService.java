package cn.gdpu.service;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.gdpu.vo.Notice;
import cn.gdpu.vo.Post;

public class TestPostService {

	private static PostService postService;
	private static NoticeService noticeService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			postService = (PostService) ctx.getBean("postService");
			noticeService = (NoticeService) ctx.getBean("noticeService");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertNotice() {
		Post post = new Post();
		Notice notice = noticeService.getNotice(1);
		post.setAuthor(null);
		post.setContent("测试评论3");
		post.setParent(notice);
		post.setTime(new Date());
		postService.add(post);
	}
}
