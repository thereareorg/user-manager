package com.jl.user_manager.dao;

import java.util.List;

import com.jl.user_manager.entity.Member;
/**
 * 会员DAO接口
 * 
 * @date 2017年11月25日 下午12:54:55
 * @author lin
 *
 */
public interface MemberDao extends BaseDao<Member> {
	/**
	 * 查询所有会员信息
	 * 
	 * @return
	 */
	public List<Member> getMembers();
	
	/**
	 * 根据代理ID查询会员信息
	 * 
	 * @param aid
	 * @return
	 */
	public List<Member> getMembersByAgentID(Integer aid);
	
	/**
	 * 根据代理ID分页查询会员信息
	 * 
	 * @param aid
	 * @param page
	 * @param limit
	 * @return
	 */
	public List<Member> getMembersPageByAgentID(Integer aid, Integer page, Integer limit);
	
	/**
	 * 根据代理ID查询会员总数目
	 * 
	 * @param aid
	 * @return
	 */
	public Integer countMembersByAgentID(Integer aid);
	
	/**
	 * 查询会员总数目
	 * 
	 * @return
	 */
	public Integer countMembers();
	
	/**
	 * 分页查询会员信息
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	public List<Member> getMembersPage(Integer page, Integer limit);
}
