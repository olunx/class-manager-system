package cn.gdpu.action;

import cn.gdpu.service.AdminService;
import cn.gdpu.vo.Admin;

import com.opensymphony.xwork2.ActionSupport;

public class InstallAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private AdminService adminService;

	@Override
	public String execute() throws Exception {
		Admin admin = new Admin();
		admin.setUsername("admin");
		admin.setPassword("admin");
		admin.setRealName("测试管理员");
		adminService.add(admin);
		return SUCCESS;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
}
