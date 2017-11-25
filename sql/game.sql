/*
Navicat MySQL Data Transfer

Source Server         : new
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : pagination

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001
*/

CREATE TABLE `adminuser` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;

CREATE TABLE `agent` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,          /*地区*/
  `register_code` varchar(255) NOT NULL, /*注册码*/
  `create_time` datetime NOT NULL,        /*创建时间*/
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=20000 DEFAULT CHARSET=utf8;

CREATE TABLE `member` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL,
  `gold` int(11) NOT NULL,      /*金币*/
  `create_time` datetime NOT NULL,   /*创建时间*/
  `status` tinyint(4) DEFAULT 0,        /*状态：未激活，封号，正常*/
  `aid` int(11) NOT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=30000 DEFAULT CHARSET=utf8;

/*登录记录*/
CREATE TABLE `adminuser_login_log` (
  `uid` int(11) NOT NULL,
  `login_time` datetime NOT NULL,
  `ip` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `member_login_log` (
  `mid` int(11) NOT NULL,
  `login_time` datetime NOT NULL,
  `ip` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `agent_login_log` (
  `aid` int(11) NOT NULL,
  `login_time` datetime NOT NULL,
  `ip` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `member` 
  ADD FOREIGN KEY (`aid`) REFERENCES `agent` (`aid`);
  
ALTER TABLE `adminuser_login_log` 
  ADD FOREIGN KEY (`uid`) REFERENCES `adminuser` (`uid`);
  
ALTER TABLE `member_login_log` 
  ADD FOREIGN KEY (`mid`) REFERENCES `member` (`mid`);
  
ALTER TABLE `agent_login_log` 
  ADD FOREIGN KEY (`aid`) REFERENCES `agent` (`aid`);
  
ALTER TABLE `adminuser_login_log`
  ADD PRIMARY KEY (`uid`, `login_time`);  
  
ALTER TABLE `member_login_log`
  ADD PRIMARY KEY (`mid`, `login_time`);
  
ALTER TABLE `agent_login_log`
  ADD PRIMARY KEY (`aid`, `login_time`);
  
INSERT INTO `adminuser` (`username`, `password`) VALUES
('admin', 'admin');
  
INSERT INTO `agent` (`username`, `password`, `name`, `register_code`, `create_time`) VALUES
('lin1', '123456', 'hehe1', '123456', now()),
('lin2', '123456', 'hehe2', '123456', now()),
('lin3', '123456', 'hehe3', '123456', now()),
('lin4', '123456', 'hehe4', '123456', now()),
('lin5', '123456', 'hehe5', '123456', now());

INSERT INTO `member` (`username`, `password`, `gold`, `aid`, `create_time`) VALUES
('gu1', '123456', 10000, 20001, now()),
('gu2', '123456', 10000, 20001, now()),
('gu3', '123456', 10000, 20001, now()),
('gu4', '123456', 10000, 20001, now()),
('gu5', '123456', 10000, 20001, now()),
('gu6', '123456', 10000, 20001, now());
  

 

