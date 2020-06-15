import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JStashedArticle extends JPanel {
	
	public Article art;
	
	JStashedArticle (Article art) {
		super();
		
		this.art = art;
		
		setLayout(new BorderLayout());
		
		JButton delButton = new JButton("Del");
		delButton.addMouseListener(new RemArticleListener(art));
		add(delButton, BorderLayout.WEST);
		
		JLabel title = new JLabel(art.getName());
		add(title, BorderLayout.CENTER);
	}
}
