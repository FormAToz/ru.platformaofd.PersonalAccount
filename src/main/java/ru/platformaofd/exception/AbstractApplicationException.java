package ru.platformaofd.exception;

/**
 * Абстрактный класс исключений приложения
 */
public abstract class AbstractApplicationException extends RuntimeException{
    protected int errorCode;

    public AbstractApplicationException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
