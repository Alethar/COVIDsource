
public class Task {
	public String text;
	public String type;
	public int id;
	private boolean isCompleted;
	
	Task(String te, int i) {
		text = te;
		id = i;
		
		type = "generic";
		isCompleted = false;
	}
}
