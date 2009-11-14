package cn.gdpu.service;

import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.gdpu.vo.ActivityApply;

public class TestActivityApplyService {

	private static ActivityApplyService activityApplyService;
	private static StudentService studentService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			activityApplyService = (ActivityApplyService) ctx.getBean("activityApplyService");
			studentService = (StudentService) ctx.getBean("studentService");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void addActivityApply() {
		ActivityApply activityApply = new ActivityApply();
		activityApply.setStudent(studentService.getStudentBySno(""));
		activityApply.setMark(0.2);
		activityApply.setReason("加分原因OxxxOXX");
		activityApply.setPass(0);
		activityApplyService.addActivityApply(activityApply);
	}
	
	@Test
	public void delActivityApply() {
		activityApplyService.delActivityApplyByID(1);
	}
	
	@Test
	public void getActivityApply() {
		ActivityApply activityApply = activityApplyService.getActivityApply(2);
		System.out.print(activityApply);
	}
	
	@Test
	public void getActivityApplys() {
		Set<ActivityApply> set = activityApplyService.getActivityApplysByStuID(1);
		System.out.print(set);
	}
}
