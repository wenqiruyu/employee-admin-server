DROP TABLE IF EXISTS `employee_staff_base_t`;
CREATE TABLE `employee_staff_base_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `emp_id` varchar(255) DEFAULT NULL COMMENT '员工号',
  `emp_name` varchar(255) DEFAULT NULL COMMENT '员工名',
  `participate_time` varchar(12) DEFAULT NULL COMMENT '入职时间',
  `leave_time` varchar(12) DEFAULT NULL COMMENT '离职时间',
  `leave_reason` varchar(1024) DEFAULT NULL COMMENT '离职原因',
  `delete_flag` tinyint(1) DEFAULT '0' COMMENT '信息状态，是否在职 0在职 1离职',
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '创建者，记录创建者信息',
  `last_update_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '修改者，记录修改者信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='企业员工基本信息表';

DROP TABLE IF EXISTS `employee_staff_detail_t`;
CREATE TABLE `employee_staff_detail_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id 用于后台系统',
  `username` varchar(255) DEFAULT NULL COMMENT '昵称',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `sex` tinyint(1) DEFAULT '2' COMMENT '性别 1男 0女 保密',
  `phone` char(11) DEFAULT NULL COMMENT '手机号码',
  `telephone` varchar(16) DEFAULT NULL COMMENT '住宅电话',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `id_card` varchar(64) DEFAULT NULL COMMENT '身份证号',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `province` varchar(64) DEFAULT NULL COMMENT '省',
  `city` varchar(64) DEFAULT NULL COMMENT '市',
  `county` varchar(64) DEFAULT NULL COMMENT '区',
  `address` varchar(64) DEFAULT NULL COMMENT '联系地址 户籍',
  `current_address` varchar(64) DEFAULT NULL COMMENT '现居住地址',
  `politics` varchar(64) DEFAULT NULL COMMENT '党派 无党派民主人士 中共党员 民革党员 民盟党员 农工党员 群众',
  `national` varchar(64) DEFAULT NULL COMMENT '所属民族',
  `marriage` varchar(64) DEFAULT NULL COMMENT '婚姻状态 未婚 已婚 丧偶 其他',
  `education` varchar(64) DEFAULT NULL COMMENT '学历 小学 初中 高中 本科 研究生 博士',
  `userface` varchar(255) DEFAULT NULL COMMENT '头像',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `delete_flag` tinyint(1) DEFAULT '0' COMMENT '是否有效 0有效 1删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '创建者，记录创建者信息',
  `last_update_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '修改者，记录修改者信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='企业员工详细信息表';

