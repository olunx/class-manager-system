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
    public abstract void delStudentBySno(int sno);  
  
    /** 
     * 更新学生信息 
     * @param student 
     */  
    public abstract void updateStudent(Student student);  
  
    /** 
     * 根据学号获取学生信息 
     * @param studentId 
     */  
    public abstract Student queryStudentBySno(int sno);  
      
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
  
}  