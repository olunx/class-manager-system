package cn.gdpu.vo;

import java.util.Date;

public class Post {
	private Student author;
	private Notice parent;
	private Date time;
	private String content;

	public Student getAuthor() {
		return author;
	}

	public void setAuthor(Student author) {
		this.author = author;
	}

	public Notice getParent() {
		return parent;
	}

	public void setParent(Notice parent) {
		this.parent = parent;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
