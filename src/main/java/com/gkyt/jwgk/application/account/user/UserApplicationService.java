package com.gkyt.jwgk.application.account.user;

import com.gkyt.jwgk.domain.account.user.User;
import com.gkyt.jwgk.domain.account.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public UserModel get(String id) {
        User user = userService.get(id);
        return userMapper.mapToUserModel(user);
    }
}
