package com.jl.user_manager.dao;

import com.jl.user_manager.entity.Admin;

/**
 * 管理员DAO接口
 * @date 2017年11月10日 上午9:24:21
 * @author lin
 *
 */

public interface AdminDao extends BaseDao<Admin> {
	/**
	 * 验证用户名密码
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
    public Admin findByAdminnameAndPassword(String username, String password);
    /**
     * 查询Admin
     * 
     * @param uid
     * @return
     */
    public Admin findOne(Integer uid);
}

