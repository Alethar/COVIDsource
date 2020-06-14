
public class NewsArticle extends Article
{
    private String name;

    private String sampleText;

    private String url;

    private String info;

    private double cred;

    private double bias;


    public NewsArticle( String name, String sampleText, String url, double newsCred, double newsBias )
    {
        super( name, sampleText, url );
        this.cred = newsCred;
        this.bias = newsBias;
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
    public double getCred()
    {
        return cred;

    }


    /**
     * 
     * Accessor method for news bias
     * 
     * @return
     */
    public double getBias()
    {
        return bias;
    }


    /**
     * 
     * Accessor method for news info
     * 
     * @return
     */
    public double getInfo()
    {
        return info;
    }
}
