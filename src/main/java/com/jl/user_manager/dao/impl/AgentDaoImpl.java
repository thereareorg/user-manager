package com.jl.user_manager.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jl.user_manager.dao.AgentDao;
import com.jl.user_manager.entity.Agent;

/**
 * 代理DAO接口实现
 * @date 2017年11月11日 下午3:28:50
 * @author lin
 *
 */
@Repository("agentDao")
@SuppressWarnings("all")
public class AgentDaoImpl extends BaseDaoImpl<Agent> implements AgentDao {

    public Agent findByAgentnameAndPassword(String username, String password) {
        String hql = "from Agent a where a.username = ? and a.password = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, username);
        query.setParameter(1, password);
        return (Agent) query.uniqueResult();
    }

    public Agent findOne(Integer uid) {
        String hql = "from Agent where uid=?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, uid);
        return (Agent) query.uniqueResult();
    }
    
    public Agent findOne(String username) {
        String hql = "from Agent where username=?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, username);
        return (Agent) query.uniqueResult();
    }
    
    public boolean addAgent(Agent agent) {
    	if(findOne(agent.getUsername()) != null) {
    		System.out.println("用户已经存在");
    		return false;
    	}
    	try{
			this.getCurrentSession().saveOrUpdate(agent);
			return true;
		}catch(HibernateException e){
			return false;
		}
    }
    
    public List<Agent> getAgents() {
    	return find("from Agent");
    }
}