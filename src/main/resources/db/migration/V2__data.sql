-- 用户数据
insert into `user` (`id`,`user_name`,`pass_word`,`phone`,`created_time`,`version`)
VALUES (UUID(),'yaya','123','12321',NOW(),1),
(UUID(),'lala','234','1232',NOW(),1),
(UUID(),'wawa','345','3265',NOW(),1);

-- 角色数据
insert into `role` (`id`,`role_name`,`created_time`,`version`)
VALUES (1,'admin',NOW(),2),
(2,'audit',NOW(),2);
