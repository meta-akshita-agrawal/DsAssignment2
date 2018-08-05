import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;



public class Excel {

	
	public Queue<Student> readStudents(String location) throws BiffException, IOException{
		
		Queue<Student> studentList = new LinkedList<>();
		
		try{
			Workbook workbook = Workbook.getWorkbook(new java.io.File(location));
		
			Sheet sheet1 = workbook.getSheet(0);
			
			int rows = sheet1.getRows();
			int columns = sheet1.getColumns();
			
			
			for(int i=1;i<rows;i++){
				String studentName = sheet1.getCell(0,i).getContents();
				ArrayList<String> listOfPreferences = new ArrayList<>();
				for(int j=1;j<columns;j++){
					listOfPreferences.add(sheet1.getCell(j,i).getContents());
				}
				
				studentList.add(new Student(studentName,listOfPreferences));
			}
			
		} catch (BiffException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		
		return studentList;
	}

	
	public ArrayList<Program> readPrograms(String location) throws BiffException, IOException{
		
		ArrayList<Program> programList = new ArrayList<>();
		
		try{
			Workbook workbook = Workbook.getWorkbook(new java.io.File(location));
		
			Sheet sheet1 = workbook.getSheet(0);
			
			int rows = sheet1.getRows();
			
			for(int i=1;i<rows;i++){
				String programName = sheet1.getCell(0,i).getContents();
				
				
				int capacity = Integer.valueOf(sheet1.getCell(1,i).getContents());
				
				programList.add(new Program(programName,capacity));
				
			}
			
		} catch (BiffException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		
		return programList;
	}
	
	public void writeAllotedList(String location, HashMap<String,String> allotedList) throws BiffException, IOException, RowsExceededException, WriteException{
		
		 WritableWorkbook workbook = null;
		
		try{
			File file = new File(location);
		
		
		    workbook = Workbook.createWorkbook(file);
				
		 
		    
		    WritableSheet sheet = workbook.createSheet("final", 0);
		    
		    sheet.addCell(new Label(0,0,"Student Name"));
		    sheet.addCell(new Label(1,0,"Program Name"));
		    
		    System.out.println("================");
		    
		    int i=1;
			
			for (String name: allotedList.keySet()){

				System.out.println("================");
	            String key = name.toString();
	            String value = allotedList.get(name).toString();  
	            
	            System.out.println(key + " " + value);
	            
	            Label label1 = new Label(0,i,key);
	            Label label2 = new Label(1,i,value);
	    	    
	    	    sheet.addCell(label1);
	    	    sheet.addCell(label2);
	    	    
	    	    
	    	    i++;


			} 
			
			workbook.write();
			
		} catch (WriteException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}finally {

            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }
		
		}
}}