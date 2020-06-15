import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RemArticleListener implements MouseListener
{
    
    private Article article;

    public RemArticleListener(Article article) {
        this.article = article;
    }
    
    public void mouseClicked( MouseEvent e )
    {
        // TODO Auto-generated method stub
        
    }


    public void mousePressed( MouseEvent e )
    {
        Main.g.removeStashedArticle(article);
    }

	
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}