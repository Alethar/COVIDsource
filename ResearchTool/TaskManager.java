import java.util.ArrayList;

/**
 * manages tasks lmao
 * @author Hanzen Shou
 *
 */
public class TaskManager {
	public ArrayList<Task> tasks;
	private int currentId;
	
	TaskManager() {
		currentId = -1;
		
		tasks = new ArrayList<>();
		tasks.add(new Task("-   Read sources from sides of an issue", pullId()));
		tasks.add(new Task("-   Take note of how old an article is", pullId()));
		tasks.add(new Task("-   Use bias and credibility ratings to choose articles", pullId()));
	}
	
	public int pullId() {
		currentId ++;
		return currentId;
	}
	
	public void removeTask(int id) {
		Main.g.removeTask(id);
	}
}
