package com.gkyt.jwgk.domain.account.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository UserRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        UserRepository = userRepository;
    }

    public User get(String id) {
        User user = UserRepository.getOne(id);
        if (user == null) {
        }
        return user;
    }
}
