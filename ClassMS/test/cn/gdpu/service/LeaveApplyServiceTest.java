package cn.gdpu.service;

import java.util.Date;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.gdpu.vo.ActivityApply;
import cn.gdpu.vo.LeaveApply;

public class LeaveApplyServiceTest {

	private static LeaveApplyService leaveApplyService;
	private static StudentService studentService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			leaveApplyService = (LeaveApplyService) ctx.getBean("leaveApplyService");
			studentService = (StudentService) ctx.getBean("studentService");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void addLeaveApply() {
		LeaveApply leaveApply = new LeaveApply();
		leaveApply.setStudent(studentService.getStudentBySno("0707501145"));
		leaveApply.setContent("sdfsdfsdfsdfsf");
		leaveApply.setPass(0);
		leaveApply.setTime(new Date());
		leaveApplyService.addLeaveApply(leaveApply);
	}
	
	@Test
	public void delLeaveApply() {
		leaveApplyService.delLeaveApplyByID(3);
	}
	
	@Test
	public void getLeaveApply() {
		LeaveApply leaveApply = leaveApplyService.getLeaveApply(1);
		System.out.print(leaveApply);
	}
	
	@Test
	public void getLeaveApplys() {
		Set<LeaveApply> set = leaveApplyService.getLeaveApplysByStuID(108);
		System.out.print(set);
	}
}
