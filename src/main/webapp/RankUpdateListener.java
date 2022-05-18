package kr.co.hf;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import kr.co.hf.service.IBoardService;

/**
 * Application Lifecycle Listener implementation class RankUpdateListener
 *
 */
@WebListener
public class RankUpdateListener implements ServletContextListener {
	
	private ScheduledExecutorService scheduler;

    /**
     * Default constructor. 
     */
    public RankUpdateListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	scheduler.shutdownNow();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	scheduler = Executors.newSingleThreadScheduledExecutor();
    	IBoardService sv = null;
        scheduler.scheduleAtFixedRate(new sv.rankUpdate(), 0, 15, TimeUnit.MINUTES);
    }
	
}
