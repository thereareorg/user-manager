package com.jl.user_manager.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jl.user_manager.dao.AgentDao;
import com.jl.user_manager.dao.MemberDao;
import com.jl.user_manager.entity.Agent;
import com.jl.user_manager.entity.Member;
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
	
	@Resource
	MemberDao memberDao;

	public Agent checkUser(Agent user) {
		return agentDao.findByAgentnameAndPassword(user.getUsername(), user.getPassword());
	}
	
	public void addUser(Agent user) {
		agentDao.save(user);
	}

	public List<Member> getMyMembers(Integer aid, Integer page, Integer rows) {
		return memberDao.getMembersPageByAgentID(aid, page, rows);
	}
	
	public Integer countMemberPage(Integer aid, Integer rows) {
		Integer count = memberDao.countMembersByAgentID(aid);
        return (count % rows == 0 ? (count / rows) : (count / rows + 1));
	}
	
}
