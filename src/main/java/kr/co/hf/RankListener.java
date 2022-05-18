package kr.co.hf;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import kr.co.hf.service.RankUpdateService;

/**
 * Application Lifecycle Listener implementation class RankListener
 *
 */
@WebListener
public class RankListener implements ServletContextListener {
	
	private ScheduledExecutorService scheduler;

    /**
     * Default constructor. 
     */
    public RankListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        scheduler = Executors.newSingleThreadScheduledExecutor();
        //RankUpdateService rus = new RankUpdateService();
        scheduler.scheduleAtFixedRate(new Thread(new RankUpdateService()), 0, 15, TimeUnit.MINUTES);
    }
	
}
