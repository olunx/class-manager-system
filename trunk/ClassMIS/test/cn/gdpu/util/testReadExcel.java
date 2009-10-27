package cn.gdpu.util;

import cn.gdpu.util.ReadExcel;
import junit.framework.TestCase;

public class testReadExcel extends TestCase {

	public void testExcel() {
		ReadExcel re = new ReadExcel();
		StringBuffer result = re.readExcel("E:\\olunx\\医软07-通讯录-测试.xls");
		if (result != null) {
			System.out.println(result.toString());
		}

	}
}
