package com.jl.user_manager.service;

import java.util.List;

import com.jl.user_manager.entity.Agent;
import com.jl.user_manager.entity.Member;

/**
 * 代理Service接口
 * @date 2017年11月11日 下午3:29:40
 * @author lin
 *
 */

public interface AgentService {
	public Agent checkUser(Agent user);
	public void addUser(Agent user);
	public List<Member> getMyMembers(Integer aid, Integer page, Integer rows);
	public Integer countMemberPage(Integer aid, Integer rows);
}
