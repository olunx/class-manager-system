package cn.gdpu.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import cn.gdpu.bean.PageBean;
import cn.gdpu.service.LeaderService;
import cn.gdpu.vo.Leader;

import com.opensymphony.xwork2.ActionSupport;

public class LeaderAction extends ActionSupport implements RequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int leaderId = -1;
	private String username;
	private String password;
	private String realName;
	private String avatar;
	private String remark;

	private int[] leaderIds;
	private LeaderService leaderService;

	private Map<String, Object> request;
	
	private PageBean pageBean; //分页
	private int page;


	// 添加管理员
	public String add() {

		Leader l = new Leader();
		l.setUsername(username);
		l.setPassword(password);
		l.setRealName(realName);
		l.setAvatar(avatar);
		l.setRemark(remark);
		leaderService.add(l);
		
		return "index";
	}

	// 获取管理员
	public String get() {
		if (leaderId < 0) {
			return "input";
		}
		
		Leader l = leaderService.getLeaderById(leaderId);

		request.put("leader", l);

		return "updateLink";
	}

	// 修改管理员
	public String update() {
		
		Leader l = leaderService.getLeaderById(leaderId);
		l.setUsername(username);
		l.setPassword(password);
		l.setRealName(realName);
		l.setAvatar(avatar);
		l.setRemark(remark);
		leaderService.update(l);
		
		return "index";
	}

	// 删除管理员信息
	public String delete() {
		leaderService.deleteById(leaderId);
		return "index";
	}

	//批量删除
	public String deleteMany() {
		for(int i=0; i<leaderIds.length; i++) {
			leaderService.deleteById(leaderIds[i]);
		}
		return "index";
	}
	
	/*// 列出管理员信息
	public String list() {
		List<Leader> list = leaderService.getAllLeaders();
		if (list != null && list.size() > 0) {
			request.put("leaders", list);
		}
		return "input";
	}*/
	
	/**
	 * 分页列出所有班费
	 * @return
	 */
	@SkipValidation
	public String list() throws Exception {  
        //分页的pageBean,参数pageSize表示每页显示记录数,page为当前页  
        this.pageBean = leaderService.queryForPage(15, page);  
        if(pageBean.getList().isEmpty())
    		pageBean.setList(null);
        return "input";  
    }  

	// 跳转到添加页
	public String addLink() {
		return "addLink";
	}

	//生成get/set
	
	public int getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(int leaderId) {
		this.leaderId = leaderId;
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

	public int[] getLeaderIds() {
		return leaderIds;
	}

	public void setLeaderIds(int[] leaderIds) {
		this.leaderIds = leaderIds;
	}

	public LeaderService getLeaderService() {
		return leaderService;
	}

	public void setLeaderService(LeaderService leaderService) {
		this.leaderService = leaderService;
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
