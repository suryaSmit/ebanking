package kexim.ebanking;

public class TestExcel {
	public static void main(String[] args) {
		Excel excel = new Excel();
		//set excel file to read data
		excel.setExcel("/Users/surya/Documents/", "kexim data.xls", "branches");
		//get no of rows
		int rows = excel.getNoOfRows();
		//get no of columns
		int cols= excel.getNoOfColumns();
		System.out.println(rows+" "+cols);
		//read excel data
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols; j++) {
				System.out.print(excel.readData(i, j)+"\t");
			}
			System.out.println();
		}
		
		//set excel file to write the data
		excel.setExcelToWriteData("/Users/surya/Documents/","kexim data.xls", "outputdata.xls", "branches");
		for(int i=1;i<rows;i++) {
			excel.writeData(i, 7, "test passed");
		}
		
		//save the work book
		excel.saveWorkbook();
	}

}
