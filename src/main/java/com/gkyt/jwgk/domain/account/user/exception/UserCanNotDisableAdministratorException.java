package com.gkyt.jwgk.domain.account.user.exception;

import com.gkzx.shared.domain.exception.DomainException;

public class UserCanNotDisableAdministratorException extends DomainException {
    private static final String CODE = "user.CanNotDisableAdministrator";

    public UserCanNotDisableAdministratorException() {
        super(CODE);
    }
}
