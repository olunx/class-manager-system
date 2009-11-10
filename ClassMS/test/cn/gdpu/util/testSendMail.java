package cn.gdpu.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.EmailException;

import junit.framework.TestCase;

public class testSendMail extends TestCase {
	
	public void testSendOneMail() {
		try {
			List<String> list = new ArrayList<String>();
			list.add("fatkun8@gmail.com");
			list.add("cyk.cn@qq.com");
			list.add("olunx@qq.com");
			list.add("fuchal@qq.com");
			
			MailSender.getInstance().sendMail("测试标题"+new Date(),	"这是一封测试邮件", list);
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
