package com.jl.user_manager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 管理员体类
 * @date 2017年11月10日 上午9:26:39
 * @author lin
 *
 */
@Table(name = "adminuser")
@Entity
public class Admin {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer uid;
    private String username;
    private String password;
    
//    @OrderBy(value = "login_time")
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "admin")
//    private Set<AdminLoginLog> adminLoginLogs = new HashSet<AdminLoginLog>();

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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
}
