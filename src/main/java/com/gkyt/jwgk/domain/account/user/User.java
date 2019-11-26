package com.gkyt.jwgk.domain.account.user;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    String id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String pwd;
}
