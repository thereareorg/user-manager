package com.jl.user_manager.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jl.user_manager.dao.AgentDao;
import com.jl.user_manager.entity.Agent;
import com.jl.user_manager.service.AgentService;

/**
 * 代理service实现
 * @date 2017年11月11日 下午3:30:25
 * @author lin
 *
 */

@Transactional
@Service("agentService")
public class AgentServiceImpl implements AgentService{
	@Resource
	AgentDao agentDao;

	public Agent checkUser(Agent user) {
		return agentDao.findByAgentnameAndPassword(user.getUsername(), user.getPassword());
	}
	
	public void addUser(Agent user) {
		agentDao.save(user);
	}
	
}
