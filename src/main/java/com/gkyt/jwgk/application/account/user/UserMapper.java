package com.gkyt.jwgk.application.account.user;

import com.gkyt.jwgk.domain.account.user.User;
import org.modelmapper.*;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserModel mapToUserModel(User user) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(user, UserModel.class);
    }

}
