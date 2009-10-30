package cn.gdpu.vo;

import java.util.Date;

public class ClassFee {
	private String fid;              //费用ID
	private Student cmaker;       //经手人
	private int fee;			  //费用
	private String event;		  //执行事件
	private Date time;			  //事件执行时间
	private String remarks;		  //班费备注

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public Student getCmaker() {
		return cmaker;
	}

	public void setCmaker(Student cmaker) {
		this.cmaker = cmaker;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
