package kexim.ebanking;

import java.io.FileInputStream;
import java.io.FileOutputStream;

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

	// set excel file to read the data
	public void setExcel(String filePath, String fileName, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(filePath + fileName);
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
	public void setExcelToWriteData(String filePath, String fileName, String sheetName) {
		try {
			FileOutputStream fos = new FileOutputStream(filePath + fileName);
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
}
