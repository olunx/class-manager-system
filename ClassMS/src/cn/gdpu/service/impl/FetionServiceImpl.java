package cn.gdpu.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fatkun.fetion.FetionSocket;

import cn.gdpu.service.FetionService;

public class FetionServiceImpl implements FetionService {

	public void sendFetion(final String phone, final String pwd, final String tophone, final String content) {

		Thread thread = new Thread() {
			List<String> list = new ArrayList<String>();
			String[] tophones = new String[100];

			@Override
			public void run() {
				try {
					tophones = tophone.split(",");
					for (int i = 0; i < tophones.length; i++) {
						list.add(tophones[i]);
					}

					if (list.size() > 0) {
						System.out.println("tophone" + tophone.length());
						FetionSocket fetionSocket;
						fetionSocket = new FetionSocket(phone, pwd);
						fetionSocket.init();
						fetionSocket.login();
						for (int i = 0; i < list.size(); i++) {
							fetionSocket.sendMsg(content, list.get(i));
						}
						fetionSocket.logout();
						fetionSocket.socketClose();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
	}

}
