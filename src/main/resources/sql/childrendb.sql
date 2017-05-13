-- 数据库初始化

CREATE DATABASE childrendb;

-- 留守儿童点表
CREATE TABLE `point` (
  `uid` varchar(255) NOT NULL COMMENT '点uid主键',
  `title` varchar(255) NOT NULL COMMENT '留守儿童点的名称',
  `address` varchar(255) NOT NULL COMMENT '地址',
  `lat` varchar(255) NOT NULL COMMENT '纬度',
  `lng` varchar(255) NOT NULL COMMENT '经度',
  `city` varchar(120) NOT NULL COMMENT '该点所属城市',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '留守儿童点表' ;

-- 留守儿童服务点责任人表
CREATE TABLE `owner` (
  `id` VARCHAR(20) NOT NULL,
  `name` varchar(120) NOT NULL,
  `phone` bigint(20) NOT NULL,
  `gender` tinyint(4) NOT NULL DEFAULT '0' COMMENT '性别：0-女，1-男',
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '留守儿童服务点责任人表';

-- 志愿者表
CREATE TABLE `volunteer` (
  `id` varchar(20) NOT NULL COMMENT '身份证号',
  `name` varchar(255) NOT NULL,
  `gender` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0-女 1-男',
  `address` varchar(255) NOT NULL,
  `phone` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '志愿者表';

-- 申请/认领留守儿童点
CREATE TABLE `point_apply` (
  `point_uid` varchar(255) NOT NULL COMMENT '留守儿童点uid',
  `owner_id` varchar(255) NOT NULL COMMENT '责任人身份标识',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
  `state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '审核状态：0正在审核，1通过审核，-1审核不通过',
  `detail` varchar(255) NOT NULL COMMENT '审核说明',
  `detail_img` varchar(255) NOT NULL COMMENT '审核上传图片',
  PRIMARY KEY (`point_uid`,`owner_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '申请/认领留守儿童点';

-- 临时点表
CREATE TABLE `point_temp` (
  `uid` varchar(255) NOT NULL COMMENT '点uid主键',
  `title` varchar(255) NOT NULL COMMENT '留守儿童点的名称',
  `address` varchar(255) NOT NULL COMMENT '地址',
  `lat` varchar(255) NOT NULL COMMENT '纬度',
  `lng` varchar(255) NOT NULL COMMENT '经度',
  `city` varchar(120) NOT NULL COMMENT '该点所属城市',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '临时点表' ;
