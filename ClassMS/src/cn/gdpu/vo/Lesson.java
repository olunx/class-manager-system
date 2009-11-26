package cn.gdpu.vo;

import java.util.Set;

public class Lesson {

	private int lessonId;
	private Set<Attendance> attendances;
	private String day;
	private String lessonName;
	private String lessonPeriod;
	private int truants;//逃课总人次

	public int getLessonId() {
		return lessonId;
	}

	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}

	public Set<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(Set<Attendance> attendances) {
		this.attendances = attendances;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getLessonPeriod() {
		return lessonPeriod;
	}

	public void setLessonPeriod(String lessonPeriod) {
		this.lessonPeriod = lessonPeriod;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public int getTruants() {
		return truants;
	}

	public void setTruants(int truants) {
		this.truants = truants;
	}

}
