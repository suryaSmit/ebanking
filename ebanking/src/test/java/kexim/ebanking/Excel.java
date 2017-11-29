package kexim.ebanking;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.testng.annotations.DataProvider;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Excel {
	private Workbook book;
	private Sheet sh;
	private WritableWorkbook wbook;
	private WritableSheet wsh;
	FileInputStream fis;

	// set excel file to read the data
	public void setExcel(String filePath, String fileName, String sheetName) {
		try {
			fis = new FileInputStream(filePath + fileName);
			book = Workbook.getWorkbook(fis);
			sh = book.getSheet(sheetName);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// return no of rows
	public int getNoOfRows() {
		return sh.getRows();
	}

	// return no of columns
	public int getNoOfColumns() {
		return sh.getColumns();
	}

	// return a string value which is read from excel cell
	public String readData(int row, int col) {
		return sh.getCell(col, row).getContents();
	}

	// set excel file to write the data
	public void setExcelToWriteData(String filePath, String ifileName, String ofileName, String sheetName) {
		try {
			fis = new FileInputStream(filePath + ifileName);
			book = Workbook.getWorkbook(fis);
			FileOutputStream fos = new FileOutputStream(filePath + ofileName);
			wbook = Workbook.createWorkbook(fos, book);
			wsh = wbook.getSheet(sheetName);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// write data
	public void writeData(int row, int col, String data) {
		try {
			wsh.addCell(new Label(col, row, data));
		} catch (Exception e) {

		}
	}

	// save and close workbooks
	public void saveWorkbook() {
		try {
			wbook.write();
			wbook.close();
			book.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Object[][] getExcelData(String filePath, String fileName, String sheetName) {
		setExcel(filePath, fileName, sheetName);
		int nor = getNoOfRows();
		int noc = getNoOfColumns();
		String[][] data = new String[nor-1][noc];
		for(int i=1; i<nor;i++) {
			for(int j=0;j<noc;j++) {
				data[i-1][j] = readData(i, j);
			}
		}
		return data;
	}
	
	@DataProvider(name="branch data")
	public Object[][] getBranchData(){
		return getExcelData("/Users/surya/Documents/", "kexim data.xls", "branches");
	}
}
