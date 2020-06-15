import java.util.ArrayList;

public class ArticleHolder
{
    private ArrayList<Article> articles;
    public ArticleHolder() {
        articles = new ArrayList<Article>();
    }
    public void addArticle(Article article) {
        articles.add( article.clone() );
    }
    public ArrayList<Article> getArticles(){
        return articles;
    }
}
