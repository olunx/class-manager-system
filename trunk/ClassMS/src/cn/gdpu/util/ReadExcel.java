package cn.gdpu.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcel {
	
	private static ReadExcel readExcel;
	
	public static ReadExcel getReadExcel() {
		if(readExcel == null) {
			readExcel = new ReadExcel();
		}
		return readExcel;
	}

	/**
	 * 读取Excel的内容，返回原始数据，最后一位为属性列数
	 * 
	 * @param filePath
	 * @return
	 */
	public List<String> readExcel(String filePath) {

		// 用于保存返回的数据
		List<String> resultData = new ArrayList<String>();

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

		HSSFSheet sheet = null;
		HSSFRow row = null;
		HSSFCell cell = null;
		int sheetNo = excel.getNumberOfSheets();
		int sheetRows = 0;
		int rowCells = 0;
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
						//System.out.println("行  " + j + "  列  " + k + "  " + (long)cell.getNumericCellValue());
						resultData.add(String.valueOf((long)cell.getNumericCellValue()));
						break;
					case HSSFCell.CELL_TYPE_STRING:
						//System.out.println("行  " + j + "  列  " + k + "  " + cell);
						resultData.add(cell.toString());
						break;
					case HSSFCell.CELL_TYPE_BLANK:
						//System.out.println("行  " + j + "  列  " + k + "  " + "null");
						resultData.add("0");
						break;
					}
				}
			}
		}

		// 获取属性列数
		resultData.add(String.valueOf(rowCells));

		return resultData;
	}

	/**
	 * 读取Excel的内容，返回需要的属性列数据，最后一位为属性列数
	 * 
	 * @param filePath
	 * @return
	 */
	public List<String> getExcelData(String filePath) {

		//获取原始数据
		List<String> result = readExcel(filePath);

		if (result != null) {
			
			//用于保存返回的数据
			List<String> resultData = new ArrayList<String>();

			int resultLength = result.size();
			//获取保存的属性列数
			int columns = Integer.parseInt(result.get(resultLength - 1).toString());

			System.out.println("columns  " + columns);
			System.out.println("result  " + result);

			int dormOffset = -1, nameOffset = -1, qqOffset = -1, phoneOffset = -1;

			String text;
			//记录实际获取到的属性列数
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
				}
			}

			//去掉最后一次循环
			int lastLoop = resultLength - columns;
			
			for (int index = 0; index < lastLoop;) {
				resultData.add(result.get(index + nameOffset));
				resultData.add(result.get(index + dormOffset));
				resultData.add(result.get(index + qqOffset));
				resultData.add(result.get(index + phoneOffset));
				System.out.println(" name: " + result.get(index + nameOffset));
				System.out.println(" dorm: " + result.get(index + dormOffset));
				System.out.println(" qq: " + result.get(index + qqOffset));
				System.out.println(" phone: " + result.get(index + phoneOffset));
				System.out.println();

				index = index + columns;
			}
			
			//保存属性列数
			resultData.add(String.valueOf(resultColumn));

			return resultData;
		}

		return null;
	}
}
