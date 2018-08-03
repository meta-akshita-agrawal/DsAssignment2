import java.util.ArrayList;

public interface StudentQueueInterface {

	boolean isEmpty();//checks if queue is empty

	void enqueue(String studentName, ArrayList<String> listOfPreferences);//adds an item at the last of queue

	void dequeue();//removes an item from the front of queue

}
