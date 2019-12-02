package com.gkyt.jwgk.application.account.user;

import com.gkyt.jwgk.domain.account.user.User;
import com.gkyt.jwgk.domain.account.user.UserService;
import com.gkyt.jwgk.domain.account.user.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * service
 *
 * @author jack yu
 */
@Service
public class UserApplicationService {

    private final UserMapper userMapper;
    private final UserService userService;

    /**
     * get
     * @param userMapper
     * @param userService
     */
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

    public Page<UserModel> getPaged(String username, String phone, Pageable pageable){
        UserSpecification userSpecification = new UserSpecification(username,phone);
        Page<User> users = userService.getPaged(userSpecification,pageable);
        return userMapper.mapToClientModels(users);
    }
}
