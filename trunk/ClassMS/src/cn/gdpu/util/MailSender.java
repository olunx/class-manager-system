package cn.gdpu.util;

import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class MailSender {
	private static MailSender instance;

	public static MailSender getInstance() {
		if (instance == null) {
			instance = new MailSender();
		}
		return instance;
	}

	public void sendMail(String subject, String msg, List<String> to) throws EmailException {
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");// 邮件服务器
		email.setSSL(Boolean.TRUE); // 设定是否使用SSL
		email.setSslSmtpPort("465"); // 设定SSL端口
		email.setAuthentication("fatkun8@gmail.com", "classmis");// smtp认证的用户名和密码
		email.setFrom("fatkun8@gmail.com", "班务管理系统");// 发信者
		if (to != null && to.size() > 0) {
			for (int i = 0; i < to.size(); i++) {
				email.addTo(to.get(i));
			}
			//email.addTo(to.get(0));// 收信者
			
		}
//		if (to != null && to.size() > 1) {
//			// 从第二个联系人开始把其他联系人加入抄送里
//
//		}
		email.setSubject(subject);// 标题
		email.setCharset("UTF-8");// 编码格式
		email.setMsg(msg);// 内容
		email.send();// 发送
	}
}
