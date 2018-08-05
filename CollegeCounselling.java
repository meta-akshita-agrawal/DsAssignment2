import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class CollegeCounselling {
	
	Excel excelObj = new Excel();

	ArrayList<Program> programList = new ArrayList<>();
	Queue<Student> studentList = new LinkedList<>();
	
	HashMap<String,String> allotedList = new HashMap<>();
	
	
	public void getProgramList(String location) throws BiffException, IOException {
		this.programList = excelObj.readPrograms(location);
	}
	
	public void getStudentList(String location) throws BiffException, IOException {
		this.studentList = excelObj.readStudents(location);
	}
	
	public boolean haveSpace(int index) {
		return programList.get(index).getCapacity() != 0;
	}
	
	public void allocation() {
		
		int numberOfPreferences = studentList.peek().getNumberOfPreferences();
		
		while(!studentList.isEmpty()) {
			Student frontStudent = studentList.peek();
			System.out.println(frontStudent.getStudentName());
			int flag = 0;
			for(int i=0;i<numberOfPreferences;i++) {
				for(int j=0;j<programList.size();j++) {
					String programName = programList.get(j).getProgramName();
					//System.out.println("preference" + i + ": " + frontStudent.getPreference(i));
					//System.out.println(haveSpace(j));
					//System.out.println(i + ": " + frontStudent.getPreference(i) + " " +  j + ": " + programName);
					if(frontStudent.getPreference(i).equals(programName) && haveSpace(j)) {
						allotedList.put(frontStudent.getStudentName(), programName);
						System.out.println(frontStudent.getStudentName() + " " +  programName);
						programList.get(j).setCapacity(1);
						flag = 1;
						break;
					}
				}
				if(flag==1) {
					System.out.println("-----------");
					break;
				}
			}
			if(!studentList.isEmpty()) {
				studentList.remove();
			}
		}
	}
	
	public void writeAllotedList(String location) throws RowsExceededException, BiffException, WriteException, IOException {
		excelObj.writeAllotedList(location, this.allotedList);
	}
}
