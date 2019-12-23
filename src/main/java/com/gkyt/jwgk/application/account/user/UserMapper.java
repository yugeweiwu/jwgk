package com.gkyt.jwgk.application.account.user;

import com.gkyt.jwgk.domain.account.user.User;
import com.gkzx.shared.application.model.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    UserModel mapToUserModel(User user) {
        return new Mapper().map(user, UserModel.class);
    }

    Page<UserModel> mapToClientModels(Page<User> users) {
        return new Mapper().map(users, UserModel.class);
    }

}
