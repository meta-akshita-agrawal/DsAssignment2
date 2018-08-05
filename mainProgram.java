import java.io.IOException;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;


public class mainProgram {

	public static void main(String[] args) throws BiffException, IOException, RowsExceededException, WriteException {
		
		CollegeCounselling obj = new CollegeCounselling();
		
		obj.getProgramList("C:\\Users\\hp\\Documents\\Programs.xls");
		
		obj.getStudentList("C:\\Users\\hp\\Documents\\Students.xls");
		
		obj.allocation();
		
		obj.writeAllotedList("C:\\Users\\hp\\Documents\\final.xls");
		
		
		
		/*System.out.println(studentList.size());
		
		while(studentList!= null) {
			Student frontStudent = studentList.peek();
			System.out.print(frontStudent.getStudentName());
			for(int j=0;j<frontStudent.getNumberOfPreferences();j++) {
				System.out.print(" " + frontStudent.getPreference(j));
			}
			System.out.println();
			studentList.remove();
		}*/
		
		
		/*for(int i=0;i<programList.size();i++) {
			System.out.println(programList.get(i).getProgramName() + " " + programList.get(i).getCapacity());
		}*/
		
	}
	
}
