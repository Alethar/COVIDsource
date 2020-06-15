import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ArticleSelectListener implements MouseListener {
	
	private Article art;
	
	ArticleSelectListener (Article art) {
		this.art = art;
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//Assign url to mouse

		Mouse.hasURL = true;
		Mouse.url = art.getURL();
		
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
