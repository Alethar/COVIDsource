
public class NewsArticle extends Article
{
    private String name;

    private String sampleText;

    private String url;

    private String info;

    private int cred;

    private int bias;


    public NewsArticle( String name, String sampleText, String url, int cred, int bias )
    {
        super( name, sampleText, url );
        this.cred = cred;
        this.bias = bias;
    }


    public NewsArticle(
        String name,
        String sampleText,
        String url,
        int cred,
        int bias,
        String info )
    {
        super( name, sampleText, url );
        this.cred = cred;
        this.bias = bias;
        this.info = info;
    }


    /**
     * 
     * Accessor method for news credibility
     * 
     * @return
     */
    public int getCred()
    {
        return cred;

    }


    /**
     * 
     * Accessor method for news bias
     * 
     * @return
     */
    public int getBias()
    {
        return bias;
    }


    /**
     * 
     * Accessor method for news info
     * 
     * @return
     */
    public int getInfo()
    {
        return info;
    }
}
