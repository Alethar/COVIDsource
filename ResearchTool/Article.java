
public class Article
{
    private String name;

    private String sampleText;


    /**
     * Contructor initiaizes variables
     * 
     * @param name
     * @param sampleText
     */
    public Article( String name, String sampleText )
    {
        this.name = name;
        this.sampleText = sampleText;
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
}
