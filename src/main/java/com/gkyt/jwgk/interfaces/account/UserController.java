package com.gkyt.jwgk.interfaces.account;

import com.gkyt.jwgk.application.account.user.UserApplicationService;
import com.gkyt.jwgk.application.account.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

/**
 * {@code UserController} is the user information class under account information.
 *
 * <p>This is a paragraph <em>but don't know what to write</em>.
 *
 * @author jack fu
 * @version 1.0
 * @see UserApplicationService
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserApplicationService userApplicationService;

    @Autowired
    public UserController(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    /**
     * Gets individual user information
     * @param id userId
     * @return {@link UserModel}
     */
    @GetMapping("/{id}")
    public UserModel get(@PathVariable("id") String id){
        return userApplicationService.get(id);
    }

    /**
     * 多条件分页查询
     */
    @GetMapping
    public Page<UserModel> getPaged(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String phone,
            @PageableDefault(size = 2) Pageable pageable) {
        //pageable有默认值吗？没有会报错  @PageableDefault??/
        return userApplicationService.getPaged(username,phone,pageable);
    }
}
