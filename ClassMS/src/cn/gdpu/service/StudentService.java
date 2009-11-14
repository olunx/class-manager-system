package cn.gdpu.service;

import java.util.List;
import java.util.Set;

import cn.gdpu.vo.Student;

/**
 * @author olunx
 *
 */
public interface StudentService {  
	  
    /** 
     * 保存学生信息 
     * @param student 
     */  
    public abstract void add(Student student);  
  
    /** 
     * 根据学号删除学生信息 
     * @param studentId 
     */  
    public abstract void deleteBySno(String sno);  
  
    public abstract void deleteById(int stuId);  
    
    /** 
     * 更新学生信息 
     * @param student 
     */  
    public abstract void update(Student student);  
  
    /**
     * 根据id获取学生信息 
     * @param stuId
     * @return
     */
    public abstract Student getStudentById(int stuId);  
    
    /** 
     * 根据学号获取学生信息 
     * @param studentId 
     */  
    public abstract Student getStudentBySno(String sno);  
    
    public abstract Student getStudentByUsernameAndPassword(String username,String password);  
  
    /** 
     * 获取全部学生信息 
     * @param studentId 
     */  
    public abstract List<Student> getStudents();  
      
    /** 
     * 通过学生姓名获取学生信息 
     * @param studentId 
     */  
    public abstract List<Student> getStudentsByName(String name);  
    
    /**
     * 通过学号字符串获得学生信息，分隔符半角逗号。
     * @param snos
     * @return
     */
    public abstract Set<Student> getStudentsBySnoString(String snos);
  
}  
