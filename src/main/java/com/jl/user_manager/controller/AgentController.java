package com.jl.user_manager.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jl.user_manager.entity.Agent;
import com.jl.user_manager.service.AgentService;
import com.jl.user_manager.session.SessionContext;

/**
 * 
 * @date 2017年11月11日 下午3:29:25
 * @author lin
 *
 */

@Controller
@RequestMapping(value = "/agent")
public class AgentController {
	@Resource
    private AgentService agentService;
	
	/**
	 * 登录请求，失败返回error.jsp
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
	public String dologin(String username, String password, Map<String, Object> map, HttpSession session) {
		Agent agent = new Agent();
		agent.setUsername(username);
		agent.setPassword(password);
		if (agentService.checkUser(agent) != null) {
			session.setAttribute("username", username);
			map.put("username", username);//存放在request请求域中
			SessionContext.sessionHandlerByCacheMap(session, username);
			return "adminMain";
		} else {
		}
		return "error";
	}
}
