package cn.gdpu.service.impl;

import java.util.List;

import cn.gdpu.bean.PageBean;
import cn.gdpu.dao.AdminDao;
import cn.gdpu.service.AdminService;
import cn.gdpu.vo.Admin;

public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao;

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public void add(Admin admin) {
		adminDao.insertAdmin(admin);
	}

	public void deleteById(int adminId) {
		adminDao.deleteAdminById(adminId);
	}

	public List<Admin> getAllAdmins() {
		return adminDao.queryAllAdmins();
	}

	public Admin getAdminByName(String adminName) {
		return adminDao.queryAdminByName(adminName);
	}

	public void update(Admin admin) {
		adminDao.updateAdmin(admin);
	}

	public Admin getAdminByUsernameAndPassword(String username, String password) {
		return adminDao.queryAdminByUsernameAndPassword(username, password);
	}

	public Admin getAdminById(int adminId) {
		return adminDao.queryAdminById(adminId);
	}

	/** *//** 
     * 分页查询 
     * @param currentPage 当前第几页 
     * @param pageSize 每页大小 
     * @return 封闭了分页信息(包括记录集list)的Bean 
     */  
    public PageBean queryForPage(int pageSize,int page){  
  
        final String hql = "from Admin";        //查询语句  
        int allRow = adminDao.getAllRowCount(hql);    //总记录数  
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //总页数  
        final int offset = PageBean.countOffset(pageSize, page);    //当前页开始记录  
        final int length = pageSize;    //每页记录数  
        final int currentPage = PageBean.countCurrentPage(page);  
        List<Admin> list = adminDao.queryForPage(hql,offset, length);        //"一页"的记录  
          
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
