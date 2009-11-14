package cn.gdpu.service.impl;

import java.util.List;

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

}
