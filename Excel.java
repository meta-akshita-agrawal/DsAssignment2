import java.io.IOException;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



public class Excel {

	
	public void readStudents(String location) throws BiffException, IOException{
		
		try{
			Workbook workbook = Workbook.getWorkbook(new java.io.File(location));
		
			Sheet sheet1 = workbook.getSheet(0);
			
			int rows = sheet1.getRows();
			
			for(int i=0;i<rows;i++){
				String studentName = sheet1.getCell(0,i).getContents();
				ArrayList<String> listOfPreferences = new ArrayList<>();
				for(int j=1;j<rows;j++){
					listOfPreferences.add(sheet1.getCell(j,i).getContents());
				}
				new Student(studentName,listOfPreferences);
			}
			
		} catch (BiffException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
	
	public void readPrograms(String location) throws BiffException, IOException{
		
		try{
			Workbook workbook = Workbook.getWorkbook(new java.io.File(location));
		
			Sheet sheet1 = workbook.getSheet(0);
			
			int rows = sheet1.getRows();
			
			for(int i=0;i<rows;i++){
				String programName = sheet1.getCell(0,i).getContents();
				
				int capacity = Integer.parseInt(sheet1.getCell(1,i).getContents());
				
				new Program(programName,capacity);
				
			}
			
		} catch (BiffException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
	
	
	
	
	

}