DROP TABLE IF EXISTS `employee_role_t`;
CREATE TABLE `employee_role_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` varchar(64) DEFAULT NULL COMMENT '角色id',
  `role_name_en` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `role_name_zh` varchar(64) DEFAULT NULL COMMENT '角色名称 中文',
  `delete_flag` tinyint(1) DEFAULT '0' COMMENT '是否有效 0有效 1删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '创建者，记录创建者信息',
  `last_update_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '修改者，记录修改者信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='企业员工角色配置表';

INSERT INTO `employee_role_t` VALUES (100, 'ROLE001', 'superAdmin', '超级管理员', 0, '2019-12-25 23:49:33', NULL, 'admin', 'admin');
INSERT INTO `employee_role_t` VALUES (101, 'ROLE002', 'admin', '普通管理员', 0, '2019-12-25 23:49:59', NULL, 'admin', 'admin');
INSERT INTO `employee_role_t` VALUES (102, 'ROLE003', 'employee', '企业员工', 0, '2019-12-25 23:50:25', NULL, 'admin', 'admin');

DROP TABLE IF EXISTS `employee_staff_role_t`;
CREATE TABLE `employee_staff_role_t` (
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户表id',
  `role_id` varchar(64) DEFAULT NULL COMMENT '角色表id',
  `delete_flag` tinyint(1) DEFAULT '0' COMMENT '是否有效 0有效 1删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业员工用户角色映射表';

DROP TABLE IF EXISTS `employee_dept_t`;
CREATE TABLE `employee_dept_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `dept_id` varchar(64) DEFAULT NULL COMMENT '部门id',
  `dept_name` varchar(64) DEFAULT NULL COMMENT '部门名称',
  `dept_description` varchar(64) DEFAULT NULL COMMENT '部门简介',
  `principal_emp_id` varchar(64) DEFAULT NULL COMMENT '部门负责人,empId',
  `principal_name` varchar(64) DEFAULT NULL COMMENT '部门负责人',
  `delete_flag` tinyint(1) DEFAULT '0' COMMENT '是否有效 0有效 1删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '创建者，记录创建者信息',
  `last_update_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '修改者，记录修改者信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='企业员工部门配置表';
INSERT INTO `employee_dept_t`( `dept_id`, `dept_name`, `dept_description`, `principal_emp_id`, `principal_name`, `delete_flag`, `create_time`)
VALUES ('DEPT001', '财务部', '根据公司资金运作情况，合理调配资金，确保公司资金正常运转', NULL, NULL, 0, '2020-01-06 22:11:06');
INSERT INTO `employee_dept_t`( `dept_id`, `dept_name`, `dept_description`, `principal_emp_id`, `principal_name`, `delete_flag`, `create_time`)
VALUES ('DEPT002', '信息科技部', '信息科技部是公司的核心部门，肩负着研制、开发新产品，完善产品功能的任务', NULL, NULL, 0, '2020-01-06 22:11:06');
INSERT INTO `employee_dept_t`( `dept_id`, `dept_name`, `dept_description`, `principal_emp_id`, `principal_name`, `delete_flag`, `create_time`)
VALUES ('DEPT003', '产品设计部', '负责公司策划设计制作、公司展览会议布置', NULL, NULL, 0, '2020-01-06 22:11:06');
INSERT INTO `employee_dept_t`( `dept_id`, `dept_name`, `dept_description`, `principal_emp_id`, `principal_name`, `delete_flag`, `create_time`)
VALUES ('DEPT004', '行政部', '公司行政部门广义上包括行政事务、办公事务、人力资源、财产会计四个方面', NULL, NULL, 0, '2020-01-06 22:11:06');
INSERT INTO `employee_dept_t`( `dept_id`, `dept_name`, `dept_description`, `principal_emp_id`, `principal_name`, `delete_flag`, `create_time`)
VALUES ('DEPT005', '人事部', '负责制定公司人事管理制度，实施并提出合理化意见和建议', NULL, NULL, 0, '2020-01-06 22:11:06');
INSERT INTO `employee_dept_t`( `dept_id`, `dept_name`, `dept_description`, `principal_emp_id`, `principal_name`, `delete_flag`, `create_time`)
VALUES ('DEPT006', '采购部', '直接对分管领导、公司负责，全面主持采购部工作，确保各项任务的顺利完成', NULL, NULL, 0, '2020-01-06 22:11:06');
INSERT INTO `employee_dept_t`( `dept_id`, `dept_name`, `dept_description`, `principal_emp_id`, `principal_name`, `delete_flag`, `create_time`)
VALUES ('DEPT007', '数据分析部', '做出科学、合理的分析、以便正确决策', NULL, NULL, 0, '2020-01-06 22:11:06');
INSERT INTO `employee_dept_t`( `dept_id`, `dept_name`, `dept_description`, `principal_emp_id`, `principal_name`, `delete_flag`, `create_time`)
VALUES ('DEPT008', '软件测试部', '负责以解决客户业务测试问题为目的的测试解决方案架构和研发工作', NULL, NULL, 0, '2020-01-06 22:11:06');
INSERT INTO `employee_dept_t`( `dept_id`, `dept_name`, `dept_description`, `principal_emp_id`, `principal_name`, `delete_flag`, `create_time`)
VALUES ('DEPT009', '前台接待部', '负责公司前台接待工作、公司电话接转、收发传真、文档复印等工作', NULL, NULL, 0, '2020-01-06 22:11:06');
INSERT INTO `employee_dept_t`( `dept_id`, `dept_name`, `dept_description`, `principal_emp_id`, `principal_name`, `delete_flag`, `create_time`)
VALUES ('DEPT010', '产品运营部', '收集经营信息，掌握市场动态，深入调查研究，为集团决策提供依据', NULL, NULL, 0, '2020-01-06 22:11:06');
INSERT INTO `employee_dept_t`( `dept_id`, `dept_name`, `dept_description`, `principal_emp_id`, `principal_name`, `delete_flag`, `create_time`)
VALUES ('DEPT011', '市场部', '解决市场对企业产品的需求问题', NULL, NULL, 0, '2020-01-06 22:11:06');
INSERT INTO `employee_dept_t`( `dept_id`, `dept_name`, `dept_description`, `principal_emp_id`, `principal_name`, `delete_flag`, `create_time`)
VALUES ('DEPT012', '公关部', '建立与维护公司与社区、公众媒介、行业协会、政府部门的公众关系', NULL, NULL, 0, '2020-01-06 22:11:06');

DROP TABLE IF EXISTS `employee_staff_dept_t`;
CREATE TABLE `employee_staff_dept_t` (
  `emp_id` varchar(64) DEFAULT NULL COMMENT '员工号',
  `emp_position` varchar(64) DEFAULT NULL COMMENT '员工职位',
  `super_emp_id` varchar(64) DEFAULT NULL COMMENT '员工上级',
  `dept_id` varchar(64) DEFAULT NULL COMMENT '部门id',
  `delete_flag` tinyint(1) DEFAULT '0' COMMENT '是否有效 0有效 1删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业员工用户部门映射表';

DROP TABLE IF EXISTS `employee_position_t`;
CREATE TABLE `employee_position_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `dept_id` varchar(64) DEFAULT NULL COMMENT '部门id',
  `position_name` varchar(128) DEFAULT NULL COMMENT '职位名称',
  `position_desc` varchar(1024) DEFAULT NULL COMMENT '职位简介',
  `delete_flag` tinyint(1) DEFAULT '0' COMMENT '是否有效 0有效 1删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '创建者，记录创建者信息',
  `last_update_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '修改者，记录修改者信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='企业员工职位配置表';
INSERT INTO `db_employee_information`.`employee_position_t`(`dept_id`, `position_name`, `position_desc`, `delete_flag`, `create_time`)
VALUES ('DEPT002', '软件工程师', '软件工程师是最基本的IT软件职位，但是他做的是最重要的底层的代码编写', 0, '2020-01-12 21:39:06');
INSERT INTO `db_employee_information`.`employee_position_t`(`dept_id`, `position_name`, `position_desc`, `delete_flag`, `create_time`)
VALUES ('DEPT002', '软件设计师', '软件设计师以前称呼为软件高级工程师', 0, '2020-01-12 21:39:06');
INSERT INTO `db_employee_information`.`employee_position_t`(`dept_id`, `position_name`, `position_desc`, `delete_flag`, `create_time`)
VALUES ('DEPT002', '架构师', '架构师主要负责系统底层的分层分类，以及系统的众多接口问题', 0, '2020-01-12 21:39:06');
INSERT INTO `db_employee_information`.`employee_position_t`(`dept_id`, `position_name`, `position_desc`, `delete_flag`, `create_time`)
VALUES ('DEPT002', '技术经理', '技术经理主要负责项目的各层次的方方面面', 0, '2020-01-12 21:39:06');
INSERT INTO `db_employee_information`.`employee_position_t`(`dept_id`, `position_name`, `position_desc`, `delete_flag`, `create_time`)
VALUES ('DEPT002', '技术总监', '制定公司的技术体系，架构设计，各类规范，形成公司自己的技术方案标准等等', 0, '2020-01-12 21:39:06');

INSERT INTO `db_employee_information`.`employee_position_t`(`dept_id`, `position_name`, `position_desc`, `delete_flag`, `create_time`)
VALUES ('DEPT001', '财务总监', '负责整个财务的运作和公司的财务管理', 0, '2020-01-12 21:39:06');
INSERT INTO `db_employee_information`.`employee_position_t`(`dept_id`, `position_name`, `position_desc`, `delete_flag`, `create_time`)
VALUES ('DEPT001', '财务经理', '负责公司的整个财务经营状况', 0, '2020-01-12 21:39:06');
INSERT INTO `db_employee_information`.`employee_position_t`(`dept_id`, `position_name`, `position_desc`, `delete_flag`, `create_time`)
VALUES ('DEPT001', '财务副经理', '协助财务经理工作', 0, '2020-01-12 21:39:06');
INSERT INTO `db_employee_information`.`employee_position_t`(`dept_id`, `position_name`, `position_desc`, `delete_flag`, `create_time`)
VALUES ('DEPT001', '财务主管', '负责总账等主要财务工作', 0, '2020-01-12 21:39:06');
INSERT INTO `db_employee_information`.`employee_position_t`(`dept_id`, `position_name`, `position_desc`, `delete_flag`, `create_time`)
VALUES ('DEPT001', '会计', '应收会计、应付会计、材料会计、成本会计、税务会计、费用会计等等', 0, '2020-01-12 21:39:06');
INSERT INTO `db_employee_information`.`employee_position_t`(`dept_id`, `position_name`, `position_desc`, `delete_flag`, `create_time`)
VALUES ('DEPT001', '出纳', '负责现金和银行的日记账', 0, '2020-01-12 21:39:06');


INSERT INTO `db_employee_information`.`employee_position_t`(`dept_id`, `position_name`, `position_desc`, `delete_flag`, `create_time`)
VALUES ('DEPT004', '行政主管', '行政负责单位的直接工作，人事是分管人员安排，档案和人力资源的有效利用', 0, '2020-01-12 21:39:06');
INSERT INTO `db_employee_information`.`employee_position_t`(`dept_id`, `position_name`, `position_desc`, `delete_flag`, `create_time`)
VALUES ('DEPT004', '行政经理', '计划、指导和协调机构的支持性服务', 0, '2020-01-12 21:39:06');

INSERT INTO `db_employee_information`.`employee_position_t`(`dept_id`, `position_name`, `position_desc`, `delete_flag`, `create_time`)
VALUES ('DEPT005', '人事部总监', '定期与相关部门经理/总监审核并修订公司的组织结构图和人员编制', 0, '2020-01-12 21:39:06');
INSERT INTO `db_employee_information`.`employee_position_t`(`dept_id`, `position_name`, `position_desc`, `delete_flag`, `create_time`)
VALUES ('DEPT005', '人事部经理', '组织并督促部门人员全面完成本部职责范围内各项工作任务', 0, '2020-01-12 21:39:06');
INSERT INTO `db_employee_information`.`employee_position_t`(`dept_id`, `position_name`, `position_desc`, `delete_flag`, `create_time`)
VALUES ('DEPT005', '人事部主管', '负责人事工作制度的制定与完善', 0, '2020-01-12 21:39:06');

INSERT INTO `db_employee_information`.`employee_position_t`(`dept_id`, `position_name`, `position_desc`, `delete_flag`, `create_time`)
VALUES ('DEPT006', '采购部部长', '负责部门的相关方案拟定、检查、监督、控制与执行', 0, '2020-01-12 21:39:06');
INSERT INTO `db_employee_information`.`employee_position_t`(`dept_id`, `position_name`, `position_desc`, `delete_flag`, `create_time`)
VALUES ('DEPT006', '采购部经理', '负责汇总设计部的申请采购，编制采购计划，经过采购总监的审核后组织实施', 0, '2020-01-12 21:39:06');

DROP TABLE IF EXISTS `employee_staff_user_t`;
CREATE TABLE `employee_staff_user_t`(
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id,用于后台系统',
  `emp_id` varchar(255) DEFAULT NULL COMMENT '员工号'
)ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='企业员工和后台管理系统用户关联表';

DROP TABLE IF EXISTS `employee_menu_t`;
CREATE TABLE `employee_menu_t`(
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `icon` varchar(64) DEFAULT NULL COMMENT '菜单图标',
  `index` varchar(64) DEFAULT NULL COMMENT '菜单名称 vue的页面名称',
  `title` varchar(64) DEFAULT NULL COMMENT '菜单名称',
  `is_sub` tinyint(1) DEFAULT NULL COMMENT '是否子菜单 0为根菜单 1为子菜单',
  `parent_id` int(11) DEFAULT NULL COMMENT '父菜单id',
  `role` varchar(64) DEFAULT NULL COMMENT '菜单权限 菜单开放权限',
  `delete_flag` tinyint(1) DEFAULT '0' COMMENT '是否有效 0有效 1删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '创建者，记录创建者信息',
  `last_update_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '修改者，记录修改者信息',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='企业员工和后台管理系统菜单管理表';

