package com.jl.user_manager.service;

import com.jl.user_manager.entity.Agent;

/**
 * 代理Service接口
 * @date 2017年11月11日 下午3:29:40
 * @author lin
 *
 */

public interface AgentService {
	public Agent checkUser(Agent user);
	public void addUser(Agent user);
}
