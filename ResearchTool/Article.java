
public class Article
{
    private String title;

    private String sampleText;

    private String url; // https://something/www.google.com/search/deunijf238udnblehhhhhhh+alltherestfthestuff

    /**
     * 
     */
    private String smallurl; // just www.google.com

    private String author;


    /**
     * Contructor initiaizes variables
     * 
     * @param title
     *            the title of the article
     * @param sampleText
     *            the sample text of the article
     * @param url
     *            the complete link to the article
     *            (https://something/www.google.com/search/deunijf238udnblehhhhhhh+alltherestfthestuff)
     * @param smallurl
     *            the link to the article's host (just www.google.com)
     * @param author
     *            the author/organization that wrote/hosted the article
     */
    public Article( String title, String sampleText, String url, String smallurl, String author )
    {
        this.title = title;
        this.sampleText = sampleText;
        this.url = url;
        this.smallurl = smallurl;
        this.author = author;
    }
    
    public Article(Article art) {
    	this.title = art.getName();
        this.sampleText = art.getSampleText();
        this.url = art.getURL();
        this.smallurl = art.getSmallURL();
        this.author = art.getAuthor();
    }


    /**
     * 
     * Accessor method for article title
     * 
     * @return
     */
    public String getName()
    {
        return title;
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

    /**
     * 
     * Accessor method for article smallurl
     * 
     * @return
     */
    public String getSmallURL()
    {
        return smallurl;
    }

    /**
     * 
     * Accessor method for article author
     * 
     * @return
     */
    public String getAuthor()
    {
        return author;
    }
}
