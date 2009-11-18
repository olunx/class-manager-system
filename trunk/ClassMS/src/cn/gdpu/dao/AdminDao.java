package cn.gdpu.dao;

import java.util.List;

import cn.gdpu.vo.Admin;
import cn.gdpu.vo.ClassFee;

public interface AdminDao {
	
	/**
	 * 添加一个管理员
	 * @param admin
	 */
	public abstract void insertAdmin(Admin admin);
	
	/**
	 * 删除一个管理员
	 * @param adminId
	 */
	public abstract void deleteAdminById(int adminId);

	/**
	 * 更新一个管理员
	 * @param admin
	 */
	public abstract void updateAdmin(Admin admin);
	
	
	/**
	 * @param id
	 * @return
	 */
	public abstract Admin queryAdminById(int adminId);
	
	/**
	 * 获取一个管理员
	 * @param adminName
	 * @return
	 */
	public abstract Admin queryAdminByName(String adminName);
	
	/**
	 * 登录时验证
	 * @param username
	 * @param password
	 * @return
	 */
	public abstract Admin queryAdminByUsernameAndPassword(String username, String password);
	
	/**
	 * 获取所有管理员
	 * @return
	 */
	public abstract List<Admin> queryAllAdmins();
	
	/** *//** 
     * 分页查询 
     * @param hql 查询的条件 
     * @param offset 开始记录 
     * @param length 一次查询几条记录 
     * @return 
     */  
	public abstract List<Admin> queryForPage(final String hql,final int offset,final int length);  
 
    /** *//** 
     * 查询所有记录数 
     * @param hql 查询的条件 
     * @return 总记录数 
     */  
    public abstract int getAllRowCount(String hql);  
}
