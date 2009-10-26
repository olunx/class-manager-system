package cn.gdpu.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReadExcel re = new ReadExcel();
		StringBuffer result = re.readExcel("E:\\olunx\\医软07-通讯录.xls");
		System.out.println(result.toString());
	}

	// 读取Excel的内容，参数：文件路径
	private StringBuffer readExcel(String filePath) {

		// 用于保存返回的数据
		StringBuffer result = new StringBuffer();

		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(new File(filePath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		HSSFWorkbook excel = null;
		try {
			excel = new HSSFWorkbook(in);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// result.append("数目：" + excel.getNumberOfSheets());

		HSSFSheet sheet = null;
		HSSFRow row = null;
		int sheetNo = excel.getNumberOfSheets();
		int sheetRows;
		int rowCells;
		for (int i = 0; i < sheetNo; i++) {
			sheet = excel.getSheetAt(i);
			sheetRows = sheet.getPhysicalNumberOfRows();
			for (int j = 0; j < sheetRows; j++) {
				row = sheet.getRow(j);
				rowCells = row.getPhysicalNumberOfCells();
				for (int k = 0; k < rowCells; k++) {
					System.out.println("row  " + j + "  cell  " + k +"  "+ row.getCell(k).toString());
				}
			}
		}
		return result;
	}
}
