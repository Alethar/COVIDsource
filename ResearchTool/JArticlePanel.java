import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JArticlePanel extends JPanel{
	Article art;
	
	JArticlePanel (Article article) {
		super();
		art = article;
		
		//init
		setLayout(new BorderLayout());
		
		
		//Save Button
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("assets/save_light.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(105, 36, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		
		JButton saveButton = new JButton(imageIcon);
		saveButton.setBorderPainted(false); 
		saveButton.setContentAreaFilled(false); 
		saveButton.setFocusPainted(false); 
		saveButton.setOpaque(false);
		
		saveButton.addMouseListener( new AddArticleListener(article) );
		saveButton.setBorder(new EmptyBorder(0, 5, 0, 10));
		add(saveButton, BorderLayout.WEST);
		
		//Main area
		
		JLabel name = new JLabel(art.getName());
		name.setFont(new Font(name.getFont().getName(), Font.PLAIN, 15));
		
		JLabel sampleText = new JLabel(art.getSampleText());
		JLabel url = new JLabel(art.getURL());
		JLabel smallURL = new JLabel(art.getSmallURL());
		JLabel author = new JLabel(art.getAuthor());
		
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.add(name);
		content.add(sampleText);
		content.add(url);
		content.add(smallURL);
		content.add(author);
		content.setBorder(new EmptyBorder(10, 10, 10, 0));
		
		//Listener
		content.addMouseListener(new ArticleSelectListener(art));
		add(content, BorderLayout.CENTER);
		
		//Rating/Cred
		JPanel rating = new JPanel();
		rating.setLayout(new BoxLayout(rating, BoxLayout.Y_AXIS));
		rating.setBorder(new EmptyBorder(0, 0, 0, 30));
		
		String cl = art.getClass().getName();
		System.out.println(cl);
		if (cl.equals("NewsArticle")) {
			NewsArticle newsArt = (NewsArticle) art;
			
			JLabel politicalBias = new JLabel(returnBias(newsArt.getBias()));
			JLabel credibility = new JLabel("Credibility: " + newsArt.getCred()+"/5.0");
			
			politicalBias.setFont(new Font(politicalBias.getFont().getName(), Font.PLAIN, 14));
			credibility.setFont(new Font(credibility.getFont().getName(), Font.PLAIN, 14));
			
			rating.add(politicalBias);
			rating.add(credibility);
		}
		
		rating.setBorder(new EmptyBorder(10, 0, 0, 10));
		add(rating, BorderLayout.EAST);
	}
	
	public String returnBias(double bias) {
        if(bias <=1 ) {
            return "Very Biased Left";
        }
        else if(bias <= 2) {
            return "Biased Left";
        }
        else if(bias <= 2.5) {
            return "Slightly Biased Left";
        }
        else if(bias <= 3.5) {
            return "Center";
        }
        else if(bias <= 4) {
            return "Slightly Biased Right";
        }
        else if(bias <= 5) {
            return "Biased Right";
        }
        else if(bias <= 6) {
            return "Very Biased Right";
        }
        return "??";
    }
}
