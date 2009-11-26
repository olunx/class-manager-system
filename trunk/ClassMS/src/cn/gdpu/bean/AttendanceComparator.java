package cn.gdpu.bean;

import java.util.Comparator;

import cn.gdpu.vo.Student;
import cn.gdpu.vo.Vote;

public class AttendanceComparator<T> implements Comparator<T> {

	public int compare(T arg1, T arg2) {
		Student stu1 = (Student)arg1;
		Student stu2 = (Student)arg2;
		int size1 = stu1.getAttendances().size();
		int size2 = stu2.getAttendances().size();
		return size1 < size2 ? 1 : size1 == size2 ? 0 : -1 ;
	}

}