INSERT INTO `employee_menu_t` VALUES (100, 'iconfont icon-wen-home', 'index', '员工管理', 0, NULL, '100', 0, '2020-01-02 17:53:14', '2020-01-05 23:51:40', 'admin', 'admin');
INSERT INTO `employee_menu_t` VALUES (101, 'iconfont icon-wen-home', 'menus', '菜单管理', 0, NULL, '101', 0, '2020-01-02 17:53:14', '2020-01-05 20:42:54', 'admin', 'admin');
INSERT INTO `employee_menu_t` VALUES (102, 'iconfont icon-wen-home', 'wages', '薪资管理', 0, NULL, '102', 0, '2020-01-02 17:53:14', '2020-01-05 20:42:40', 'admin', 'admin');
INSERT INTO `employee_menu_t` VALUES (103, 'iconfont icon-wen-home', 'wagesGrant', '发放薪资', 1, 102, '100', 0, '2020-01-02 17:53:14', '2020-01-05 20:50:36', 'admin', 'admin');
INSERT INTO `employee_menu_t` VALUES (104, 'iconfont icon-wen-home', 'wagesQuery', '薪资查询', 1, 102, '102', 0, '2020-01-02 17:53:14', '2020-01-05 20:50:46', 'admin', 'admin');
INSERT INTO `employee_menu_t` VALUES (105, 'iconfont icon-wen-home', 'wagesChange', '薪资变更', 1, 102, '102', 0, '2020-01-02 17:53:14', '2020-01-05 20:50:53', 'admin', 'admin');
INSERT INTO `employee_menu_t` VALUES (106, 'iconfont icon-wen-home', 'userList', '员工列表', 1, 100, '101', 0, '2020-01-05 23:14:05', '2020-01-05 23:51:46', 'admin', 'admin');


