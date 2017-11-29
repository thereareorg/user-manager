package com.jl.user_manager.session;
/**
 * 
 * @date 2017年11月8日 下午8:34:16
 * @author lin
 *
 */
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
  
public class SessionListener implements HttpSessionListener {  
    public  static SessionContext sessionContext=SessionContext.getInstance();  
   
    public void sessionCreated(HttpSessionEvent httpSessionEvent) { 
    	//System.out.println(httpSessionEvent.getSession().getId() + " session connect-------------------------------------------------------");
        //sessionContext.AddSession(httpSessionEvent.getSession());  
    }  
  
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {  
    	//System.out.println(httpSessionEvent.getSession() + "session disconnect....");
        sessionContext.DelSession(httpSessionEvent.getSession());  
    }  
}  