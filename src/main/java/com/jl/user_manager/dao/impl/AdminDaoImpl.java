package com.jl.user_manager.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jl.user_manager.dao.AdminDao;
import com.jl.user_manager.entity.Admin;

/**
 * 
 * @date 2017年11月10日 上午9:32:27
 * @author lin
 *
 */
@Repository("adminDao")
@SuppressWarnings("all")
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao{

    public Admin findByAdminnameAndPassword(String username, String password) {
        String hql = "from Admin a where a.username = ? and a.password = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, username);
        query.setParameter(1, password);
        return (Admin) query.uniqueResult();
    }

    public Admin findOne(Integer uid) {
        String hql = "from Admin where uid=?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, uid);
        return (Admin) query.uniqueResult();
    }
}
