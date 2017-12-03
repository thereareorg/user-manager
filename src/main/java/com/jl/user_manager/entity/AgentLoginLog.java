package com.jl.user_manager.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AGENT登录记录
 * @date 2017年12月2日 下午3:47:38
 * @author lin
 *
 */

@Table(name = "agent_login_log")
@Entity
public class AgentLoginLog implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@JoinColumn(name = "aid")
    @ManyToOne
    private  Agent agent;
	@Id
	private Date login_time;
	private String ip;
	
	public Agent getAgent() {
		return agent;
	}
	
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	public Date getLogin_time() {
		return login_time;
	}
	
	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}
	
	public String getIp() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
}

