import java.awt.BorderLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JTask extends JPanel {
	
	GUI gui;
	Searcher searcher;
	Task task;
	
	JTask(Task t, GUI g, Searcher s) {
		super();
		task = t;
		
		gui = g;
		searcher = s;
		
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(0, 0, 5, 0));
		
		JLabel text = new JLabel(task.text);
		text.setBorder(new EmptyBorder(0, 30, 0, 0));
		
		JCheckBox checkBox = new JCheckBox();
		checkBox.setBorder(new EmptyBorder(0, 0, 0, 30));
		
		//Listen to checkbox
		checkBox.addActionListener(new TaskCompletedListener(gui, searcher));
		
		add(text, BorderLayout.CENTER);
		add(checkBox, BorderLayout.EAST);
	}
}
