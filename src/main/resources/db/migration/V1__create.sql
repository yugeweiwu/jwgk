-- 用户表
CREATE TABLE `user` (
	`id` TINYINT(4) NOT NULL,
	`name` VARCHAR(50) NOT NULL,
	`pwd` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`)
)