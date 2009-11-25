package cn.gdpu.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import cn.gdpu.bean.PageBean;
import cn.gdpu.dao.StudentDao;
import cn.gdpu.service.StudentService;
import cn.gdpu.vo.Student;

public class StudentServiceImpl implements StudentService {
	@Resource
	private StudentDao studentDao;

	public void add(Student student) {
		studentDao.insertStudent(student);
	}

	public void deleteBySno(String sno) {
		studentDao.delStudentBySno(sno);
	}

	public void deleteById(int stuId) {
		studentDao.delStudentById(stuId);
	}
	
	public void update(Student student) {
		studentDao.updateStudent(student);
	}

	public Student getStudentBySno(String sno) {
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
		return studentDao.queryStudentByName(name);
	}

	public Student getStudentByUsernameAndPassword(String username, String password) {
		return studentDao.queryStudentByUsernameAndPassword(username, password);
	}

	public Set<Student> getStudentsBySnoString(String snos) {

		String[] stuSnos = snos.split("\\,");

		Set<Student> stus = new HashSet<Student>();
		
		for(int i=0;i<stuSnos.length;i++) {
			stus.add(studentDao.queryStudentBySno(stuSnos[i]));
		}
		
		return stus;
	}

	public Student getStudentById(int stuId) {
		return studentDao.queryStudentById(stuId);
	}

	/** *//** 
     * 分页查询 
     * @param currentPage 当前第几页 
     * @param pageSize 每页大小 
     * @return 封闭了分页信息(包括记录集list)的Bean 
     */  
    public PageBean queryForPage(int pageSize,int page){  
  
        final String hql = "from Student";        //查询语句  
        int allRow = studentDao.getAllRowCount(hql);    //总记录数  
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //总页数  
        final int offset = PageBean.countOffset(pageSize, page);    //当前页开始记录  
        final int length = pageSize;    //每页记录数  
        final int currentPage = PageBean.countCurrentPage(page);  
        List<Student> list = studentDao.queryForPage(hql,offset, length);        //"一页"的记录  
          
        //把分页信息保存到Bean中  
        PageBean pageBean = new PageBean();  
        pageBean.setPageSize(pageSize);      
        pageBean.setCurrentPage(currentPage);  
        pageBean.setAllRow(allRow);  
        pageBean.setTotalPage(totalPage);  
        pageBean.setList(list);  
        pageBean.init();  
        return pageBean;  
    }  

	
}