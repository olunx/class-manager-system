package cn.gdpu.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import cn.gdpu.bean.PageBean;
import cn.gdpu.service.AdminService;
import cn.gdpu.vo.Admin;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport implements RequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int adminId = -1;
	private String username;
	private String password;
	private String realName;
	private String avatar;
	private String remark;

	private int[] adminIds;
	private AdminService adminService;

	private Map<String, Object> request;
	
	private PageBean pageBean; //分页
	private int page;

	// 添加管理员
	public String add() {

		Admin a = new Admin();
		a.setUsername(username);
		a.setPassword(password);
		a.setRealName(realName);
		a.setAvatar(avatar);
		a.setRemark(remark);
		adminService.add(a);
		
		return "index";
	}

	// 获取管理员
	@SkipValidation
	public String get() {
		if (adminId < 0) {
			return "input";
		}
		
		Admin a = adminService.getAdminById(adminId);

		request.put("admin", a);

		return "updateLink";
	}

	// 修改管理员
	public String update() {
		
		Admin a = adminService.getAdminById(adminId);
		a.setUsername(username);
		a.setPassword(password);
		a.setRealName(realName);
		a.setAvatar(avatar);
		a.setRemark(remark);
		adminService.update(a);
		
		return "index";
	}

	// 删除管理员信息
	@SkipValidation
	public String delete() {
		adminService.deleteById(adminId);
		return "index";
	}

	//批量删除
	@SkipValidation
	public String deleteMany() {
		for(int i=0; i<adminIds.length; i++) {
			adminService.deleteById(adminIds[i]);
		}
		return "index";
	}
	
	/*// 列出管理员信息
	public String list() {
		List<Admin> list = adminService.getAllAdmins();
		if (list != null && list.size() > 0) {
			request.put("admins", list);
		}
		return "input";
	}*/

	/**
	 * 分页列出所有管理员信息
	 * @return
	 */
	@SkipValidation
	public String list() throws Exception {  
        //分页的pageBean,参数pageSize表示每页显示记录数,page为当前页  
        this.pageBean = adminService.queryForPage(15, page);  
        if(pageBean.getList().isEmpty())
    		pageBean.setList(null);
        return "input";  
    }  
	
	// 跳转到添加页
	@SkipValidation
	public String addLink() {
		return "addLink";
	}

	//生成get/set
	
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int[] getAdminIds() {
		return adminIds;
	}

	public void setAdminIds(int[] adminIds) {
		this.adminIds = adminIds;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
}
