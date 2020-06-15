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
        Main.a.cloneArticle(article);
        
    }


    public void mouseReleased( MouseEvent e )
    {
        // TODO Auto-generated method stub
        
    }


    public void mouseEntered( MouseEvent e )
    {
        // TODO Auto-generated method stub
        
    }


    public void mouseExited( MouseEvent e )
    {
        // TODO Auto-generated method stub
        
    }

}
