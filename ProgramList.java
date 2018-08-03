import java.util.ArrayList;

public class ProgramList implements StudentQueueInterface{

	Student front;
	Student rear;

	//Constructor
	ProgramList() {
		this.front = null;
		this.rear = null;
	}

	/**
	 * Checks if a queue is empty
	 */
	public boolean isEmpty() {
		return this.rear == null;
	}

	/**
	 * Adds a node at the end of linked list
	 * @param item to add
	 */
	public void enqueue(String studentName, ArrayList<String> listOfPreferences) {

		Student newNode = new Student(studentName,listOfPreferences);

		if (front == null) {//if queue is empty both front and end will be set to new node
			this.front = newNode;
			this.rear = newNode;
		} else {
			rear.next = newNode;//adding new node to next of rear
			rear = newNode;//updating rear
		}

	}

	/**
	 * removes a node from start of linked list
	 */
	public void dequeue() {

		if (isEmpty()) {
			throw new AssertionError("queue is empty. nothing to dequeue");
		}

		front = front.next;//updates front

	}

}