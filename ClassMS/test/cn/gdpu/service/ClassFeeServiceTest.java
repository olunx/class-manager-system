package cn.gdpu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.gdpu.vo.ClassFee;
import cn.gdpu.vo.Student;


public class ClassFeeServiceTest {

	private static ClassFeeService classFeeService;
	private static StudentService studentService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			classFeeService = (ClassFeeService) ctx.getBean("classFeeService");
			studentService = (StudentService) ctx.getBean("studentService");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	
	//测试添加班费开支
	@Test
	public void insertClassFee(){
		Student cmaker = studentService.getStudentBySno("");
		ClassFee classFee = new ClassFee();
		classFee.setCmaker(cmaker);
		classFee.setEvent("收班费");
		classFee.setFee(200);		
		classFee.setTime(new Date());
		classFeeService.add(classFee);
		System.out.println("-----insertClassFee-----");
	}
	
	//测试查询所有班费开支
	@Test
	public void queryAllClassFees(){
		List<ClassFee> classFees = new ArrayList<ClassFee>();
		classFees = classFeeService.getAllClassFees();
		if(classFees != null)
			for(ClassFee classFee : classFees){
				System.out.println("班费串号：" + classFee.getFid() + "，事件：" + classFee.getEvent() + "，班费：" + classFee.getFee() + "，经手人：" + classFee.getCmaker() + "，时间：" + classFee.getTime());
			}
	}
	
	//测试按ID查询班费
	@Test 
	public void queryClassFeeByID(){
		String fid = "402881e624a372b60124a372ba1e0001";
		ClassFee classFee = new ClassFee();
		classFee = classFeeService.getClassFee(fid);
		System.out.println("班费串号：" + classFee.getFid() + "，事件：" + classFee.getEvent() + "，班费：" + classFee.getFee() + "，经手人：" + classFee.getCmaker() + "，时间：" + classFee.getTime());
	}
	
	//测试按ID删除班费记录
	@Test
	public void deleteClassFeeByID(){
		String fid = "402881e624a372b60124a372ba1e0001";
		try {
			classFeeService.delete(fid);
			System.out.println("------成功删除班费记录-------");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	//测试修改班费记录
	@Test
	public void updataClassFee(){
		ClassFee classFee = new ClassFee();
		classFee.setFid("402881e624a388340124a38837b40001");
		classFee.setEvent("买水");
		classFee.setFee(50);
		classFee.setCmaker(null);
		classFee.setTime(new Date());
		try {
			classFeeService.update(classFee);
			System.out.println("-------------修改成功----------------");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
}
