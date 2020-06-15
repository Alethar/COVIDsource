import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ArticleReleaseListener implements MouseListener {
	
	private GUI gui;
	private Searcher searcher;
	
	ArticleReleaseListener () {
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (Mouse.hasURL) {
			//System.out.println(Mouse.url+" released");
			Mouse.hasURL = false;
			
			//TODO: Deliver article to some backend (note that article has been lost by this point, 
			// 					find some way to attach the article to the JPanel).
			
			Mouse.url = "";
		}
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	//NOTE: OVERRIDES CAUSE PROBLEMS
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

}
