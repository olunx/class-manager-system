package cn.gdpu.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import cn.gdpu.bean.VoteItemComparator;
import cn.gdpu.bean.PageBean;
import cn.gdpu.service.VoteService;
import cn.gdpu.vo.Student;
import cn.gdpu.vo.Vote;
import cn.gdpu.vo.VoteItem;

import com.opensymphony.xwork2.ActionSupport;

public class VoteAction extends ActionSupport implements RequestAware,SessionAware{
	
	private static final long serialVersionUID = 1L ;
	private VoteService voteService;
	
	private PageBean pageBean;    //包含分布信息的bean  
	
	private Vote vote;
	private VoteItem voteItem;
	private String[] content;	
	private String time;
	private int vid;
	private int[] vids;
	private int[] viid;
	private int cmd;
	private int page;    //第几页  

	@SuppressWarnings("unchecked")
	private Map request;
	@SuppressWarnings("unchecked")
	private Map session;
	

	
	/**
	 * 新建投票
	 * @return
	 * @throws Exception
	 */
	
	@SuppressWarnings("unchecked")
	public String add() throws Exception {
		Student author = (Student) session.get("student");
		vote.setAuthor(author);
		vote.setAirTime(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = sdf.parse(time);
		vote.setDeadline(date);
		VoteItemComparator<VoteItem> voteItemComparator = new VoteItemComparator<VoteItem>();
		Set<VoteItem> items = new TreeSet<VoteItem>(voteItemComparator);
		for(int i=0;i<content.length;i++){
			if(content[i] == null || content[i].trim().equals(""))
				continue;
			boolean exit = false;
			for(int j=0 ;j<i ; j++){
				if(content[j].equals(content[i])){
					exit = true;
					break;
				}					
			}
			if(exit)
				continue;
			VoteItem voteItem = new VoteItem();
			voteItem.setContent(content[i]);
			items.add(voteItem);
		}
		if(items.isEmpty()){
			this.addFieldError("content", "投票选项不能全为空");
		}
		if(hasFieldErrors())
			return INPUT;
		vote.setItems(items);
		voteService.addVote(vote);
		request.put("vote", vote);
		return "relist";		
	}
	
	/**
	 * 按ID删除投票记录
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String delete() throws Exception {	
		voteService.deleteVote(vid);
		return "relist";
	
	}
	/**
	 * 删除多个投票记录
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String deleteMany() {
		if(cmd == 1){
			for(int i=0;i<vids.length;i++) {
				voteService.deleteVote(vids[i]);
			}
			
		}
		return "relist";
	
	}
	
	/**
	 * 修改页面跳转,暂未使用
	 * 
	 * @return
	 * @throws Exception
	 */
	/*
	@SuppressWarnings("unchecked")
	@SkipValidation
	public String modifyLink() throws Exception {
		Vote vote = voteService.getVote(vid);
		request.put("vote", vote);
		return "modifylink";
	}*/
	
	/**
	 * 修改投票,暂未使用
	 * 
	 * @return
	 * @throws Exception
	 */
	/*@SuppressWarnings("unchecked")
	@SkipValidation
	public String modify() throws Exception {
		Vote vote1 = voteService.getVote(vote.getVid());
		if(vote1 != null){			
			vote1.setTitle(vote.getTitle());
			vote1.setSummary(vote.getSummary());
			vote1.setType(vote.getType());
			vote1.setPicType(vote.getPicType());
			vote1.setAirTime(new Date());
			Calendar cal = Calendar.getInstance();
			Date date = new Date();
			cal.setTime(date);
			cal.set(Calendar.DATE,(cal.get(Calendar.DATE)));
			vote1.setDeadline(cal.getTime());
			Set<VoteItem> items = new TreeSet<VoteItem>();				
			for(int i=0;i<content.length;i++){
				VoteItem voteItem = new VoteItem();
				voteItem.setContent(content[i]);
				items.add(voteItem);
			}
			vote1.setItems(items);
			request.put("vote", vote1);
			voteService.updateVote(vote1);
			return SUCCESS;			
		}else {
			return ERROR;
		}
	}*/
	
	/**
	 * 按ID查询投票记录
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@SkipValidation
	public String query() throws Exception {
			vote = voteService.getVote(vid);
			request.put("vote", vote);
			return "query";
	}
	
	/*
	@SuppressWarnings("unchecked")
	@SkipValidation
	public String list() throws Exception {
		List<Vote> votes = voteService.getAllVotes();
		if(votes.size() == 0)
			votes = null;
		request.put("votes", votes);
		return SUCCESS;		
	}
	*/
	
	/**
	 * 分页列出全部投票
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String list() throws Exception {  
	        //分页的pageBean,参数pageSize表示每页显示记录数,page为当前页  
	    this.pageBean = voteService.queryForPage(15, page); 
	    if(pageBean.getList().size() == 0)
	    	pageBean.setList(null);
	    return "list";  
	}  
	
	/**
	 * 投票页面跳转
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@SkipValidation
	public String votingLink() throws Exception {
		Vote vote = voteService.getVote(vid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String str1 = sdf.format(new Date());
        Date toDay = sdf.parse(str1);
		if(toDay.after(vote.getDeadline()))     //如果投票过期 ，返回timeout
			request.put("timeout", true);
		Set<Student> voters = vote.getVoters();
		Student voter = (Student) session.get("student");
		if(voter == null){
			request.put("vote", vote);
			return "query";
		}
		for(Student stu : voters ){
			if(stu.getStuId()==voter.getStuId())					//如果投票人已经投票，返回voterexist
				request.put("voterexist", true);
		}
		request.put("vote", vote);
		return SUCCESS;
	}
	
	/**
	 * 用户投票
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@SkipValidation
	public String voting() throws Exception {
		vote =	voteService.getVote(vid);
		if(viid == null)										//验证投票先是否为空
			this.addFieldError("viid", "投票选项不能为空");
		if(hasFieldErrors()){
			request.put("vote", vote);
			return INPUT;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String str1 = sdf.format(new Date());
        Date toDay = sdf.parse(str1);
		if(toDay.after(vote.getDeadline()))     //如果投票过期 ，返回timeout
			return "timeout";
		Set<Student> voters = vote.getVoters();
		Student voter = (Student) session.get("student");
		if(voter == null)
			return "list";
		for(Student stu : voters ){
			if(stu.getStuId()==voter.getStuId())			//如果投票人已经投票，返回voterexist
				return "voterexist";
		}
		if (!voters.add(voter))
			return "voterexist";
		vote.setVoters(voters);
		for(int i=0;i<viid.length;i++){
			voteItem = voteService.getVoteItem(viid[i]);
			voteItem.setNum(voteItem.getNum()+1);
		}		
		voteService.updateVote(vote);
		request.put("vote", vote);
		return SUCCESS;
	}
	
	//Getter and Setter

	public Vote getVote() {
		return vote;
	}
	public void setVote(Vote vote) {
		this.vote = vote;
	}
	public VoteService getVoteService() {
		return voteService;
	}
	public void setVoteService(VoteService voteService) {
		this.voteService = voteService;
	}
	
	public VoteItem getVoteItem() {
		return voteItem;
	}
	public void setVoteItem(VoteItem voteItem) {
		this.voteItem = voteItem;
	}
	
	public String[] getContent() {
		return content;
	}
	
	public void setContent(String[] content) {
		this.content = content;
	}

	@SuppressWarnings("unchecked")
	public Map getRequest() {
		return request;
	}

	@SuppressWarnings("unchecked")
	public void setRequest(Map request) {
		this.request = request;
	}
	
	@SuppressWarnings("unchecked")
	public Map getSession() {
		return session;
	}

	@SuppressWarnings("unchecked")
	public void setSession(Map session) {
		this.session = session;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}
	
	public int[] getVids() {
		return vids;
	}

	public void setVids(int[] vids) {
		this.vids = vids;
	}
	
	public int[] getViid() {
		return viid;
	}

	public void setViid(int[] viid) {
		this.viid = viid;
	}

	public int getCmd() {
		return cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
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
