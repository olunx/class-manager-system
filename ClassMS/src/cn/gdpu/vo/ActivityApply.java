package cn.gdpu.vo;

public class ActivityApply {
	private int aid;
	private Student student;
	private double mark;
	private String reason;
	public int pass;//0：默认值(未审核),1:通过,2不通过
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(String str) {
		this.mark = Double.parseDouble(str.trim());
	}
	public void setMark(double d) {
		this.mark = d;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "ActivityApply [aid=" + aid + ", mark=" + mark + ", pass=" + pass + ", reason=" + reason + ", student=" + student + "]";
	}

}
