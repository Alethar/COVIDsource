import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JArticlePanel extends JPanel{
	Article art;
	
	JArticlePanel (Article article, Searcher searcher, GUI gui) {
		super();
		art = article;
		
		//init
		setLayout(new BorderLayout());
		
		
		//Save Button
		JButton saveButton = new JButton("Save");
		saveButton.setBorder(new EmptyBorder(0, 5, 0, 25));
		add(saveButton, BorderLayout.WEST);
		
		//Main area
		
		JLabel name = new JLabel(art.getName());
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
		
		//Listener
		content.addMouseListener(new ArticleSelectListener(gui, searcher));
		add(content, BorderLayout.CENTER);
		
		//Rating/Cred
		JPanel rating = new JPanel();
		rating.setLayout(new BoxLayout(rating, BoxLayout.Y_AXIS));
		rating.setBorder(new EmptyBorder(0, 0, 0, 30));
		
		String cl = art.getClass().getName();
		System.out.println(cl);
		if (cl.equals("NewsArticle")) {
			NewsArticle newsArt = (NewsArticle) art;
			
			JLabel politicalBias = new JLabel("Bias: " + newsArt.getBias());
			JLabel credibility = new JLabel("Credibility goes here " + newsArt.getCred());
			
			rating.add(politicalBias);
			rating.add(credibility);
		}
			
		add(rating, BorderLayout.EAST);
	}
}
