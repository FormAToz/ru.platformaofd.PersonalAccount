package ru.platformaofd.exception;

/**
 * Абстрактный класс исключений приложения
 */
public abstract class AbstractApplicationException extends RuntimeException{
    protected int code;

    public AbstractApplicationException(String message, int errorCode) {
        super(message);
        this.code = errorCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
