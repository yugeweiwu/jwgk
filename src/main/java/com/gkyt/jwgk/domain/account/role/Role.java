package com.gkyt.jwgk.domain.account.role;

import com.gkzx.shared.domain.model.VersionedAggregateRoot;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Role extends VersionedAggregateRoot {
    @Column
    String roleName;
}
