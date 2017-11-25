package com.jl.user_manager.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jl.user_manager.dao.AdminDao;
import com.jl.user_manager.dao.AdminLoginLogDao;
import com.jl.user_manager.dao.AgentDao;
import com.jl.user_manager.dao.MemberDao;
import com.jl.user_manager.entity.Admin;
import com.jl.user_manager.entity.AdminLoginLog;
import com.jl.user_manager.entity.Agent;
import com.jl.user_manager.entity.Member;
import com.jl.user_manager.service.AdminService;

/**
 * 管理员Service实现
 * @date 2017年11月10日 上午9:39:40
 * @author lin
 *
 */

@Transactional
@Service("adminService")
public class AdminServiceImpl implements AdminService{
	@Resource
    private AdminDao adminDao;
	@Resource
	private AdminLoginLogDao adminLoginLogDao;
	@Resource
	private AgentDao agentDao;
	@Resource
	private MemberDao memberDao;

    /**
     * 根据用户和密码查询
     */
    public Admin checkUser(Admin adminUser) {
        return adminDao.findByAdminnameAndPassword(
                adminUser.getUsername(), adminUser.getPassword());
    }
    
    /**
     * 保存登录日志
     */
    public void saveLoginLog(Admin adminUser, String ip) {
    	AdminLoginLog adminLogin = new AdminLoginLog();
    	adminLogin.setAdmin(adminUser);
    	adminLogin.setIp(ip);
    	adminLogin.setLogin_time(new Date());
    	adminLoginLogDao.save(adminLogin);
    }
    
    /**
     * 添加代理
     */
    public boolean addAgent(Agent agent) {
    	return agentDao.addAgent(agent);
    }
    
    /**
     * 查询代理
     */
    public List<Agent> getAgents() {
    	return agentDao.getAgents();
    }
    
    /**
     * 查询会员
     */
    public List<Member> getMembers() {
    	return memberDao.getMembers();
    }
}

