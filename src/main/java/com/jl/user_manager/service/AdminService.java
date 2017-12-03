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
    // 根據用戶名和密碼查詢                                                                                                                                                                                                                                                                                           
    public Admin checkUser(Admin adminUser);
    public void saveLoginLog(Admin adminUser, String ip);
    public boolean addAgent(Agent agent);
    public List<Agent> getAgents();
    public List<Agent> getAgentsByPage(Integer page, Integer rows);
    public Integer countAgentPage(Integer rows);
    public List<Member> getMembersByPage(Integer page, Integer rows);
    public List<Member> getMembers();
    public Integer countMemberPage(Integer rows);
    
    public List<AdminLoginLog> getMyLoginLogsByPage(Integer uid, Integer page, Integer rows);
	public Integer countLoginLogPage(Integer uid, Integer rows);
}


