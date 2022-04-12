package de.freshminds.main;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import de.freshminds.backend.DatabaseMethods;
import de.freshminds.manager.ArticleManager;
import de.freshminds.manager.CategoryManager;

public class Core {
	
	public static SessionFactory freshMindsSessionFactory;
	public static SessionFactory freshmindsCategoriesSessionFactory;
	 
    protected void setup() {
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    	        .configure()
    	        .build();
    	try {
    		freshMindsSessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    		
    		Configuration cfg = new Configuration();
    		cfg.configure("categories.cfg.xml");
    		
    		freshmindsCategoriesSessionFactory = cfg.buildSessionFactory();
    		
    	} catch (Exception e) {
    	    StandardServiceRegistryBuilder.destroy(registry);
    	    throw new RuntimeException(e);
    	}
    }
 
    protected void exit() {
    	freshMindsSessionFactory.close();
    }
 
    public static void main(String[] args) {
        
    	hibernateMethods();

    }
    
    public static void hibernateMethods() {
    	
    	Core core = new Core();
    	core.setup();
    	  	
    	DatabaseMethods.fillArticlesTable();
    	DatabaseMethods.fillCategoriesTable();
    	
    	System.out.println(DatabaseMethods.getCategoryDesignationByArticleNumber(1005));
    	   	
    	core.exit();
    	
    }

}
