package kr.co.hf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContext;
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
	
	//private HashMap<Integer,Integer> ranklist = null;
	//private ScheduledFuture<HashMap<Integer,Integer>> future = null;
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
    	scheduler.shutdown();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        scheduler = Executors.newScheduledThreadPool(1);
        //ScheduledFuture<HashMap<Integer,Integer>> future = scheduler.schedule(
        //        new RankUpdateService(), 5, TimeUnit.SECONDS);
        
        System.out.println("waga123");
        	
        //scheduler.scheduleAtFixedRate(, 0, 2, TimeUnit.MINUTES);
    	//RankUpdateService rus = new RankUpdateService();
    
    	RankUpdateService rus = new RankUpdateService();
		//System.out.println("Future.get method output: "+future.get());
		ServletContext context = sce.getServletContext();
		HashMap<Integer,Integer> ranklist = rus.run();
		Set<Integer> keySet = ranklist.keySet();
		List<Integer> listKeys
		= new ArrayList<Integer>(keySet);
		int rank1 = listKeys.get(0);
		int rank2 = listKeys.get(1);
		//int rank3 = listKeys.get(2);
		context.setAttribute("rank1", rank1);
		context.setAttribute("rank2", rank2);
		//context.setAttribute("rank3", rank3);
		//context.setAttribute("ranklist", future.get());

    	/*try {
	    	//HashMap<Integer,Integer> future = rus.call();
	    	System.out.println(future.get());
	    	System.out.println("waga123");
	    	ServletContext context = sce.getServletContext();
	        context.setAttribute("ranklist", future.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }
	
}
