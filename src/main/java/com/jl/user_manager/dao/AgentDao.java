package com.jl.user_manager.dao;


import java.util.List;

import com.jl.user_manager.entity.Agent;


/**
 * 代理DAO接口
 * @date 2017年11月11日 下午3:29:06
 * @author lin
 *
 */
public interface AgentDao extends BaseDao<Agent> {
    public Agent findByAgentnameAndPassword(String username, String password);
    public Agent findOne(Integer aid);
    public boolean addAgent(Agent agent);
    public List<Agent> getAgents();
}
