-- 用户表
CREATE TABLE IF NOT EXISTS `user` (
	`id` VARCHAR(255) NOT NULL,
	`user_name` VARCHAR(50) NOT NULL,
	`pass_word` VARCHAR(50) NOT NULL,
	`phone` VARCHAR(50) NOT NULL,
	`status` int(11) DEFAULT NULL,
	`created_time` datetime NOT NULL,
    `last_updated_time` datetime DEFAULT NULL,
    `version` bigint(20) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE KEY `UK2lcfdkjf5bcn2bs7kfwyjhr91` (`user_name`),
    UNIQUE KEY `UK2gfb2tx8tdjwc1mxykw7yj29h` (`phone`)
)
    ENGINE = InnoDB;

-- 角色表
CREATE TABLE IF NOT EXISTS `role` (
	`id` VARCHAR(255) NOT NULL,
	`role_name` VARCHAR(50) NOT NULL,
	`created_time` datetime NOT NULL,
    `last_updated_time` datetime DEFAULT NULL,
    `version` bigint(20) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE KEY `UK1kv52a3c1plew34axyr64gbgx` (`role_name`)
)
    ENGINE = InnoDB;

-- 用户角色表
CREATE TABLE IF NOT EXISTS `user_role` (
  `id`      varchar(255)  NOT NULL,
  `role_id` varchar(255)  NOT NULL,
  `user_id` varchar(255)  NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
)
    ENGINE = InnoDB;
