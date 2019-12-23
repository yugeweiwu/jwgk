package com.gkyt.jwgk.application.account.role;


import com.gkyt.jwgk.domain.account.role.Role;
import com.gkzx.shared.application.model.Mapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    RoleModel mapToRoleModel(Role role) {
        return new Mapper().map(role, RoleModel.class);
    }
}
