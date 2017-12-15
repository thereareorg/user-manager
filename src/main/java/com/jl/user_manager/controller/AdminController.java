package com.jl.user_manager.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jl.user_manager.entity.Admin;
import com.jl.user_manager.entity.AdminLoginLog;
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
			session.setAttribute("uid", admin.getUid());
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
			return "redirect:main";
		}
		return "error";
	}
	
	/**
	 * 管理员登录页面
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String getLoginPage() {
		return "admin/login";
	}
	
	/**
	 * 管理员主界面
	 * 
	 * @return
	 */
	@RequestMapping("/main")
	public String getMain() {
		return "admin/main";
	}
	
	@RequestMapping("/memberPage")
	public String getMemberPage(Map<String, Object> map) {
		List<Member> members = adminService.getMembers();
		map.put("members", members);
		return "memberPage";
	}
	
	/**
	 * 分页显示所有代理
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("/agentList/{page}")
	public ModelAndView getAgentList(@PathVariable("page") Integer page) {
		ModelAndView modelAndView = new ModelAndView("admin/agentList");;
		List<Agent> agents = adminService.getAgentsByPage(page, 4);
		if(agents == null) {
			System.out.println("暂无数据");
		} 
		modelAndView.addObject("agents", agents);
		modelAndView.addObject("page", page);
		Integer count = adminService.countAgentPage( 4);
        modelAndView.addObject("count", count);
		return modelAndView;
	}
	
	/**
	 * 分页显示所有会员
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("/memberList/{page}")
	public ModelAndView getMemberList(@PathVariable("page") Integer page) {
		ModelAndView modelAndView = new ModelAndView("admin/memberList");;
		List<Member> members = adminService.getMembersByPage(page, 4);
		if(members == null) {
			System.out.println("暂无数据");
		} 
		modelAndView.addObject("members", members);
		modelAndView.addObject("page", page);
		Integer count = adminService.countMemberPage( 4);
        modelAndView.addObject("count", count);
		return modelAndView;
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

		Integer size = adminService.countAgentPage(4);
		return "redirect:agentList/" + size;
	}
	
	/**
	 * 会员登录记录
	 * 
	 * @param map
	 * @param session
	 * @return
	 */
	@RequestMapping("/loginLogList/{page}")
	public ModelAndView loginLogList(@PathVariable("page") Integer page, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("agent/loginLogList");
		Integer uid = Integer.parseInt(session.getAttribute("uid").toString());
		System.out.println("uid:" + uid);
		List<AdminLoginLog> loginLogs = adminService.getMyLoginLogsByPage(uid, page, 4);
		if(loginLogs == null) {
			System.out.println("暂无数据");
		} 
		modelAndView.addObject("loginLogs", loginLogs);
		modelAndView.addObject("page", page);
		Integer count = adminService.countLoginLogPage(uid, 4);
        modelAndView.addObject("count", count);
		return modelAndView;
	}
}
