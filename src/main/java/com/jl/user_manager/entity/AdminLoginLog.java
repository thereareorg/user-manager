package com.jl.user_manager.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * ADMIN登录记录
 * @date 2017年11月16日 上午11:17:19
 * @author lin
 *
 */

@Table(name = "adminuser_login_log")
@Entity
public class AdminLoginLog implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@JoinColumn(name = "uid")
    @ManyToOne
    private  Admin admin;
	@Id
	private Date login_time;
	private String ip;
	
	public Admin getAdmin() {
		return admin;
	}
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
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
