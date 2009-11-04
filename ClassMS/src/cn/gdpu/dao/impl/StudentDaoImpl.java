package cn.gdpu.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import cn.gdpu.dao.StudentDao;
import cn.gdpu.vo.Student;

@Transactional
public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {

	public void insertStudent(Student student) {
		this.getHibernateTemplate().save(student);
	}

	public void delStudentBySno(String sno) {
		this.getHibernateTemplate().delete((Student) this.getHibernateTemplate().find("from Student s where s.realName like '%" + sno + "%'").get(0));
	}

	@SuppressWarnings("unchecked")
	public List<Student> queryAllStudents() {
		return this.getHibernateTemplate().find("from Student");
	}

	public Student queryStudentBySno(String sno) {
		// return (Student)this.getHibernateTemplate().get(Student.class, sno);
		// return (Student)
		// this.getHibernateTemplate().find("from Student s where s.sno = " +
		// sno).get(0);
		return (Student) this.getHibernateTemplate().find("from Student s where s.realName like '%" + sno + "%'").get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Student> queryStudentByName(String name) {
		return this.getHibernateTemplate().find("from Student s where s.realName like '%" + name + "%'");
	}

	public void updateStudent(Student student) {
		this.getHibernateTemplate().update(student);
	}
}
