import java.util.ArrayList;


/**
 * Created a Node class that will create a node with
 * data, content in node
 * next, pointer to the next node
 */
public class Student{
	String studentName;
	ArrayList<String> listOfPreferences = new ArrayList<>();
	Student next;
	
	//Parameterized Constructor
	public Student(String studentName, ArrayList<String> listOfPreferences) {
		this.studentName = studentName;
		this.listOfPreferences = listOfPreferences;
		next = null;
	}
}