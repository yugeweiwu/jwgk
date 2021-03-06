package com.gkyt.jwgk.application.account.user;

import com.gkyt.jwgk.domain.account.user.User;
import com.gkyt.jwgk.domain.account.user.UserService;
import com.gkyt.jwgk.domain.account.user.UserSpecification;
import com.gkyt.jwgk.domain.account.user.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserApplicationService {
    private final UserMapper userMapper;
    private final UserService userService;

    @Autowired
    public UserApplicationService(
            UserMapper userMapper,
            UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    public UserModel get(String userId) {
        User user = userService.get(userId);
        return userMapper.mapToUserModel(user);
    }

    public Page<UserModel> getPaged(String username, String phone, String roleId,
                                    UserStatus status, Date createdStartDate, Date createdEndDate, Pageable pageable) {
        UserSpecification userSpecification = new UserSpecification(username, phone, roleId, status, createdStartDate, createdEndDate);
        Page<User> users = userService.getPaged(userSpecification, pageable);
        return userMapper.mapToClientModels(users);
    }

    public UserModel add(UserModel userModel) {
        //check
        User user = userMapper.mapToUser(userModel);
        User createdUser = userService.add(user);
        return userMapper.mapToUserModel(createdUser);
    }
}
