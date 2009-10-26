/*
 *@author fatkun , Time:2009-3-17
 *
 *Website : http://www.olunx.com
 *
 *This: 发送飞信
 */

package com.fatkun.fetion;

public class Fetion {
	FetionSocket fetionSocket;
	String errMsg;
	int errCount = 0;

	public void runFetion() {
		fetionSocket = new FetionSocket("号码", "密码");
		try {
			// init();
			errMsg = "初始化出错";
			fetionSocket.login();
			errMsg = "登陆失败";
			fetionSocket.getContacts();
			//fetionSocket.getPersonalInfo();
			//fetionSocket.getContactsInfo("sip:293048753@fetion.com.cn;p=4165");
			//fetionSocket.sendMsg("测试发送短信" + new java.util.Date());
			errMsg = "发送短信失败";
			fetionSocket.logout();
			fetionSocket.socketClose();
		} catch (Exception e) {
			e.printStackTrace();
			errCount++;
		}
		String result = "";
		if (errCount > 0) {
			result = "发送失败，请检查密码是否正确。错误信息：" + errMsg;
		} else {
			result = "飞信发送成功!";
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		new Fetion().runFetion();
	}

}
