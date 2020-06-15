import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddArticleListener implements MouseListener
{
    
    private Article article;

    public AddArticleListener(Article article) {
        this.article = article;
    }
    
    public void mouseClicked( MouseEvent e )
    {
        // TODO Auto-generated method stub
        
    }


    public void mousePressed( MouseEvent e )
    {
        Main.g.stashArticle(article);
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
