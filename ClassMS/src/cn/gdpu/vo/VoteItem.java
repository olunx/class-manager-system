package cn.gdpu.vo;

public class VoteItem {
	private int viid;				//投票选项ID
	private int num;			//投票选项.当前标数
	private String content;		//投票选项.内容
	private Vote vote;			//所属投票
	
	
	public int getViid() {
		return viid;
	}
	public void setViid(int viid) {
		this.viid = viid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		 this.num = num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Vote getVote() {
		return vote;
	}
	public void setVote(Vote vote) {
		this.vote = vote;
	}
	
	
	
	
}
