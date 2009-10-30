package cn.gdpu.service;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.gdpu.vo.ClassFee;


public class ClassFeeServiceServiceTest {

	private static ClassFeeService classFeeService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-*.xml");
			classFeeService = (ClassFeeService) ctx.getBean("classFeeService");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void insertClassFee(){
		ClassFee classFee = new ClassFee();
		classFee.setCmaker(null);
		classFee.setEvent("收班费");
		classFee.setFee(200);
		classFee.setTime(new Date());
		classFeeService.add(classFee);
	}

	
}
