package cn.gdpu.vo;

import java.util.Date;

public class ClassFee {
	private Student cmaker;
	private int fee;
	private String event;
	private Date time;

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


}
