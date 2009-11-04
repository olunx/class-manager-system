package cn.gdpu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import cn.gdpu.dao.StudentDao;
import cn.gdpu.service.StudentService;
import cn.gdpu.vo.Student;

public class StudentServiceImpl implements StudentService {
	@Resource
	private StudentDao studentDao;

	public void add(Student student) {
		studentDao.insertStudent(student);
	}

	public void delete(String sno) {
		studentDao.delStudentBySno(sno);
	}

	public void update(Student student) {
		studentDao.updateStudent(student);
	}

	public Student getStudent(String sno) {
		return studentDao.queryStudentBySno(sno);
	}

	public List<Student> getStudents() {
		return studentDao.queryAllStudents();
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public List<Student> getStudentsByName(String name) {
		// TODO Auto-generated method stub
		return studentDao.queryStudentByName(name);
	}


}