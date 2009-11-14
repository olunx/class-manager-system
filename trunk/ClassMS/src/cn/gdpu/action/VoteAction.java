package cn.gdpu.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import cn.gdpu.service.VoteService;
import cn.gdpu.vo.Student;
import cn.gdpu.vo.Vote;
import cn.gdpu.vo.VoteItem;

import com.opensymphony.xwork2.ActionSupport;

public class VoteAction extends ActionSupport implements RequestAware,SessionAware{
	
	private static final long serialVersionUID = 1L ;
	private VoteService voteService;
	
	private Vote vote;
	private VoteItem voteItem;
	private String[] content;	
	private int time;
	private int vid;
	private int[] viid;


	@SuppressWarnings("unchecked")
	private Map request;
	@SuppressWarnings("unchecked")
	private Map session;
	

	
	/**
	 * CRUD add 新建投票
	 * @return
	 * @throws Exception
	 */
	
	@SuppressWarnings("unchecked")
	public String doAdd() throws Exception {
		Student author = (Student) session.get("student");
		vote.setAuthor(author);
		vote.setAirTime(new Date());
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		cal.set(Calendar.DATE,(cal.get(Calendar.DATE)+time));
		vote.setDeadline(cal.getTime());
		Set<VoteItem> items = new HashSet<VoteItem>();
		for(int i=0;i<content.length;i++){
			VoteItem voteItem = new VoteItem();
			voteItem.setContent(content[i]);
			items.add(voteItem);
		}
		vote.setItems(items);
		voteService.addVote(vote);
		request.put("req", vote);
		System.out.println("--------新建投票成功-----------");
		return SUCCESS;		
	}
	
	/**
	 * CRUD delete 按ID删除投票记录
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String doDelete() throws Exception {
		try {
			request.put("req", vid);
			voteService.deleteVote(vid);
			System.out.println("-------删除班费记录" + vid + "--------");
			return SUCCESS;
		} catch (Exception e) {
			System.out.println("-------删除班费记录失败--------");
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * 修改页面跳转
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@SkipValidation
	public String modifyLink() throws Exception {
		Vote vote = voteService.getVote(vid);
		request.put("vote", vote);
		return "modifylink";
	}
	
	@SuppressWarnings("unchecked")
	public String doModify() throws Exception {
		Vote vote1 = voteService.getVote(vote.getVid());
		if(vote1 != null){
			try {
				vote1.setTitle(vote.getTitle());
				vote1.setSummary(vote.getSummary());
				vote1.setType(vote.getType());
				vote1.setPicType(vote.getPicType());
				vote1.setAirTime(new Date());
				Calendar cal = Calendar.getInstance();
				Date date = new Date();
				cal.setTime(date);
				cal.set(Calendar.DATE,(cal.get(Calendar.DATE)+time));
				vote1.setDeadline(cal.getTime());
				HashSet<VoteItem> items = new HashSet<VoteItem>();				
				for(int i=0;i<content.length;i++){
					VoteItem voteItem = new VoteItem();
					voteItem.setContent(content[i]);
					items.add(voteItem);
				}
				vote1.setItems(items);
				request.put("req", vote1);
				voteService.updateVote(vote1);
				System.out.println("-----------修改投票成功-----------");
				return SUCCESS;
			} catch (RuntimeException e) {
				System.out.println("-----------修改投票失败-----------");
				e.printStackTrace();
			}
			return ERROR;
		}else {
			System.out.println("-----------修改班费记录失败.找不到ID=" + vote.getVid() + "-----------");
			return ERROR;
		}
	}
	
	/**
	 * CRUD query 按ID查询投票记录
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String doQuery() throws Exception {
		try {
			vote = voteService.getVote(vid);
			request.put("vote", vote);
			System.out.println("-------查询投票记录成功--------");
			return "query";
		} catch (Exception e) {
			System.out.println("-------查询投票记录失败--------");
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * CRUD queryAll 列出全部投票
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String list() throws Exception {
		try {
			List<Vote> votes= new ArrayList<Vote>();
			votes= voteService.getAllVotes();
			if(votes.size() == 0)
				votes = null;
			request.put("votes", votes);
			System.out.println("-------查询全部投票记录成功--------");
			return "list";
		} catch (Exception e) {
			System.out.println("-------查询全部投票记录失败--------");
			e.printStackTrace();
		}
		return ERROR;
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
		Set<Student> voters = vote.getVoters();
		Student voter = (Student) session.get("student");
		for(Student stu : voters ){
			if(stu.getStuId()==voter.getStuId())
				request.put("voterexist", true);
		}
		request.put("vote", vote);
		return "votinglink";
	}
	
	@SuppressWarnings("unchecked")
	public String voting() throws Exception {
		voteItem = voteService.getVoteItem(viid[0]);		
		vote = voteItem.getVote();
		Set<Student> voters = vote.getVoters();
		Student voter = (Student) session.get("student");
		for(Student stu : voters ){
			if(stu.getStuId()==voter.getStuId())
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
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
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
	
	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}
	
	public int[] getViid() {
		return viid;
	}

	public void setViid(int[] viid) {
		this.viid = viid;
	}


}
