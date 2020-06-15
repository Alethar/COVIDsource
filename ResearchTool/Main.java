import javax.swing.UnsupportedLookAndFeelException;

public class Main
{
	public static GUI g;
	public static Searcher s;
	public static TaskManager t;
	public static ArticleHolder a;
	
	
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
	UnsupportedLookAndFeelException, InterruptedException  {
    	
    	t = new TaskManager();
        s = new Searcher();
        g = new GUI();
        a = new ArticleHolder();
        
        /*while(true) {
            Thread.sleep( 1000000 );
        }*/
    }
}
