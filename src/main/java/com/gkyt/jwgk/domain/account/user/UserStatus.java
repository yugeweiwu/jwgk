package com.gkyt.jwgk.domain.account.user;

public enum UserStatus {
    ENABLED("启用"),
    DISABLED("禁用");

    private final String description;

    UserStatus(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
