import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

public class TaskCompletedListener implements ActionListener{
	
	GUI gui;
	Searcher searcher;
	
	TaskCompletedListener(GUI g, Searcher s) {
		super();
		
		gui = g;
		searcher = s;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Checkity check check");
		JCheckBox checkBox = (JCheckBox) e.getSource();
		JTask jTask = (JTask) checkBox.getParent();
		
		
		Main.t.removeTask(jTask.task.id);
	}

}
