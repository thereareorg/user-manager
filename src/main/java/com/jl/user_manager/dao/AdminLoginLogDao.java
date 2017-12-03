package com.jl.user_manager.dao;

import java.util.List;

import com.jl.user_manager.entity.AdminLoginLog;

/**
 * ADMIN登录日志DAO接口
 * @date 2017年11月16日 上午11:34:48
 * @author lin
 *
 */
public interface AdminLoginLogDao extends BaseDao<AdminLoginLog>{
	public List<AdminLoginLog> getLoginLogsByPage(Integer uid, Integer page, Integer rows);
	 public Integer countLoginLog(Integer uid);
}
