package de.freshminds.backend;

import org.hibernate.Session;

import de.freshminds.entities.Article;
import de.freshminds.entities.Category;
import de.freshminds.main.Core;

public class DatabaseMethods {
	
	
	
	
	
	public static String getCategoryDesignationByArticleNumber(int articleNumber) {
		
	    Session freshMindsSession = Core.freshMindsSessionFactory.openSession();
	    Article article = (Article) freshMindsSession.get(Article.class, articleNumber);
	    
	    Session freshMindsCategoriesSession = Core.freshmindsCategoriesSessionFactory.openSession();
	    Category category = (Category) freshMindsCategoriesSession.get(Category.class, article.getArticleCategory());
	    
	    return category.getCategoryDesignation();
	}

}
