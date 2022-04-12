package de.freshminds.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import de.freshminds.manager.ArticleManager;

public class Core {
	
	public static SessionFactory freshMindsSessionFactory;
	 
    protected void setup() {
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    	        .configure()
    	        .build();
    	try {
    		freshMindsSessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
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
    	
    	//ArticleManager.create(1, "Bananen", 1.50, "SPA", 1);
    	//ArticleManager.update(1, "Bananen", 1.60, "SPA", 1);
    	ArticleManager.delete(1);
    	
    	core.exit();
    	
    }

}
