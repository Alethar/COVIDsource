import java.util.ArrayList;

public class ArticleHolder
{
    private ArrayList<Article> articles;
    public ArticleHolder() {
        articles = new ArrayList<Article>();
    }
    
    public void cloneArticle(Article article) {
        if (article.getClass().getName().equals("Article")) {
        	articles.add(new Article(article));
        }
        else if (article.getClass().getName().equals("NewsArticle")) {
        	articles.add(new NewsArticle((NewsArticle) article));
        }
        else {
        	System.out.println("ERROR: FOREIGN ARTICLE TYPE");
        }
    }
    
    public ArrayList<Article> getArticles(){
        return articles;
    }
    
    public void addArticle(Article article) {
    	articles.add(article);
    }
}
