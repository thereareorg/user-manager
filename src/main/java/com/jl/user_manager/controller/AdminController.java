package com.jl.user_manager.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jl.user_manager.entity.Admin;
import com.jl.user_manager.entity.Agent;
import com.jl.user_manager.entity.Member;
import com.jl.user_manager.service.AdminService;
import com.jl.user_manager.session.SessionContext;


/**
 * 
 * @date 2017年11月9日 上午9:48:23
 * @author lin
 *
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	@Resource
    private AdminService adminService;
	
	
	/**
	 * 登录请求，失败返回error.jsp
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
	public String dologin(String username, String password, Map<String, Object> map, HttpSession session, HttpServletRequest request) {
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		admin = adminService.checkUser(admin);
		if (admin != null) { //登录成功
			session.setAttribute("username", username);
			map.put("username", username);//存放在request请求域中
			SessionContext.sessionHandlerByCacheMap(session, username);//判断用户重复登录
			
			//获取IP
			String ip = "";
			do {
				ip = request.getHeader("X-Real-IP");
			    if (ip != null && !"unknown".equalsIgnoreCase(ip)) {
			        break;
			    }
			    ip = request.getHeader("X-Forwarded-For");
			    if (ip != null && !"unknown".equalsIgnoreCase(ip)) {
			        int index = ip.indexOf(",");
			        if (index != -1) {
			            ip = ip.substring(0, index);
			        } 
			        break;
			    } else {
			        ip =  request.getRemoteAddr();
			    }
			}while(false);
			
			if(ip == null) {
				ip = "";
			}
			
			adminService.saveLoginLog(admin, ip);
			return "main";
		}
		return "error";
	}
	
	@RequestMapping("/agentManager")
	public String getAgentPage(String username, String password, Map<String, Object> map, HttpSession session) {
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		
		if (adminService.checkUser(admin) != null) {
			session.setAttribute("username", username);
			map.put("username", username);//存放在request请求域中
			SessionContext.sessionHandlerByCacheMap(session, username);
			
			//返回代理列表
			
			return "adminMain";
		}
		return "error";
	}
	
	@RequestMapping("/memberPage")
	public String getMemberPage(Map<String, Object> map) {
		List<Member> members = adminService.getMembers();
		map.put("members", members);
		return "memberPage";
	}
	
	@RequestMapping("/adminMain")
	public String getAdminMain(Map<String, Object> map) {
		List<Agent> agents = adminService.getAgents();
		map.put("agents", agents);
		return "adminMain";
	}
	
	/**
	 * 添加代理账户
	 * @param agent
	 * @return
	 */
	@RequestMapping("/addAgent")
	public String addAgent(Map<String, Object> map, Agent agent) {
		agent.setCreate_time(new Date());
		if(adminService.addAgent(agent)) {
			System.out.println("Agent添加成功");
		} else {
			System.out.println("Agent添加失败");
		}
		List<Agent> agents = adminService.getAgents();
		map.put("agents", agents);
		return "adminMain";
	}
}
