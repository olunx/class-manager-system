package cn.gdpu.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
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
		HSSFCell cell = null;
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
					cell = row.getCell(k);
					if (cell == null)
						continue;
					switch (cell.getCellType()) {
					case HSSFCell.CELL_TYPE_NUMERIC:
						System.out.println("row  " + j + "  cell  " + k + "  " + cell.getNumericCellValue());
						break;
					case HSSFCell.CELL_TYPE_STRING:
						System.out.println("row  " + j + "  cell  " + k + "  " + cell);
						break;
					}
				}
			}
		}
		return result;
	}
}
