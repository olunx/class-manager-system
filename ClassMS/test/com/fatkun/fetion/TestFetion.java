package com.fatkun.fetion;

import junit.framework.TestCase;

public class TestFetion extends TestCase {
	
	public void testFetion1(){
		FetionSocket fetionSocket;
		String errMsg = null;
		int errCount = 0;
		fetionSocket = new FetionSocket("号码", "mima");
		try {
			errMsg = "初始化出错";
			fetionSocket.init();
			errMsg = "登陆失败";
			fetionSocket.login();
			// List<ContactGroup> groups = fetionSocket.getContacts();
			// if (groups != null)
			// for (int i = 0; i < groups.size(); i++) {
			// System.out.println(groups.get(i).name);
			// for (int k = 0; k < groups.get(i).Contacts.size(); k++) {
			// System.out.println(groups.get(i).Contacts.get(k));
			// }
			// }
			// fetionSocket.getPersonalInfo();
			//fetionSocket.getContactsInfo("sip:293048753@fetion.com.cn;p=4165");
			errMsg = "发送短信失败";
			fetionSocket.sendMsg("测试发送短信" + new java.util.Date(),"号码");
			fetionSocket.logout();
			fetionSocket.socketClose();
		} catch (Exception e) {
			e.printStackTrace();
			errCount++;
		}
		String result = "";
		if (errCount > 0) {
			result = "发送失败，错误信息：" + errMsg;
		} else {
			result = "飞信发送成功!";
		}
		System.out.println(result);
	}

}
