

public class Program {
	
	String programName;
	int capacity;
	
	
	Program(String programName, int capacity){
		this.programName = programName;
		this.capacity = capacity;
	}
	
	public String getProgramName() {
		return this.programName;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public void setCapacity(int allocatedCapacity) {
		this.capacity = this.capacity - allocatedCapacity;
	}

}

