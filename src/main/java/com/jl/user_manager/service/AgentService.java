package com.jl.user_manager.service;

import java.util.List;

import com.jl.user_manager.entity.Admin;
import com.jl.user_manager.entity.Agent;
import com.jl.user_manager.entity.AgentLoginLog;
import com.jl.user_manager.entity.Member;

/**
 * 代理Service接口
 * @date 2017年11月11日 下午3:29:40
 * @author lin
 *
 */

public interface AgentService {
	/**
	 * 验证代理账号密码
	 * 
	 * @param user
	 * @return
	 */
	public Agent checkUser(Agent user);
	/**
	 * 保存登录日志
	 * 
	 * @param agent
	 * @param ip
	 */
	public void saveLoginLog(Agent agent, String ip);
	/**
	 * 查询本代理的所有会员
	 * 
	 * @param aid
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Member> getMyMembers(Integer aid, Integer page, Integer rows);
	/**
	 * 分页查询代理登录日志
	 * 
	 * @param aid
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<AgentLoginLog> getMyLoginLogsByPage(Integer aid, Integer page, Integer rows);
	/**
	 * 代理登录日志页数
	 * 
	 * @param aid
	 * @param rows
	 * @return
	 */
	public Integer countLoginLogPage(Integer aid, Integer rows);
	/**
	 * 本代理会员页数
	 * 
	 * @param aid
	 * @param rows
	 * @return
	 */
	public Integer countMemberPage(Integer aid, Integer rows);
}
