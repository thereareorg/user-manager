package com.jl.user_manager.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jl.user_manager.entity.Agent;
import com.jl.user_manager.entity.Member;
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
		agent = agentService.checkUser(agent);
		if (agentService.checkUser(agent) != null) {
			session.setAttribute("username", username);
			session.setAttribute("aid", agent.getAid()); //用于查询本代理的会员
			map.put("username", username);//存放在request请求域中
			SessionContext.sessionHandlerByCacheMap(session, username);
			return "agentMain";
		} 
		
		return "error";
	}
	
	
	/**
	 * 代理会员管理
	 * 
	 * @param map
	 * @param session
	 * @return
	 */
	@RequestMapping("/memberList/{page}")
	public ModelAndView memberList(@PathVariable("page") Integer page, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("agent/memberList");
		Integer aid = Integer.parseInt(session.getAttribute("aid").toString());
		List<Member> members = agentService.getMyMembers(aid, page, 4);
		if(members == null) {
			System.out.println("暂无数据");
		} 
		modelAndView.addObject("members", members);
		modelAndView.addObject("page", page);
		Integer count = agentService.countMemberPage(aid, 4);
        modelAndView.addObject("count", count);
		return modelAndView;
	}
	
}
