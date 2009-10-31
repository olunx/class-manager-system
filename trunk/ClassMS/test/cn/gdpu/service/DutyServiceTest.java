package cn.gdpu.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.gdpu.vo.Duty;

public class DutyServiceTest {

	private static DutyService dutyService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			System.out.println("ctx: " + ctx);
			dutyService = (DutyService) ctx.getBean("dutyService");
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void addDuty() {
		Duty duty = new Duty();
		duty.setDutyName("班长");
		dutyService.add(duty);
	}
	
}
