package com.gkyt.jwgk.interfaces.account.user;

import com.gkyt.jwgk.application.account.user.UserApplicationService;
import com.gkyt.jwgk.application.account.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserApplicationService userApplicationService;

    @Autowired
    public UserController(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    @GetMapping("/{id}")
    public UserModel get(@PathVariable("id") String id){
        return userApplicationService.get(id);
    }
}
