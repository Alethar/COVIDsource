import java.awt.*;
import javax.swing.*;

public class Test extends JFrame{
	private JPanel panel;
	
	public Test() {
		super("Hola");
		
		System.out.println("Booting uppp");
		
		panel = new JPanel(new FlowLayout());
		add(panel);
		
		JLabel label = new JLabel("Gimme the magic");
		JTextField magic = new JTextField(20);
		
		panel.add(label);
		panel.add(magic);
		
		setSize(300, 300);
		setVisible(true);
	}
}
