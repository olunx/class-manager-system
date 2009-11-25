package cn.gdpu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import cn.gdpu.dao.StudentDao;
import cn.gdpu.vo.Student;

@Transactional
public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {

	public void insertStudent(Student student) {
		this.getHibernateTemplate().save(student);
	}

	@SuppressWarnings("unchecked")
	public void delStudentBySno(String sno) {
		Student stu = null;
		List list = this.getHibernateTemplate().find("from Student s where s.sno='" + sno + "'");
		if (list != null && list.size() > 0) {
			stu = (Student) list.get(0);
		}
		this.getHibernateTemplate().delete(stu);
	}

	public void delStudentById(int stuId) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().load(Student.class, stuId));
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> queryAllStudents() {
		return this.getHibernateTemplate().find("from Student");
	}

	@SuppressWarnings("unchecked")
	public Student queryStudentBySno(String sno) {
		// return (Student)this.getHibernateTemplate().get(Student.class, sno);
		// return (Student)
		// this.getHibernateTemplate().find("from Student s where s.sno = " +
		// sno).get(0);
		Student stu = null;
		List list = this.getHibernateTemplate().find("from Student s where s.sno='" + sno + "'");
		if (list != null && list.size() > 0) {
			stu = (Student) list.get(0);
		}
		return stu;
	}

	@SuppressWarnings("unchecked")
	public List<Student> queryStudentByName(String name) {
		return this.getHibernateTemplate().find("from Student s where s.realName like '%" + name + "%'");
	}

	public void updateStudent(Student student) {
		this.getHibernateTemplate().update(student);
	}

	@SuppressWarnings("unchecked")
	public Student queryStudentByUsernameAndPassword(String username, String password) {
		Student stu = null;
		List list = this.getHibernateTemplate().find("from Student s where s.username='" + username + "' and s.password='" + password + "'");
		if (list != null && list.size() > 0) {
			stu = (Student) list.get(0);
		}
		return stu;
	}

	public Student queryStudentById(int stuId) {
		return (Student) this.getHibernateTemplate().load(Student.class, stuId);
	}

	  /** *//** 
     * 分页查询 
     * @param hql 查询的条件 
     * @param offset 开始记录 
     * @param length 一次查询几条记录 
     * @return 
     */  
    @SuppressWarnings("unchecked")
	public List<Student> queryForPage(final String hql,final int offset,final int length){  
        List list = getHibernateTemplate().executeFind(new HibernateCallback(){  
            public Object doInHibernate(Session session) throws HibernateException,SQLException{  
                Query query = session.createQuery(hql);  
                query.setFirstResult(offset);  
                query.setMaxResults(length);  
                List list = query.list();  
                return list;  
            }  
        });  
        return list;  
    }  
      
      
    /** *//** 
     * 查询所有记录数 
     * @return 总记录数 
     */  
    public int getAllRowCount(String hql){  
        return getHibernateTemplate().find(hql).size();  
    }  
	
}
