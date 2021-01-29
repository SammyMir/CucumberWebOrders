package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	private Workbook workBook;
	private Sheet workSheet;
	private String filePath;
	
	public ExcelUtils(String filePath, String sheetName) {
		this.filePath=filePath;
	try {
	FileInputStream fis=new FileInputStream(filePath);
	workBook=WorkbookFactory.create(fis);
    workSheet=workBook.getSheet(sheetName);
	
         }catch (Exception e) {
        	 e.printStackTrace();
}
}
	public int rowCount() {
		return workSheet.getLastRowNum();
		
	}
	public int columnCount() {
		return workSheet.getRow(0).getLastCellNum();
}
	public String getCellData(int rowNumber, int columnNumber) {
		Cell cell;
		cell=workSheet.getRow(rowNumber).getCell(columnNumber);
		String cellData=cell.toString();
		return cellData;	
	}
	public String[][] getAllData(){
		String[][] data=new String[rowCount()][columnCount()];
		for(int i=0;i<rowCount();i++) {
			for(int j=0; j<columnCount();j++) {
			String value=getCellData(i,j);
			data[i][j]=value;
		
	}
}
		return data;
		
}
    public void setCellData(String value, int rowNum, int colNum) {
    	Cell cell;
        Row row;
        row=workSheet.getRow(rowNum);
        cell=row.getCell(colNum);
        if(cell==null) {
            cell=row.createCell(colNum);
            cell.setCellValue(value);    
        }
        else {
            cell.setCellValue(value);
        }
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            workBook.write(fos);
            fos.close();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        
        }
    }
	
}
