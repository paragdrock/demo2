package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelSheetReading {
	public static void main(String[] args) throws Exception {
		FileInputStream fileInputStream = new FileInputStream("excel.xls");
		Workbook workbook = Workbook.getWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet("Sheet2");
		int rows  = sheet.getRows();
		
		int col = sheet.getColumns();
		for (int i = 0; i < rows; i++) {
		for (int j = 0; j < col; j++) {
		Cell cell=	sheet.getCell(j,i);
		String celldata =cell.getContents();
		System.out.print(celldata+"  ");
		}
		System.out.println();
		}
	}

}
