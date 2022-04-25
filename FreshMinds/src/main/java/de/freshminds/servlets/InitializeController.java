package de.freshminds.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import de.freshminds.main.Core;

@WebListener
public class InitializeController implements ServletContextListener {
	
	public final void contextInitialized(final ServletContextEvent sce) {
		Core.setup();
    }

    public final void contextDestroyed(final ServletContextEvent sce) {
    	System.out.println("Ende");

    }

}
