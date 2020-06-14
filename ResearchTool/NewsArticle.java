
public class NewsArticle extends Article
{
    private double cred;

    private double bias;


    public NewsArticle(
        String title,
        String sampleText,
        String url,
        String smallurl,
        String author,
        double newsCred,
        double newsBias )
    {
        super( title, sampleText, url, smallurl, author );
        this.cred = newsCred;
        this.bias = newsBias;
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

}
