package com.gkyt.jwgk.domain.version;

import com.gkzx.shared.domain.model.VersionedAggregateRoot;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Version extends VersionedAggregateRoot {
    @Column(nullable = false)
    String versionNumber;
}
