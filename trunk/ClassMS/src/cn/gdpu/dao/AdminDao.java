package cn.gdpu.dao;

import java.util.List;

import cn.gdpu.vo.Admin;

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
}
