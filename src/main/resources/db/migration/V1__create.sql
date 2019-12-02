-- 用户表
CREATE TABLE `user` (
	`id` VARCHAR(255) NOT NULL,
	`user_name` VARCHAR(50) NOT NULL,
	`pass_word` VARCHAR(50) NOT NULL,
	`phone` VARCHAR(50) NOT NULL,
	`created_time` datetime NOT NULL,
    `last_updated_time` datetime DEFAULT NULL,
    `version` bigint(20) NOT NULL,
	PRIMARY KEY (`id`)
);

-- 角色表
CREATE TABLE `role` (
	`id` VARCHAR(255) NOT NULL,
	`role_name` VARCHAR(50) NOT NULL,
	`created_time` datetime NOT NULL,
    `last_updated_time` datetime DEFAULT NULL,
    `version` bigint(20) NOT NULL,
	PRIMARY KEY (`id`)
);
