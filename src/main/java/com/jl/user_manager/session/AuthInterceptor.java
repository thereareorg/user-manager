package com.jl.user_manager.session;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 拦截器  处理登录认证和重复登录
 * @date 2017年11月8日 下午8:55:15
 * @author lin
 *
 */  
@Component("SpringMVCInterceptor")  
public class AuthInterceptor extends HandlerInterceptorAdapter {      
      
    @Override  
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {  
        request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");   
        response.setContentType("text/html;charset=UTF-8");
   
        //过滤登录、退出访问  
        String[] noFilters = new String[] { "/admin/login", "/person/logout", "/agent/login"};  
        String uri = request.getRequestURI();  
        
        boolean beFilter = true;  
        for (String s : noFilters) {  
            if (uri.indexOf(s) != -1) {  
                beFilter = false;  
                break;  
            }  
        } 
        
        System.out.println("uri:" + uri + "beFilter:" + beFilter + "sessionid:" + request.getSession().getId());  
        String username = (String) request.getSession().getAttribute("username");  
        
        if (beFilter) {  //如果不是"/admin/login", "/person/logout"
            if (null == username) {  
                //ajax方式交互  
                if (request.getHeader("x-requested-with") != null  
                        && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest"))// 如果是ajax请求响应头会有，x-requested-with；  
                {                     
                    response.setHeader("sessionstatus", "timeout");// 在响应头设置session状态  
                    return false;  
                }  
                // 未登录  
                PrintWriter out = response.getWriter();  
                StringBuilder builder = new StringBuilder();  
                builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
                builder.append("alert(\"页面过期，请重新登录\");");
                builder.append("window.top.location.href='/user-manager';");
                builder.append("</script>");
                out.print(builder.toString());  
                out.close();  
                return false;  
            } else {                      
                // 添加系统日志  
                // -----------------------------------  
                // -----------------------------------  
            }  
        } else { //处理同浏览器重复登录
//        	if(null != username && SessionListener.sessionContext.getSession(username) == request.getSession()) {
//        		if (request.getHeader("x-requested-with") != null  
//                        && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest"))// 如果是ajax请求响应头会有，x-requested-with；  
//                {                     
//                    response.setHeader("sessionstatus", "timeout");// 在响应头设置session状态  
//                    return false;  
//                }  
//        		
//                PrintWriter out = response.getWriter();
//                StringBuilder builder = new StringBuilder();
//                builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
//                builder.append("alert(\"不要重复登录\");");  
//                builder.append("window.top.location.href='/JksScoreUpload';");
//                builder.append("</script>");
//                out.print(builder.toString());
//                out.close();  
//                return false;  
//        	}
        }
        
        //Map paramsMap = request.getParameterMap();  
        return super.preHandle(request, response, handler);  
    }  
}  
