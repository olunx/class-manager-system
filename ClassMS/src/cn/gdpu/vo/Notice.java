package cn.gdpu.vo;

import java.util.Date;
import java.util.List;

public class Notice {
	private int id;
	private Student author;
	private String title;
	private Date time;
	private String content;
	private List<Post> comment;

	public Student getAuthor() {
		return author;
	}

	public void setAuthor(Student author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Post> getComment() {
		return comment;
	}

	public void setComment(List<Post> comment) {
		this.comment = comment;
	}

}
