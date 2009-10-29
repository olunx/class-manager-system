package cn.gdpu.service;

import java.util.ArrayList;
import java.util.Date;
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
                        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-*.xml");
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
                notice.setTitle("Title~~~");
                notice.setTime(new Date());
                noticeService.add(notice);
        }

        @Test
        public void getNotice() {
                Notice notice = noticeService.getNotice(1);
                if (notice != null)
                        System.out.println(notice.getContent());
        }
}