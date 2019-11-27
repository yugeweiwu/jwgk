-- 用户表
CREATE TABLE `user` (
	`id` TINYINT(4) NOT NULL,
	`user_name` VARCHAR(50) NOT NULL,
	`pass_word` VARCHAR(50) NOT NULL,
	`phone` VARCHAR(50) NOT NULL,
	`created_time` datetime NOT NULL,
    `last_updated_time` datetime DEFAULT NULL,
    `version` bigint(20) NOT NULL,
	PRIMARY KEY (`id`)
)