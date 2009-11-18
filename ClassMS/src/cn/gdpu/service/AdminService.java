package cn.gdpu.service;

import java.util.List;

import cn.gdpu.bean.PageBean;
import cn.gdpu.vo.Admin;

public interface AdminService {

	/**
	 * 添加一个管理员
	 * 
	 * @param admin
	 */
	public abstract void add(Admin admin);

	/**
	 * 删除一个管理员
	 * 
	 * @param adminId
	 */
	public abstract void deleteById(int adminId);

	/**
	 * 更新一个管理员
	 * 
	 * @param admin
	 */
	public abstract void update(Admin admin);
	

	/**
	 * @param adminId
	 * @return
	 */
	public abstract Admin getAdminById(int adminId);
	
	
	/**
	 * 获取一个管理员
	 * 
	 * @param adminName
	 * @return
	 */
	public abstract Admin getAdminByName(String adminName);

	/**
	 * @param username
	 * @param password
	 * @return
	 */
	public abstract Admin getAdminByUsernameAndPassword(String username, String password);

	/**
	 * 获取所有管理员
	 * 
	 * @return
	 */
	public abstract List<Admin> getAllAdmins();

	/** *//** 
     * 分页查询 
     * @param currentPage 当前第几页 
     * @param pageSize 每页大小 
     * @return 封闭了分页信息(包括记录集list)的Bean 
     */  
    public abstract PageBean queryForPage(int pageSize,int currentPage);  
}
