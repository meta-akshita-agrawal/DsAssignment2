import org.junit.Test;


public class CircularQueueTest {

	
	public static void main(String[] args){
		
		QueueArray obj = new QueueArray(3);
		
		
		
		obj.dequeue();
		
		int[] result = obj.getQueue();
		
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}
}
