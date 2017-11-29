package com.jl.user_manager.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jl.user_manager.dao.MemberDao;
import com.jl.user_manager.entity.Member;

/**
 * 会员DAO接口实现
 * 
 * @date 2017年11月25日 下午12:57:45
 * @author lin
 *
 */

@Repository("memberDao")
@SuppressWarnings("all")
public class MemberDaoImpl extends BaseDaoImpl<Member> implements MemberDao{

	@Override
	public List<Member> getMembers() {
		return find("from Member");
	}

	@Override
	public List<Member> getMembersByAgentID(Integer aid) {
		String hql = "from Member m where m.agent.aid = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, aid);
        List<Member> list = query.list();
        if (list != null && list.size() > 0) {
            return list;
        }
		return null;
	}

	@Override
	public List<Member> getMembersPageByAgentID(Integer aid, Integer page,
			Integer limit) {
		    String hql = "from Member m where m.agent.aid = ?";
	        Query query = this.getCurrentSession().createQuery(hql);
	        query.setParameter(0, aid);
	        List<Member> list = query.setFirstResult((page - 1) * limit).setMaxResults(limit).list();
	        if (list != null && list.size() > 0) {
	            return list;
	        }
		return null;
	}

	@Override
	public Integer countMembersByAgentID(Integer aid) {
		String hql = "select count(*) from Member m ";
        hql += "where m.agent.aid = ?";
        return count(hql, aid);
	}
	
}
