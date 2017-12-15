package com.jl.user_manager.service;
/**
 * 
 * @date 2017年11月10日 上午9:44:55
 * @author lin
 *
 */


import java.util.List;

import com.jl.user_manager.entity.Admin;
import com.jl.user_manager.entity.AdminLoginLog;
import com.jl.user_manager.entity.Agent;
import com.jl.user_manager.entity.Member;

/**
 * 管理员service接口
 * @date 2017年11月10日 上午9:39:40
 * @author lin
 *
 */

public interface  AdminService  {
    /**
     * 根据用户名密码查询
     *                                                                                                                                                                                                                                                                                      
     * @param adminUser
     * @return
     */
    public Admin checkUser(Admin adminUser);
    /**
     * 保存登录日志
     * 
     * @param adminUser
     * @param ip
     */
    public void saveLoginLog(Admin adminUser, String ip);
    /**
     * 新增代理
     * 
     * @param agent
     * @return
     */
    public boolean addAgent(Agent agent);
    /**
     * 查询代理
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
     * 查询代理总页数
     * 
     * @param rows
     * @return
     */
    public Integer countAgentPage(Integer rows);
    /**
     * 分页查询会员
     * 
     * @param page
     * @param rows
     * @return
     */
    public List<Member> getMembersByPage(Integer page, Integer rows);
    /**
     * 查询会员
     * 
     * @return
     */
    public List<Member> getMembers();
    /**
     * 查询会员总页数
     * 
     * @param rows
     * @return
     */
    public Integer countMemberPage(Integer rows);
    /**
     * 分页查询登录日志
     * 
     * @param uid
     * @param page
     * @param rows
     * @return
     */
    public List<AdminLoginLog> getMyLoginLogsByPage(Integer uid, Integer page, Integer rows);
    /**
     * 登录日志总页数
     * 
     * @param uid
     * @param rows
     * @return
     */
	public Integer countLoginLogPage(Integer uid, Integer rows);
}


