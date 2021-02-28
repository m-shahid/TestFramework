package com.bhiman.main.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
	
private static final Logger LOG = Logger.getLogger(ExcelReader.class);
	
	//declarations
		public static FileInputStream fi;
		public static FileOutputStream fo;
		public static XSSFWorkbook wb;
		public static XSSFSheet ws;
		public static Row row;
		public static Cell cell;

		//xfile-read, seaching xcel file
		public static void setExcelFile(String xlFile, String xlSheet) throws Exception {
			try {

				FileInputStream exceFile = new FileInputStream(xlFile);
				wb = new XSSFWorkbook();
				ws = wb.getSheet(xlSheet);
			} catch (Exception e) {
				throw (e);
			}
		}

		// get row count
		public static int getRowCount(String xlFile, String xlSheet) throws IOException {
			fi = new FileInputStream(xlFile);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlSheet);
			int rowcount = ws.getLastRowNum();
			wb.close();
			fi.close();
			return rowcount;
		}

		public static int getCellCount(String xlFile, String xlSheet, int rownum) throws IOException {
			fi = new FileInputStream(xlFile);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlSheet);
			row = ws.getRow(rownum);
			LOG.info("Row Count is "+ row);
			int cellcount = row.getLastCellNum();
			LOG.info("Cell count is "+cellcount);
			wb.close();
			fi.close();
			return cellcount;

		}

		public static String getCellData(String xlFile, String xlSheet, int rownum, int cellnum) throws IOException {
			fi = new FileInputStream(xlFile);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlSheet);
			row = ws.getRow(rownum);
			cell = row.getCell(cellnum);
			String data;
			try {
				DataFormatter formatter = new DataFormatter();
				String cellData = formatter.formatCellValue(cell);
				return cellData;
			} catch (Exception e) {
				data = "";
			}
			wb.close();
			fi.close();
			return data;
		}

		public static void setCellData(String xlFile, String xlSheet, int rownum, int cellnum, String data)
				throws IOException {
			fi = new FileInputStream(xlFile);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlSheet);
			row = ws.getRow(rownum);
			cell = row.createCell(cellnum);
			cell.setCellValue(data);
			fo = new FileOutputStream(xlFile);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
		}
	

}
