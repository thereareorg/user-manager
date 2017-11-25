package com.jl.user_manager.dao.impl;

import org.springframework.stereotype.Repository;

import com.jl.user_manager.dao.AdminLoginLogDao;
import com.jl.user_manager.entity.Admin;
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
	
}
