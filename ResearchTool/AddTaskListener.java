import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class AddTaskListener implements ActionListener {
	
	JTextField text;
	
	AddTaskListener(JTextField text) {
		this.text = text;
	}
	
	public void actionPerformed(ActionEvent e) {
		String t = "-   "+text.getText();
		
		Main.g.addTask(new Task(t, Main.t.pullId()));
	}

}
