
public class NewsArticle extends Article
{
    private String name;

    private String sampleText;

    private String url;

    private int cred;

    private int bias;


    public NewsArticle( String name, String sampleText, String url, int cred, int bias )
    {
        super( name, sampleText, url );
        this.cred = cred;
        this.bias = bias;
    }


    /**
     * 
     * Accessor method for article credibility
     * 
     * @return
     */
    public int getCred()
    {
        return cred;

    }


    /**
     * 
     * Accessor method for article bias
     * 
     * @return
     */
    public int getBias()
    {
        return bias;
    }
}
