import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Searcher
{
    private final String GOOGLE_SEARCH_URL = "https://www.google.com/search?q=";

    // http://www.google.com/search?q=abc+def searches for "abc def"
    private GUI gui;

    private ArrayList<Article> articles;

    //private String[] newsNames = { "a", "b", "c" };

    private String[] newsURLs = { "www.achnews.org", "www.reddit.com", "www.bing.com" };

    private int[] newsCred = { 4, 5, 4 }; //0 to 5, 0 is not credible and 5 is credible

    private int[] newsBias = { 4, 5, 4 }; //0 to 6, 0 is left and 6 is right


    public Searcher()
    {
        // does absolutely fin nothing
        // Not anymore
        articles = new ArrayList<>();
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
    public Object getSources( ArrayList<String> searchTerms, int amount )
    {
        String searchURL = GOOGLE_SEARCH_URL;
        for ( int i = 0; i < searchTerms.size(); i++ )
        {
            searchURL += searchTerms.get( i );
            if ( i != searchTerms.size() )
            {
                searchURL += "+";
            }
        }
        searchURL += "&nums=";
        searchURL += ( "" + amount );
        try
        {
            Document webpage = Jsoup.connect( searchURL ).userAgent( "Mozilla/5.0" ).get();
            Elements results = webpage.select( "a.BVG0Nb" );
            for ( Element result : results )
            {
                String author;
                String linkHref;
                String title;
                /**
                 * if link does not meet standard format, we assume it is not a
                 * normal link (like a twitter link or suggestion/advertisement
                 * from google) and skip it
                 */
                try
                {
                    linkHref = result.attr( "href" );
                    String linkText = result.text();
                    author = result.select( "div.BNeawe.tAd8D.AP7Wnd" ).first().text();

                    //PrintWriter out = new PrintWriter(
                    //    new BufferedWriter( new FileWriter( "test.out" ) ) );
                    //out.print( result.toString() );
                    //out.println();
                    //out.close();
                    title = result.select( "span" ).first().text();

                }
                catch ( NullPointerException noooo )
                {
                    continue;
                }
                String link = linkHref.substring( 6, linkHref.indexOf( "&" ) );
                String smalllink = link.split( "/" )[2];
                int newsID = isNews( smalllink );
                if ( newsID != -1 )
                { // news article
                    articles.add( new NewsArticle( title,
                        ""/* @TODO subtext */,
                        link,
                        smalllink,
                        author,
                        newsCred[newsID],
                        newsBias[newsID] ) );
                }
                else
                { // general article
                    System.out.println( "Title: " + title );
                    System.out.println( "link: " + link );
                    System.out.println( "smalllink: " + smalllink );
                    System.out.println( "author: " + author );

                    Article newArticle = new Article( title,
                        ""/* @TODO subtext */,
                        link,
                        smalllink,
                        author );
                    articles.add( newArticle );
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
     * returns amount of articles
     * 
     * @return
     */
    public int getArticleNum()
    {
        return articles.size();
    }


    /**
     * 
     * checks the article link to see if the news name is included
     * 
     * @param url
     * @return
     */
    private int isNews( String url )
    {
        // url = url.split( "." )[1];
        for ( int i = 0; i < newsURLs.length; i++ )
        {
            if ( url.contains( newsURLs[i] ) )
            {
                return i;
            }
        }

        return -1;
    }
}
