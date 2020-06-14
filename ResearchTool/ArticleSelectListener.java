import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ArticleSelectListener implements MouseListener {

	private GUI gui;
	private Searcher searcher;
	
	ArticleSelectListener (GUI g, Searcher s) {
		gui = g;
		searcher = s;
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//Assign url to mouse

		Mouse.hasURL = true;
		
		JPanel panel = (JPanel) e.getSource();
		JLabel urlLabel = (JLabel) panel.getComponent(2);
		Mouse.url = urlLabel.getText();
		
		System.out.println(Mouse.url + " picked up");
		
		Searcher.openBrowserTab(Mouse.url);
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
