package cn.gdpu.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import cn.gdpu.dao.StudentDao;
import cn.gdpu.vo.Student;

@Transactional  
public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {  
  
    public void insertStudent(Student student) {  
        // TODO Auto-generated method stub  
    	this.getHibernateTemplate().save(student);  
    }  
  
    public void delStudentBySno(int sno) {  
    	this.getHibernateTemplate().delete(this.getHibernateTemplate().load(Student.class, sno));  
    }  
    @SuppressWarnings("unchecked")
	public List<Student> queryAllStudents() {  
		// TODO Auto-generated method stub
        List<Student> stuList = null;  
		stuList = this.getHibernateTemplate().find("from Student");  
        return stuList;  
    }  
  
    public Student queryStudentBySno(int sno) {  
        Student student=null;  
        student = (Student)this.getHibernateTemplate().get(Student.class, sno);  
        return student;  
    }  
  
    @SuppressWarnings("unchecked")
	public List<Student> queryStudentByName(String name) {  
        // TODO Auto-generated method stub  
        List<Student> stuList = null;  
        stuList = this.getHibernateTemplate().find("from Student s where s.realName like '%"+name+"%'");
        return stuList;  
    }  
  
    public void updateStudentBySno(Student student) {  
        // TODO Auto-generated method stub  
    	this.getHibernateTemplate().update(student);  
    }  
}  
