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
	/**
	 * 验证用户名密码
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
    public Agent findByAgentnameAndPassword(String username, String password);
    
    /**
     * 查询
     * 
     * @param aid
     * @return
     */
    public Agent findOne(Integer aid);
    
    /**
     * 新增代理
     * 
     * @param agent
     * @return
     */
    public boolean addAgent(Agent agent);
    
    /**
     * 查询所有代理
     * 
     * @return
     */
    public List<Agent> getAgents();
    
    /**
     * 分页查询代理
     * 
     * @param page
     * @param rows
     * @return
     */
    public List<Agent> getAgentsByPage(Integer page, Integer rows);
    
    /**
     * 所有代理数量
     * 
     * @return
     */
    public Integer countAgents();
}
