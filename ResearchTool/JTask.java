import java.awt.BorderLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JTask extends JPanel {
	
	JTask(String taskText) {
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(0, 0, 5, 0));
		
		JLabel text = new JLabel(taskText);
		text.setBorder(new EmptyBorder(0, 30, 0, 0));
		
		JCheckBox checkBox = new JCheckBox();
		checkBox.setBorder(new EmptyBorder(0, 0, 0, 30));
		
		add(text, BorderLayout.CENTER);
		add(checkBox, BorderLayout.EAST);
	}
}