DROP TABLE IF EXISTS `employee_staff_wages_t`;
CREATE TABLE `employee_staff_wages_t`(
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `emp_id` varchar(255) DEFAULT NULL COMMENT '员工号',
  `emp_name` varchar(255) DEFAULT NULL COMMENT '员工姓名',
  `period` varchar(64) DEFAULT NULL COMMENT '薪资发放期间',
  `base_wages` double DEFAULT NULL COMMENT '基本工资',
  `subsidy` double DEFAULT NULL COMMENT '补贴',
  `tax` double DEFAULT NULL COMMENT '税前扣款',
  `real_wages` double DEFAULT NULL COMMENT '实发工资',
  `delete_flag` tinyint(1) DEFAULT '0' COMMENT '是否有效 0有效 1删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '创建者，记录创建者信息',
  `last_update_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '修改者，记录修改者信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='企业员工薪资表';
INSERT INTO `db_employee_information`.`employee_staff_wages_t`(`emp_id`, `emp_name`, `period`, `base_wages`, `subsidy`, `tax`, `real_wages`, `delete_flag`, `create_time`)
VALUES ('JXNC0001', '刘应兴', '2019-12', 8000, 0, 1666.54, 6333.46, 0, '2020-01-01 22:46:35');


DROP TABLE IF EXISTS `employee_work_attendance_t`;
CREATE TABLE `employee_work_attendance_t`(
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `emp_id` varchar(255) DEFAULT NULL COMMENT '员工号',
  `emp_name` varchar(255) DEFAULT NULL COMMENT '员工姓名',
  `start_time` varchar(20) DEFAULT NULL COMMENT '签到时间',
  `end_time` varchar(20) DEFAULT NULL COMMENT '最后一次签退时间',
  `start_ip` varchar(20) DEFAULT NULL COMMENT '签到电脑ip',
  `end_ip` varchar(20) DEFAULT NULL COMMENT '签退电脑ip',
  `absence_duty_flag` tinyint(1) DEFAULT NULL COMMENT '缺勤标识 0正常 1未签到 2未签退',
  `reason` varchar(64) DEFAULT NULL COMMENT '缺勤原因',
  `attendance_time` varchar(64) DEFAULT NULL COMMENT '考勤日期',
  `delete_flag` tinyint(1) DEFAULT '0' COMMENT '是否有效 0有效 1删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '创建者，记录创建者信息',
  `last_update_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '修改者，记录修改者信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='企业员工考勤表';