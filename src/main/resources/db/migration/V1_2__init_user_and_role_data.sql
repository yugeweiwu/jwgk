SELECT UUID() INTO @roleId;
SELECT UUID() INTO @uesrId;

-- 用户数据
insert into `user` (`id`,`user_name`,`pass_word`,`phone`,`status`,`created_time`,`version`)
VALUES (@uesrId,'jwt_admin','1234','1232112',1,NOW(),0);

-- 角色数据
insert into `role` (`id`,`role_name`,`created_time`,`version`)
VALUES (@roleId,'admin',NOW(),0);

-- 用户角色数据
INSERT INTO `user_role` (`id`, `user_id`, `role_id`)
VALUES (UUID(),@uesrId,@roleId);