package com.gkyt.jwgk.domain.account.user;

import com.gkzx.shared.domain.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User get(String id) {
        User user = userRepository.findOne(id);
        if (user == null) {
            throw new NotFoundException();
        }
        return user;
    }

    public Page<User> getPaged(Specification<User> specification, Pageable pageable) {
        return userRepository.findAll(specification, pageable);
    }

    public User add(User user) {
        return userRepository.save(user);
    }
}
