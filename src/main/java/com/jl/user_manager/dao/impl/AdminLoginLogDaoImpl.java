package com.jl.user_manager.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jl.user_manager.dao.AdminLoginLogDao;
import com.jl.user_manager.entity.Admin;
import com.jl.user_manager.entity.AdminLoginLog;
import com.jl.user_manager.entity.AdminLoginLog;

/**
 * 
 * @date 2017年11月16日 上午11:34:26
 * @author lin
 *
 */

@Repository("adminLoginLogDao")
@SuppressWarnings("all")
public class AdminLoginLogDaoImpl extends BaseDaoImpl<AdminLoginLog> implements AdminLoginLogDao{

	@Override
	public List<AdminLoginLog> getLoginLogsByPage(Integer uid, Integer page,
			Integer limit) {
		String hql = "from AdminLoginLog m where m.admin.uid = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, uid);
        List<AdminLoginLog> list = query.setFirstResult((page - 1) * limit).setMaxResults(limit).list();
        if (list != null && list.size() > 0) {
            return list;
        }
		return null;
	}

	@Override
	public Integer countLoginLog(Integer uid) {
		String hql = "select count(*) from AdminLoginLog m ";
        hql += "where m.admin.uid = ?";
        return count(hql, uid);
	}
	
}
