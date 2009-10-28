package cn.gdpu.dao;

import java.util.List;

import cn.gdpu.vo.Student;

public interface StudentDao {  
	  
    /** 
     * 保存学生信息 
     * @param student 
     */  
    public void insertStudent(Student student);  
  
    /** 
     * 根据学号删除学生信息 
     * @param studentId 
     */  
    public void delStudentBySno(int sno);  
  
    /** 
     * 更新学生信息 
     * @param student 
     */  
    public void updateStudentBySno(Student student);  
  
    /** 
     * 根据学号获取学生信息 
     * @param studentId 
     */  
    public Student queryStudentBySno(int sno);  
      
    /** 
     * 根据姓名获取学生信息 
     * @param studentId 
     */  
    public List<Student> queryStudentByName(String name);  
      
    /** 
     * 获取全部学生信息 
     * @param studentId 
     */  
    public List<Student> queryAllStudents();  
  
}  
