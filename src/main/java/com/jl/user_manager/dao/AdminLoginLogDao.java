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
	/**
	 * 获取登录日志
	 * 
	 * @param uid
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<AdminLoginLog> getLoginLogsByPage(Integer uid, Integer page, Integer rows);
	
	/**
	 * 登录日志总条数
	 * 
	 * @param uid
	 * @return
	 */
	public Integer countLoginLog(Integer uid);
}
