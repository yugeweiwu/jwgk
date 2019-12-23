package com.gkyt.jwgk.domain.account.user;

import com.gkzx.shared.domain.model.VersionedAggregateRoot;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends VersionedAggregateRoot {
    @Column(nullable = false)
    String userName;
    @Column(nullable = false)
    String passWord;
    @Column(nullable = false)
    String phone;
    @Column(unique = true)
    private UserStatus status;
    //private List<UserRole> userRoles = new ArrayList<>();
}
