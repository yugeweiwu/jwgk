package com.gkyt.jwgk.interfaces.account;

import com.gkyt.jwgk.application.account.role.RoleApplicationService;
import com.gkyt.jwgk.application.account.role.RoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    private final RoleApplicationService roleApplicationService;

    @Autowired
    public RoleController(RoleApplicationService roleApplicationService) {
        this.roleApplicationService = roleApplicationService;
    }

    @GetMapping("/{id}")
    public RoleModel get(@PathVariable("id") String roleId) {
        return roleApplicationService.get(roleId);
    }
}
