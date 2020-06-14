import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JArticlePanel extends JPanel{
	JArticlePanel (Article article, Searcher searcher, GUI gui) {
		super();
		
		setLayout(new BorderLayout());
		addMouseListener(new ArticleSelectListener(gui, searcher));
		
		JLabel name = new JLabel(article.getName());
		JLabel sampleText = new JLabel(article.getSampleText());
		JLabel url = new JLabel(article.getURL());
		JLabel smallURL = new JLabel(article.getSmallURL());
		JLabel author = new JLabel(article.getAuthor());
		
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.add(name);
		content.add(sampleText);
		content.add(url);
		content.add(smallURL);
		content.add(author);
		add(content, BorderLayout.CENTER);
		
		JPanel rating = new JPanel();
		rating.setLayout(new BoxLayout(rating, BoxLayout.Y_AXIS));
		rating.setBorder(new EmptyBorder(0, 0, 0, 30));
		
		JLabel politicalBias = new JLabel("Bias goes here");
		JLabel credibility = new JLabel("Credibility goes here");
		
		rating.add(politicalBias);
		rating.add(credibility);
		add(rating, BorderLayout.EAST);
	}
}
