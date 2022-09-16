package week6.day2Assignment;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static String[][] getData(String excelFileName,String sheetName) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook book = new XSSFWorkbook("./test-data/"+excelFileName+".xlsx");  //Replace hardcoded excel dynamically
		XSSFSheet sheet = book.getSheet(sheetName);  //
		int rowNum = sheet.getLastRowNum();
		XSSFRow header = sheet.getRow(0);
		int colNum = header.getLastCellNum();
		
		String[][] data = new String[rowNum][colNum]; //Create 2D array to store data
		
		for(int i=1;i<=rowNum;i++) {
			XSSFRow eachRow = sheet.getRow(i);
			for(int j=0;j<colNum;j++) {
				XSSFCell cell = eachRow.getCell(j);
				String cellValue = cell.getStringCellValue();
				data[i-1][j]=cellValue; //Since data[][] is from java, the index always starts from 0 only, whereas acc. to excel, we get data from row[1] only, thats y we use i-1
				System.out.println(cellValue);
			}
		}
		book.close();
		return data;
	}

}
