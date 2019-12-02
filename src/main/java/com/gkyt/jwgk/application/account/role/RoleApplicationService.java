package com.gkyt.jwgk.application.account.role;

import com.gkyt.jwgk.domain.account.role.Role;
import com.gkyt.jwgk.domain.account.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleApplicationService {
    private final RoleMapper roleMapper;
    private final RoleService roleService;

    @Autowired
    public RoleApplicationService(RoleMapper roleMapper,RoleService roleService){
        this.roleMapper = roleMapper;
        this.roleService = roleService;
    }

    public RoleModel get(String roleId){
        Role role = roleService.get(roleId);
        return roleMapper.mapToRoleModel(role);
    }
}
