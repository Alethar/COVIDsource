import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JStashedArticle extends JPanel {
	
	public Article art;
	
	JStashedArticle (Article art) {
		super();
		
		this.art = art;
		
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(0, 0, 0, 0));
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("assets/remove.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(69, 24, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		
		JButton delButton = new JButton(imageIcon);
		delButton.setBorderPainted(false); 
		delButton.setContentAreaFilled(false); 
		delButton.setFocusPainted(false); 
		delButton.setOpaque(false);
		delButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		delButton.addMouseListener(new RemArticleListener(art));
		delButton.setBorder(new EmptyBorder(10, 7, 10, 0));
		add(delButton, BorderLayout.WEST);
		
		JLabel title = new JLabel(art.getName());
		title.setBorder(new EmptyBorder(0, 10, 0, 0));
		title.addMouseListener(new ArticleSelectListener(art));
		add(title, BorderLayout.CENTER);
	}
}
