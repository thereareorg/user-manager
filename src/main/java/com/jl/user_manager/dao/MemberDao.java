package com.jl.user_manager.dao;

import java.util.List;

import com.jl.user_manager.entity.Member;
/**
 * 会员DAO接口
 * @date 2017年11月25日 下午12:54:55
 * @author lin
 *
 */
public interface MemberDao extends BaseDao<Member> {
	public List<Member> getMembers();
	public List<Member> getMembersByAgentID(Integer aid);
	public List<Member> getMembersPageByAgentID(Integer aid, Integer page, Integer limit);
	public Integer      countMembersByAgentID(Integer aid);
	public Integer      countMembers();
	public List<Member> getMembersPage(Integer page, Integer limit);
}
