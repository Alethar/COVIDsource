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
		tasks.add(new Task("Reclaim the holy land", pullId()));
		tasks.add(new Task("Reclaim the holy land", pullId()));
		tasks.add(new Task("Reclaim the holy land", pullId()));
	}
	
	public int pullId() {
		currentId ++;
		return currentId;
	}
	
	public void removeTask(int id) {
		Main.g.removeTask(id);
	}
}
