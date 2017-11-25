package com.jl.user_manager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jl.user_manager.dao.MemberDao;
import com.jl.user_manager.entity.Member;

/**
 * 会员DAO接口实现
 * @date 2017年11月25日 下午12:57:45
 * @author lin
 *
 */

@Repository("memberDao")
@SuppressWarnings("all")
public class MemberDaoImpl extends BaseDaoImpl<Member> implements MemberDao{

	@Override
	public List<Member> getMembers() {
		// TODO Auto-generated method stub
		return find("from Member");
	}
	
}
