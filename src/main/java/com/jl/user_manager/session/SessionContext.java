package com.jl.user_manager.session;

import java.util.HashMap;

import javax.servlet.http.HttpSession;
  
/**
 * SessionContext
 * 
 * @date 2017年11月8日 下午7:30:20
 * @author lin
 *
 */
public class SessionContext {  
    private static SessionContext instance;  
    private HashMap<String,HttpSession> sessionMap;  
   
    private SessionContext() {  
        sessionMap = new HashMap<String,HttpSession>();  
    }  
  
    public static SessionContext getInstance() {  
        if (instance == null) {  
            instance = new SessionContext();  
        }  
        return instance;  
    }  
  
    public synchronized void AddSession(String userid, HttpSession session) {  
        if (userid != null && session != null) {  
            sessionMap.put(userid, session);  
        }  
    }  
  
    public synchronized void DelSession(HttpSession session) {  
        if (session != null) {  
            if(session.getAttribute("username")!=null){  
                sessionMap.remove(session.getAttribute("username").toString());
                System.out.println(session.getAttribute("username") + " disconnect....1");
            }  
        }  
    }  
    
    public synchronized void DelSession(String username) {  
    	 System.out.println(username + " disconnect....2");
          sessionMap.remove(username); 
    }  
  
    public synchronized HttpSession getSession(String userid) {  
        if (userid == null) return null;  
        return (HttpSession) sessionMap.get(userid);  
    }
    
    /**
     * 判断用户是否已经登录，踢掉之前登录的用户
     * @param session
     * @param username
     */
    public static void sessionHandlerByCacheMap(HttpSession session, String username){   
        if(getInstance().getSessionMap().get(username)!=null){  
            HttpSession userSession=(HttpSession)getInstance().getSessionMap().get(username); 
            if(userSession != session) {
	            //注销在线用户  
	            userSession.invalidate();
	            //getInstance().DelSession(username);
	            //清除在线用户后，更新map,替换map sessionid    
	            getInstance().AddSession(username, session);   
            }
        }  
        else  
        {   
            getInstance().AddSession(username, session);    
        }  
    }  
  
    public HashMap<String,HttpSession> getSessionMap() {
        return sessionMap;  
    }  
  
    public void setMymap(HashMap<String,HttpSession> sessionMap) {  
        this.sessionMap = sessionMap;  
    }  
  
}  
