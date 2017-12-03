package com.jl.user_manager.dao;

import java.util.List;

import com.jl.user_manager.entity.Agent;
import com.jl.user_manager.entity.AgentLoginLog;


/**
 * 
 * @date 2017年12月2日 下午3:53:14
 * @author lin
 *
 */
public interface AgentLoginLogDao extends BaseDao<AgentLoginLog>{
	 public List<AgentLoginLog> getLoginLogsByPage(Integer aid, Integer page, Integer rows);
	 public Integer countLoginLog(Integer aid);
}
