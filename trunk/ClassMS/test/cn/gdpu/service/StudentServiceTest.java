package cn.gdpu.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.gdpu.vo.Student;

public class StudentServiceTest{

	private static StudentService studentService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			System.out.println("ctx: " + ctx);
			studentService = (StudentService) ctx.getBean("studentService");
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void queryAllStudents() {
		for (Student student : studentService.getStudents()) {
			System.out.println(student.getRealName());
		}
	}

	@Test
	public void queryStudentBySno() {
		Student stu = studentService.getStudent("");
		System.out.println(stu);
	}

	@Test
	public void deleteStudentBySno() {
		System.out.println("--------------删除前所有学生信息：");
		queryAllStudents();
		studentService.delete("");
		System.out.println("--------------删除后所有学生信息：");
		queryAllStudents();
	}

	@Test
	public void addStudent() {
		/*
		 * for(int i=0;i<10;i++){ Student stu = new Student();
		 * stu.setStuName("欢迎访问长弓博客"+i); }
		 */

		Student stu = new Student();
		stu.setRealName("添加学生后所");
		stu.setQq(12345678);
		studentService.add(stu);
		System.out.println("添加学生后所有学生信息：");
		queryAllStudents();
	}

	@Test
	public void updateStudent() {
		Student stu = studentService.getStudent("");
		System.out.println("更新前学生姓名：" + stu.getRealName());
		stu.setRealName("我是长弓");
		studentService.update(stu);
		stu = studentService.getStudent("");
		System.out.println("更新后学生姓名：" + stu.getRealName());
	}

	@Test
	public void queryStudentByName() {
		for (Student student : studentService.getStudentsByName("长弓博客")) {
			System.out.println(student);
		}
	}
}
