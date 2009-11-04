package cn.gdpu.service;

import java.util.Date;
import java.util.HashSet;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.gdpu.vo.Attendance;
import cn.gdpu.vo.Student;


public class AttendanceServiceTest {

	private static AttendanceService attendanceService;
	private static StudentService studentService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			System.out.println("ctx: " + ctx);
			attendanceService = (AttendanceService) ctx.getBean("attendanceService");
			studentService = (StudentService) ctx.getBean("studentService");
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void addAttendance() {
		Attendance attendance = new Attendance();
		attendance.setWeek("1");
		attendance.setDay("1");
		attendance.setLesson("1,2,3,4");
		attendance.setTime(new Date());
		HashSet<Student> students = new HashSet<Student>();
//		List<Student> stus = studentService.getStudents();
//		for(int i=0;i<stus.size();i++) {
//			students.add(stus.get(i));
//		}
		;
		System.out.println(studentService.getStudentsByName("陈伦瑶").get(0));
		students.add(studentService.getStudentsByName("陈伦瑶").get(0));
		attendance.setStudents(students);
		attendanceService.add(attendance);
	}
	
}
