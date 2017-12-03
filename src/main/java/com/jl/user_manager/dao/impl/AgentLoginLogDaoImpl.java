package com.jl.user_manager.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jl.user_manager.dao.AgentLoginLogDao;
import com.jl.user_manager.entity.Agent;
import com.jl.user_manager.entity.AgentLoginLog;
import com.jl.user_manager.entity.Member;

/**
 * 
 * @date 2017年12月2日 下午3:57:24
 * @author lin
 *
 */
@Repository("agentLoginLogDao")
@SuppressWarnings("all")
public class AgentLoginLogDaoImpl extends BaseDaoImpl<AgentLoginLog> implements AgentLoginLogDao{

	@Override
	public List<AgentLoginLog> getLoginLogsByPage(Integer aid, Integer page, Integer limit) {
		String hql = "from AgentLoginLog m where m.agent.aid = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, aid);
        List<AgentLoginLog> list = query.setFirstResult((page - 1) * limit).setMaxResults(limit).list();
        if (list != null && list.size() > 0) {
            return list;
        }
		return null;
	}

	@Override
	public Integer countLoginLog(Integer aid) {
		String hql = "select count(*) from AgentLoginLog m ";
        hql += "where m.agent.aid = ?";
        return count(hql, aid);
	}
	
}
