
public class NewsArticle extends Article
{
    private String name;

    private String sampleText;

    private int cred;

    private int bias;


    public NewsArticle( String name, String sampleText, int cred, int bias )
    {
        super( name, sampleText );
        this.cred = cred;
        this.bias = bias;
    }
}
