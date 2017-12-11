package neu.edu.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class DemoSessionListener
 * This is the lifecycle of the session
 */
@WebListener
public class DemoSessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public DemoSessionListener() {
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	
    	HttpSession session = se.getSession();   	
    	System.out.println("Session is Created" + session.getId());

    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("Session is Destroyed");
    	
    }
	
}
