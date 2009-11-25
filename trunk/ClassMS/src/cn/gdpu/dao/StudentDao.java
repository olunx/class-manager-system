package cn.gdpu.dao;

import java.util.List;

import cn.gdpu.vo.Student;

public interface StudentDao {  
	  
    /** 
     * 保存学生信息 
     * @param student 
     */  
    public abstract void insertStudent(Student student);  
  
    /** 
     * 根据学号删除学生信息 
     * @param studentId 
     */  
    public abstract void delStudentBySno(String sno);  
  
    /**根据id删除学生信息 
     * @param stuId
     */
    public abstract void delStudentById(int stuId);  
    
    /** 
     * 更新学生信息 
     * @param student 
     */  
    public abstract void updateStudent(Student student);  
  
    /**
     * 根据id获取学生信息 
     * @param stuId
     * @return
     */
    public abstract Student queryStudentById(int stuId);
    
    /** 
     * 根据学号获取学生信息 
     * @param studentId 
     */  
    public abstract Student queryStudentBySno(String sno); 
    
    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    public abstract Student queryStudentByUsernameAndPassword(String username,String password);  
      
    /** 
     * 根据姓名获取学生信息 
     * @param studentId 
     */  
    public abstract List<Student> queryStudentByName(String name);  
      
    /** 
     * 获取全部学生信息 
     * @param studentId 
     */  
    public abstract List<Student> queryAllStudents();  
    
    /** 
     * 分页获取全部学生信息 
     * @param studentId 
     */  
    public abstract List<Student> queryForPage(final String hql,final int offset,final int length);  
    
    /** *//** 
     * 查询所有记录数 
     * @param hql 查询的条件 
     * @return 总记录数 
     */  
    public abstract int getAllRowCount(String hql);  
  
}  
