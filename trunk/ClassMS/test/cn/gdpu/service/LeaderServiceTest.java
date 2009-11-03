package cn.gdpu.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.gdpu.vo.Leader;

public class LeaderServiceTest {

	private static LeaderService leaderService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			System.out.println("ctx: " + ctx);
			leaderService = (LeaderService) ctx.getBean("leaderService");
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void addDuty() {
		Leader leader = new Leader();
		leader.setLeaderName("辅导员");
		leader.setUsername("001100");
		leaderService.add(leader);
	}
	
}
