/*
Navicat MySQL Data Transfer

Source Server         : new
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : game

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001
*/

DROP DATABASE game;
CREATE DATABASE game;
USE game;

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
  `area` varchar(255) DEFAULT NULL,          	/*地区*/
  `register_code` varchar(255) NOT NULL UNIQUE, /*注册码*/
  `server_ip`	varchar(255) NOT NULL,
  `server_port` int(11) NOT NULL,
  `status` tinyint(4) DEFAULT 0,        		/*状态：未激活，封号，正常*/
  `create_time` datetime default current_timestamp,        /*创建时间*/
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=20000 DEFAULT CHARSET=utf8;

CREATE TABLE `member` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL,
  `gold` int(11) NOT NULL,      /*金币*/
  `create_time` datetime default current_timestamp,   /*创建时间*/
  `status` tinyint(4) DEFAULT 0,        /*状态：未激活，封号，正常*/
  `aid` int(11) NOT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=30000 DEFAULT CHARSET=utf8;


CREATE TABLE `game` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `game_name` varchar(255) NOT NULL UNIQUE,
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=80000 DEFAULT CHARSET=utf8;

CREATE TABLE `server_game` (
  `sgid` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) NOT NULL,
  `gid` int(11) NOT NULL,
  PRIMARY KEY (`sgid`),
  CONSTRAINT UNIQUE agkey(`aid`, `gid`)
)ENGINE=InnoDB AUTO_INCREMENT=90000 DEFAULT CHARSET=utf8;

/*登录记录*/
CREATE TABLE `adminuser_login_log` (
  `uid` int(11) NOT NULL,
  `login_time` datetime default current_timestamp,
  `ip` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `member_login_log` (
  `mid` int(11) NOT NULL,
  `login_time` datetime default current_timestamp,
  `ip` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `agent_login_log` (
  `aid` int(11) NOT NULL,
  `login_time` datetime default current_timestamp,
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
  
ALTER TABLE `server_game` 
  ADD FOREIGN KEY (`aid`) REFERENCES `agent` (`aid`);
  
ALTER TABLE `server_game` 
  ADD FOREIGN KEY (`gid`) REFERENCES `game` (`gid`);
  
INSERT INTO `adminuser` (`username`, `password`) VALUES
('admin', 'admin');
  
INSERT INTO `agent` (`username`, `password`, `name`, `register_code`, `server_ip`, `server_port`) VALUES
('lin1', '123456', 'hehe1', '123456', '127.0.0.1', 8800),
('lin2', '123456', 'hehe2', '123457', '127.0.0.1', 8801),
('lin3', '123456', 'hehe3', '123458', '127.0.0.1', 8802),
('lin4', '123456', 'hehe4', '123459', '127.0.0.1', 8803),
('lin5', '123456', 'hehe5', '123460', '127.0.0.1', 8804);

INSERT INTO `member` (`username`, `password`, `gold`, `aid`) VALUES
('gu1', '123456', 10000, 20001),
('gu2', '123456', 10000, 20001),
('gu3', '123456', 10000, 20001),
('gu4', '123456', 10000, 20001),
('gu5', '123456', 10000, 20001),
('gu6', '123456', 10000, 20001);

INSERT INTO `game` (`game_name`) VALUES
('呵呵'),
('666');

INSERT INTO `server_game` (`gid`, `aid`) VALUES
('80000', 20001),
('80000', 20002);
  

 

