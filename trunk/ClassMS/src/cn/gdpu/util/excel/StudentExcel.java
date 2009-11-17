package cn.gdpu.util.excel;

import java.util.ArrayList;
import java.util.List;

import cn.gdpu.vo.Student;

public class StudentExcel extends ReadExcel {

	private static StudentExcel studentRegExcel;

	public static StudentExcel getStudentRegExcel() {
		if (studentRegExcel == null) {
			studentRegExcel = new StudentExcel();
		}
		return studentRegExcel;
	}

	/**
	 * 读取Excel的内容，返回需要的属性列数据，最后一位为属性列数
	 * 
	 * @param filePath
	 * @return
	 */
	public List<Student> getRegData(String filePath) {

		// 获取原始数据
		List<String> result = super.readExcel(filePath);

		if (result != null) {

			// 用于保存返回的数据
			List<Student> resultData = new ArrayList<Student>();

			int resultLength = result.size();
			// 获取保存的属性列数
			int columns = Integer.parseInt(result.get(resultLength - 1).toString());

			//System.out.println("columns  " + columns);
			//System.out.println("result  " + result);

			int dormOffset = -1;
			int nameOffset = -1;
			int qqOffset = -1;
			int phoneOffset = -1;
			int snoOffset = -1;

			// 记录实际获取到的属性列数
			String text;
			int resultColumn = 0;
			for (int index = 0; index < columns; index++) {
				text = result.get(index).toString();
				// System.out.println(text);
				if (text.contains("宿舍")) {
					dormOffset = index;
					resultColumn++;
				} else if (text.contains("姓名")) {
					nameOffset = index;
					resultColumn++;
				} else if (text.contains("QQ")) {
					qqOffset = index;
					resultColumn++;
				} else if (text.contains("手机")) {
					phoneOffset = index;
					resultColumn++;
				} else if (text.contains("学号")) {
					snoOffset = index;
					resultColumn++;
				}
			}

			// 取出数据
			int lastLoop = resultLength - columns;// 去掉最后一次循环
			Student stu;
			String temp;
			for (int index = columns; index < lastLoop;) {
				stu = new Student();
				if (nameOffset != -1)
					stu.setRealName(result.get(index + nameOffset));
				if (dormOffset != -1)
					stu.setDorm(result.get(index + dormOffset));
				if (qqOffset != -1) {
					temp = result.get(index + qqOffset);
					stu.setQq(Long.parseLong(temp));
					stu.setMail(temp + "@qq.com");
				}

				if (phoneOffset != -1)
					stu.setPhoneNo(Long.parseLong(result.get(index + phoneOffset)));
				if (snoOffset != -1) {
					temp = result.get(index + snoOffset);
					stu.setSno(temp);
					stu.setUsername(temp);
					stu.setPassword(temp);
				}

				resultData.add(stu);
				//System.out.println(stu.toString());
				index = index + columns;
			}

			return resultData;
		}

		return null;
	}

	/**
	 * 
	 *读取成绩表信息，返回字符数组
	 * @param filePath
	 * @return
	 */
	public List<String> getScoreData(String filePath) {

		// 获取原始数据
		List<String> result = super.readExcel(filePath);

		if (result != null) {

			// 用于保存返回的数据
			List<String> resultData = new ArrayList<String>();

			int resultLength = result.size();
			// 获取保存的属性列数
			int columns = Integer.parseInt(result.get(resultLength - 1).toString());

			//System.out.println("columns  " + columns);
			//System.out.println("result  " + result);

			// 保存属性名称
			String[] columnName;
			columnName = new String[columns];
			for (int i = 0; i < columns; i++) {
				columnName[i] = result.get(i);
			}

			// 链接每行字符串
			int lastLoop = resultLength - columns;
			StringBuffer eachOne;
			for (int i = columns; i < lastLoop; i++) {
				eachOne = new StringBuffer();
				for (int j = 0; j < columns; j++) {
					eachOne.append(columnName[j] + ":" + result.get(i++) + "\n");
				}
				i--;
				resultData.add(eachOne.toString());
				//System.out.println(eachOne.toString());
			}

			return resultData;
		}

		return null;
	}
}
