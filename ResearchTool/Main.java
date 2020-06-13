
public class Main
{
    public static void main(String[] args) {
        Searcher s = new Searcher();
        GUI g = new GUI(s);
        s.setGUI( g );
        while(true) {
            Thread.sleep( 1000000 );
        }
    }
}
