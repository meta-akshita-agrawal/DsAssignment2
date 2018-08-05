import java.util.ArrayList;

/**
 * Created a Node class that will create a node with
 * data, content in node
 * next, pointer to the next node
 */
public class Student{
	String studentName;
	ArrayList<String> listOfPreferences = new ArrayList<>();
	
	//Parameterized Constructor
	public Student(String studentName, ArrayList<String> listOfPreferences) {
		this.studentName = studentName;
		this.listOfPreferences = listOfPreferences;
	}
	
	public String getStudentName() {
		return this.studentName;
	}
	
	public String getPreference(int index) {
		return this.listOfPreferences.get(index);
	}
	
	public int getNumberOfPreferences() {
		return this.listOfPreferences.size();
	}

}