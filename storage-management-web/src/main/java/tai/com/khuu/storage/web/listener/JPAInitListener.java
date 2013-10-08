package tai.com.khuu.storage.web.listener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JPAInitListener implements ServletContextListener {
    private static final Logger logger = LoggerFactory
            .getLogger(JPAInitListener.class.getClass());

    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    
    }

    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
     
    }

}
