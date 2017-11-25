package com.jl.user_manager.dao;

import com.jl.user_manager.entity.Admin;

/**
 * 管理员DAO接口
 * @date 2017年11月10日 上午9:24:21
 * @author lin
 *
 */

public interface AdminDao extends BaseDao<Admin> {
    public Admin findByAdminnameAndPassword(String username, String password);
    public Admin findOne(Integer aid);
}

