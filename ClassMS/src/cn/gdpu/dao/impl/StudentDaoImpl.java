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
  
    public void delStudentBySno(int sno) {  
    	this.getHibernateTemplate().delete(this.getHibernateTemplate().load(Student.class, sno));  
    }  
    
    @SuppressWarnings("unchecked")
	public List<Student> queryAllStudents() {  
        return this.getHibernateTemplate().find("from Student");  
    }  
  
    public Student queryStudentBySno(int sno) {  
        return (Student)this.getHibernateTemplate().get(Student.class, sno);  
    }  
  
    @SuppressWarnings("unchecked")
	public List<Student> queryStudentByName(String name) {  
        return this.getHibernateTemplate().find("from Student s where s.realName like '%"+name+"%'");  
    }  
  
    public void updateStudent(Student student) {  
    	this.getHibernateTemplate().update(student);  
    }  
}  
