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

    // private String[] newsNames = { "a", "b", "c" };

    private String[] newsURLs = {};

    private int[] newsCred = {}; // 0 to 5, 0 is not
                                 // credible and 5 is
                                 // credible

    private double[] newsBias = {}; // 0 to 6,
                                    // 0 is
                                    // left and
                                    // 6 is
                                    // right


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
            if ( i != searchTerms.size() - 1 )
            {
                searchURL += "+";
            }
        }
        searchURL += "&num=";
        searchURL += ( "" + amount );
        try
        {
            Document webpage = Jsoup.connect( searchURL ).userAgent( "Mozilla/5.0" ).get();

            Elements results = webpage.select( "a.BVG0Nb" );
            System.out.println( "Size: " + results.size() );

            results.addAll( webpage.select( "div.ZINbbc.xpd.O9g5cc.uUPGi" ) );
            Elements results2 = webpage.select( "div[class=ZINbbc.xpd.O9g5cc.uUPGi]" );
            // ZINbbc xpd O9g5cc uUPGi

            System.out.println( "Size: " + results2.size() );

            // System.out.println("second results length: " + results.size());
            PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter( "test.out" ) ) );
            out.print( webpage.toString() );
            out.println();
            out.close();
            for ( Element result : results )
            {
                System.out.println( result.toString() );
                String author;
                String linkHref;
                String title;
                /**
                 * if link does not meet standard format, we assume it is not a
                 * normal link (like a twitter link or suggestion/advertisement
                 * from google) and skip it
                 */

                if ( result.hasAttr( "href" ) )
                {
                    linkHref = result.attr( "href" );
                }
                else
                {
                    System.out.println( "triggered" );
                    linkHref = result.select( "a" ).first().attr( "href" );
                    System.out.println( linkHref );
                }
                // if(result.select("span") == null ||
                // result.select("span").first() == null ){
                
                // title = result.select( "span" ).first().text();
                /*Elements my_r = result.select( "span" );
                if ( my_r.size() == 0 )
                {
                    my_r = result.select( "div.BNeawe.vvjwJb.AP7Wnd" );
                    if ( my_r.size() == 0 )
                    {
                        // System.out.println("Allequal0");
                        // System.out.println(result.toString());
                        continue;
                    }
                }*/
                Elements my_r = result.select( "div.BNeawe.vvjwJb.AP7Wnd" );
                if ( my_r.size() == 0 )
                {
                    my_r = result.select( "span" );
                    if ( my_r.size() == 0 )
                    {
                        // System.out.println("Allequal0");
                        // System.out.println(result.toString());
                        continue;
                    }
                }
                title = my_r.first().text();

                System.out.println( "middle" );
                try
                {
                    if ( result.select( "div.BNeawe.tAd8D.AP7Wnd" ).size() != 0 )
                    {
                        author = result.select( "div.BNeawe.tAd8D.AP7Wnd" ).first().text();
                    }
                    else
                    {
                        author = result.select( "div.BNeawe.UPmit.AP7Wnd" ).first().text();
                    }
                    System.out.println( "after" );

                    // PrintWriter out = new PrintWriter(
                    // new BufferedWriter( new FileWriter( "test.out" ) ) );
                    // out.print( result.toString() );
                    // out.println();
                    // out.close();

                }
                catch ( NullPointerException noooo )
                {

                    System.out.println( "skipped" );

                    continue;
                }
                System.out.println( result.toString() );
                System.out.println( linkHref );
                System.out.println( searchURL );

                String link = linkHref.substring( 6, linkHref.indexOf( "&" ) );
                String smalllink = link.split( "/" )[2];
                int newsID = isNews( smalllink );
                if ( newsID != -1 )
                { // news article
                    articles.add( new NewsArticle( title,
                        ""/* @TODO subtext */,
                        link.substring( 1 ),
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
                        link.substring( 1 ),
                        smalllink,
                        author );
                    articles.add( newArticle );
                }
                // System.out.println( "Text::" + linkText + ", URL::" + link);
            }
            System.out.println( webpage.select( "div[class=kCrYT]" ).size() );
        }
        catch ( Exception e )
        {
            System.out.println( "LARGE ERROR" );
            return e;
        }
        System.out.println( searchURL );
        System.out.println( articles.size() );
        return null;
        // String searchURL = GOOGLE_SEARCH_URL + "?q="+searchTerm+"&num="+num;
        // without proper User-Agent, we will get 403 error
        // Document doc =
        // Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();
    }


    /**
     * Clears source cache
     */
    public void clearSources()
    {
        System.out.println( "Sources cleared" );
        articles = new ArrayList<>();
    }


    /**
     * 3 Returns an article from articles. If article num exceeds the length of
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


    /**
     * Code ripped from
     * https://mkyong.com/java/open-browser-in-java-windows-or-linux/
     * 
     * @param url:
     *            url of the tab to open
     */
    static public void openBrowserTab( String url )
    {
        String os = System.getProperty( "os.name" ).toLowerCase();
        Runtime rt = Runtime.getRuntime();

        String urlTrimmed = url.substring( 1 );

        try
        {
            if ( os.indexOf( "win" ) >= 0 )
            {

                // Doesn't support urls like page.html#nameLink, maybe just
                // delete those?
                rt.exec( "rundll32 url.dll,FileProtocolHandler " + urlTrimmed );
            }
            else if ( os.indexOf( "mac" ) >= 0 )
            {
                rt.exec( "open " + urlTrimmed );
            }
            else if ( os.indexOf( "nix" ) >= 0 || os.indexOf( "nux" ) >= 0 )
            {
                // Best guess for unix platforms, when it comes to browsers
                String[] browsers = { "epiphany", "firefox", "mozilla", "konqueror", "netscape",
                    "opera", "links", "lynx" };

                // Build a command
                StringBuffer cmd = new StringBuffer();
                for ( int i = 0; i < browsers.length; i++ )
                    cmd.append(
                        ( i == 0 ? "" : " || " ) + browsers[i] + " \"" + urlTrimmed + "\" " );

                rt.exec( new String[] { "sh", "-c", cmd.toString() } );
            }
            else
            {
                System.out.println( "Something is horribly borked" );
                return;
            }
        }
        catch ( Exception e )
        {
            System.out.println( "bork" );
            return;
        }
    }
}
