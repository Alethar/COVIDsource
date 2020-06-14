
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Searcher
{
	public static Searcher main;
	
    private static final String GOOGLE_SEARCH_URL = "https://www.google.com/search?q=";

    // http://www.google.com/search?q=abc+def searches for "abc def"
    private GUI gui;

    private ArrayList<Article> articles;

    private String[] newsNames = { "a", "b", "c" };

    private double[] newsCred = { 4.5, 5, 4 };

    private double[] newsBias = { 4.5, 5, 4 };


    public Searcher()
    {
        // does absolutely fin nothing
    	// Not anymoree
    	if (main == null) main=this;
		else {
			System.out.println("ERROR: SEARCHER SINGLETON BREACHED");
		}
    }


    public void setGUI( GUI gui )
    {
        this.gui = gui;
    }


    /**
     * 
     * Gets the required amount of sources and loads info into class variable
     * 
     * @param amount
     *            of sources you want
     * @return null if no error, IOException if error (likely internet
     *         connection)
     * @TODO change the subtext input for the articles.add
     */
    public Object getSources( String searchterm, int amount )
    {
        String[] searchTerms = searchterm.split( " " );
        String searchURL = GOOGLE_SEARCH_URL;
        for ( int i = 0; i < searchTerms.length; i++ )
        {
            searchURL += searchTerms[i];
            if ( i != searchTerms.length )
            {
                searchURL += "+";
            }
        }
        searchURL += "&nums=";
        searchURL += ( "" + amount );
        try
        {
            Document webpage = Jsoup.connect( searchURL ).userAgent( "Mozilla/5.0" ).get();
            Elements results = webpage.select( "h3.r > a" );
            for ( Element result : results )
            {
                String linkHref = result.attr( "href" );
                String linkText = result.text();
                String link = linkHref.substring( 6, linkHref.indexOf( "&" ) );
                int newsID = isNews( link );
                if ( newsID != -1 )
                { // news article
                    articles.add( new NewsArticle( newsNames[newsID],
                        ""/* @TODO */,
                        link,
                        newsCred[newsID],
                        newsBias[newsID] ) );
                }
                else
                { // general article
                    articles
                        .add( new Article( link.split( "/" )[2], ""/* @TODO */, link ) );
                }
                // System.out.println( "Text::" + linkText + ", URL::" + link);
            }
        }
        catch ( IOException e )
        {
            System.out.println( e );
            return e;
        }

        return null;
        // String searchURL = GOOGLE_SEARCH_URL + "?q="+searchTerm+"&num="+num;
        // without proper User-Agent, we will get 403 error
        // Document doc =
        // Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();
    }


    /**
     * 
     * Returns an article from articles. If article num exceeds the length of
     * the list, null is returned
     * 
     * @param articleNum
     * @return
     */
    public Article getArticle( int articleNum )
    {
        if ( articleNum >= articles.size() )
        {
            return null;
        }
        return articles.get( articleNum );
    }


    /**
     * 
     * checks the article link to see if the news name is included
     * @param url
     * @return
     */
    private int isNews(String url) {
        url = url.split( "." )[1];
        for()
        
        return -1;
    }
}
