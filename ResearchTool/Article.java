
public class Article
{
    private String name;

    private String sampleText;

    private String url;


    /**
     * Contructor initiaizes variables
     * 
     * @param name
     * @param sampleText
     */
    public Article( String name, String sampleText, String url )
    {
        this.name = name;
        this.sampleText = sampleText;
        this.url = url;
    }


    /**
     * 
     * Accessor method for article name
     * 
     * @return
     */
    public String getName()
    {
        return name;
    }


    /**
     * 
     * Accessor method for article sample text
     * 
     * @return
     */
    public String getSampleText()
    {
        return sampleText;
    }


    /**
     * 
     * Accessor method for article url
     * 
     * @return
     */
    public String getURL()
    {
        return url;
    }
}
