package com.gkyt.jwgk.interfaces.account;

import com.gkyt.jwgk.application.account.user.UserApplicationService;
import com.gkyt.jwgk.application.account.user.UserModel;
import com.gkyt.jwgk.domain.account.user.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * {@code UserController} is the user information class under account information.
 * <p>
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
     *
     * @param userId userId
     * @return {@link UserModel}
     */
    @GetMapping("/{id}")
    public UserModel get(@PathVariable("id") String userId) {
        return userApplicationService.get(userId);
    }

    /**
     * 多条件分页查询
     */
    @GetMapping
    public Page<UserModel> getPaged(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String roleId,
            @RequestParam(required = false) UserStatus status,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date createdStartDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date createdEndDate,
            @PageableDefault(size = 2) Pageable pageable) {
        return userApplicationService.getPaged(username, phone, roleId, status, createdStartDate, createdEndDate, pageable);
    }
}
