package cn.gdpu.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import cn.gdpu.service.VoteService;
import cn.gdpu.vo.Vote;
import cn.gdpu.vo.VoteItem;

import com.opensymphony.xwork2.ActionSupport;

public class VoteAction extends ActionSupport implements RequestAware {
	
	private static final long serialVersionUID = 1L ;
	VoteService voteService;
	
	Vote vote;
	VoteItem voteItem;
	String[] content;	
	int time;
	int vid;
	@SuppressWarnings("unchecked")
	Map request;
	
	

	/**
	 * CRUD add 新建投票
	 * @return
	 * @throws Exception
	 */
	
	@SuppressWarnings("unchecked")
	public String doAdd() throws Exception {
		vote.setAirTime(new Date());
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		cal.set(Calendar.DATE,(cal.get(Calendar.DATE)+time));
		vote.setDeadline(cal.getTime());
		HashSet<VoteItem> items = new HashSet<VoteItem>();
		for(int i=0;i<content.length;i++){
			VoteItem voteItem = new VoteItem();
			voteItem.setContent(content[i]);
			items.add(voteItem);
		}
		vote.setItems(items);
		request.put("req", vote);
		voteService.addVote(vote);
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
			request.put("req", vote);
			System.out.println("-------查询投票记录成功--------");
			return SUCCESS;
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
	public String doQueryAll() throws Exception {
		try {
			List<Vote> votes= new ArrayList<Vote>();
			votes= voteService.getAllVotes();
			request.put("req", votes);
			System.out.println("-------查询全部投票记录成功--------");
			return SUCCESS;
		} catch (Exception e) {
			System.out.println("-------查询全部投票记录失败--------");
			e.printStackTrace();
		}
		return ERROR;
	}
	
	@SuppressWarnings("unchecked")
	public String voting() throws Exception {
		voteItem = voteService.getVoteItem(time);
		voteItem.setNum(voteItem.getNum()+1);
		voteService.updateVoteItem(voteItem);
		vote = voteItem.getVote();
		request.put("req", vote);
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
	
	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

}
