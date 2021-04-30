package ru.platformaofd.model.enums;

public enum ErrorCode {
    OK(0),
    USER_IS_EXISTS(1),
    TECHNICAL(2),
    USER_NOT_EXISTS(3),
    PASSWORD_INCORRECT(4);

    private final int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
