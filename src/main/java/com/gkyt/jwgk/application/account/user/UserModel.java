package com.gkyt.jwgk.application.account.user;

import com.gkyt.jwgk.domain.account.user.UserStatus;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
public class UserModel {
    private String userName;
    private String passWord;
    private String phone;
    private UserStatus status;
    private Date createdTime;
    private Date lastUpdatedTime;
    // private List<UserRoleModel> userRoles;
}