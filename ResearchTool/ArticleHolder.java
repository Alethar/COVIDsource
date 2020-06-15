import java.util.ArrayList;

public class ArticleHolder
{
    private ArrayList<Article> articles;
    public ArticleHolder() {
        articles = new ArrayList<Article>();
    } 
    
    public ArrayList<Article> getArticles(){
        return articles;
    }
    
    /**
     * 
     * DO NOT USE
     * @param article
     */
    public void addArticle(Article article) { //USE cloneArticle
    	articles.add(article);
    }
    public Article removeArticle(int index) {
        Article a = articles.remove( index );
        return a;
    }
}
