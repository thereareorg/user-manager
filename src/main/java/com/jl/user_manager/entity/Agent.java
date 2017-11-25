package com.jl.user_manager.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 代理实体
 * @date 2017年11月11日 下午3:28:33
 * @author lin
 * 
 */

@Table(name = "agent")
@Entity
public class Agent {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer aid;
	private String username;
	private String password;
	private String name;
	private String phone;
	private String area;
	private String register_code;
	private Date create_time;

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getRegister_code() {
		return register_code;
	}

	public void setRegister_code(String register_code) {
		this.register_code = register_code;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

}
