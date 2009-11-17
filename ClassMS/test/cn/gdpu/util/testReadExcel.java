package cn.gdpu.util;

import java.util.List;

import cn.gdpu.util.excel.ReadExcel;
import cn.gdpu.util.excel.StudentExcel;
import junit.framework.TestCase;

public class testReadExcel extends TestCase {

//	public void testRegExcel() {
//		ReadExcel re = new ReadExcel();
//		List<String> result = re.readExcel("E:\\olunx\\医软07-通讯录-测试.xls");
//
//		if (result != null) {
//
//			int resultLength = result.size();
//			int columns = Integer.parseInt(result.get(resultLength - 1).toString());
//			
//			System.out.println("columns  " + columns);
//			System.out.println("result  " + result);
//
//			int dorm = -1, name = -1, qq = -1, phone = -1;
//
//			String text;
//			for (int i = 0; i < columns; i++) {
//				text = result.get(i);
//				// System.out.println(text);
//				if (text.contains("宿舍")) {
//					dorm = i;
//				} else if (text.contains("姓名")) {
//					name = i;
//				} else if (text.contains("QQ")) {
//					qq = i;
//				} else if (text.contains("手机")) {
//					phone = i;
//				}
//			}
//
//			int lastLoop = resultLength - columns;
//			for (int i = columns, j = 1; i < lastLoop; j++) {
//
//				if (dorm != -1)
//				System.out.println(j + " dorm: " + result.get(i + dorm));
//				if (name != -1)
//				System.out.println(j + " name: " + result.get(i + name));
//				if (qq != -1)
//				System.out.println(j + " qq: " + result.get(i + qq));
//				if (phone != -1)
//				System.out.println(j + " phone: " + result.get(i + phone));
//				System.out.println();
//				
//				i = i + columns;
//			}
//
//		}
//
//	}
	
	public void testScoreExcel() {
		StudentExcel.getStudentRegExcel().getScoreData("C:\\Documents and Settings\\olunx\\桌面\\第一二学期成绩.xls");
	}
}
